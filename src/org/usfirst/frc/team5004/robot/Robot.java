
package org.usfirst.frc.team5004.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import org.usfirst.frc.team5004.robot.commands.ArmJoystick;
import org.usfirst.frc.team5004.robot.commands.AutoBasic;
import org.usfirst.frc.team5004.robot.commands.AutoGyro;
import org.usfirst.frc.team5004.robot.commands.AutoLowBar;
import org.usfirst.frc.team5004.robot.commands.CameraFeed;
import org.usfirst.frc.team5004.robot.commands.Dashboard;
import org.usfirst.frc.team5004.robot.commands.LiftJoystick;
import org.usfirst.frc.team5004.robot.commands.ResetGyro;
import org.usfirst.frc.team5004.robot.commands.TankDrive;
import org.usfirst.frc.team5004.robot.subsystems.Latch;
import org.usfirst.frc.team5004.robot.subsystems.Arm;
import org.usfirst.frc.team5004.robot.subsystems.Camera;
import org.usfirst.frc.team5004.robot.subsystems.Drivetrain;
import org.usfirst.frc.team5004.robot.subsystems.Gyroscope;
import org.usfirst.frc.team5004.robot.subsystems.Lift;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final Drivetrain drive = new Drivetrain();
	public static final Lift lift = new Lift();
	public static final Latch latch = new Latch();
	public static final Arm arm = new Arm();
	public static final Camera camera = new Camera();
	public static final Gyroscope gyro = new Gyroscope();
	public static OI oi;

    Command autonomousCommand;
    SendableChooser chooser;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	System.out.println("init");
    	
		oi = new OI();
        chooser = new SendableChooser();
        chooser.addDefault("Basic Auto", new AutoBasic());
        chooser.addObject("Gyro Auto", new AutoGyro());
        chooser.addObject("Low Bar Auto", new AutoLowBar());
        SmartDashboard.putData("Auto mode", chooser);
        
        Command dash = new Dashboard();
        
        dash.start();
        
        SmartDashboard.putData(drive);
        SmartDashboard.putData(lift);
        SmartDashboard.putData(latch);
        SmartDashboard.putData(arm);
        
        //camera.init();
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
        autonomousCommand = (Command) chooser.getSelected();
        
		/* String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		switch(autoSelected) {
		case "My Auto":
			autonomousCommand = new MyAutoCommand();
			break;
		case "Default Auto":
		default:
			autonomousCommand = new ExampleCommand();
			break;
		} */
    	
    	// schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
        
        Command dash = new Dashboard();
        Command reset = new ResetGyro();
        
        dash.start();
        reset.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        
        Command armCommand = new ArmJoystick();
        Command dash = new Dashboard();
        Command reset = new ResetGyro();
        //Command cameraCommand = new CameraFeed();
        
        armCommand.start();
        dash.start();
        reset.start();
        //cameraCommand.start();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
