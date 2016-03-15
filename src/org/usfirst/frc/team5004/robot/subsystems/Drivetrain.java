package org.usfirst.frc.team5004.robot.subsystems;

import org.usfirst.frc.team5004.robot.Robot;
import org.usfirst.frc.team5004.robot.RobotMap;
import org.usfirst.frc.team5004.robot.commands.TankDrive;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Drivetrain extends Subsystem {
	
	public Drivetrain(){
		super();
		
		LiveWindow.addActuator("Drivetrain", "Left motor 1", (CANTalon) l1);
		LiveWindow.addActuator("Drivetrain", "Left motor 2", (CANTalon) l2);
		LiveWindow.addActuator("Drivetrain", "Right motor 1", (CANTalon) r1);
		LiveWindow.addActuator("Drivetrain", "Right motor 2", (CANTalon) r2);
	}
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	//local variables for joysticks
	//Joystick joyLeft = Robot.oi.joyDriverLeft;
	//Joystick joyRight = Robot.oi.joyDriverRight;
	
	//initialize motor controllers from port numbers
	CANTalon l1 = new CANTalon(RobotMap.leftMotor1);
	CANTalon l2 = new CANTalon(RobotMap.leftMotor2);
	CANTalon r1 = new CANTalon(RobotMap.rightMotor1);
	CANTalon r2 = new CANTalon(RobotMap.rightMotor2);
	
	public void init(){
	/*	//tell motor l2 to follow l1
		l2.changeControlMode(TalonControlMode.Follower);
		l2.set(RobotMap.leftMotor1);
		
		//tell motor r2 to follow r1
		r2.changeControlMode(TalonControlMode.Follower);
		r2.set(RobotMap.rightMotor1);*/
	}

	public void tankDrive(){
		//set motor speeds to joystick values
		double left = 0.0;
		double right = 0.0;
		int top = Robot.oi.joyDriverRight.getPOV();
		
		SmartDashboard.putNumber("Top", top);
		
		switch(top){
		
		case -1:
			left = -Robot.oi.joyDriverLeft.getY();
			right = Robot.oi.joyDriverRight.getY();
			break;
			
		case 0:
			left = 0.2;
			right = -0.2;
			break;
			
		case 90:
			left = 0.2;
			right = 0.2;
			break;
			
		case 180:
			left = -0.2;
			right = 0.2;
			break;
			
		case 270:
			left = -0.2;
			right = -0.2;
			break;
			
		default:
			left = -Robot.oi.joyDriverLeft.getY();
			right = Robot.oi.joyDriverRight.getY();
			break;
		}
		
		drive(left, right);
	}
	
	public void arcadeDrive(){
		double throttle = Robot.oi.joyDriverLeft.getY();
		double turn = Robot.oi.joyDriverLeft.getX();
		
		double left = -(throttle - turn);
		double right = (throttle + turn);
		
		drive(left, right);
	}
	
	public void drive(double l, double r){
		l1.set(l);
		l2.set(l);
		r1.set(r);
		r2.set(r);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new TankDrive());
    }
}

