package org.usfirst.frc.team5004.robot.subsystems;

import org.usfirst.frc.team5004.robot.Robot;
import org.usfirst.frc.team5004.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class Arm extends Subsystem {
    
	public Arm(){
		super();
		
		LiveWindow.addActuator("Arm", "Arm Motor", (CANTalon) m);

	}
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	//local variables for joysticks
	//Joystick joystick = Robot.oi.joySecondary;
	
	//initialize motor controllers from port numbers
	CANTalon m = new CANTalon(RobotMap.armMotor);
	
	public void joystickControl(){
		m.set(Robot.oi.joySecondary.getY());
	}
	
	public void drive(double i){
		m.set(i);
	}
	
	public void stop(){
		m.set(0.0);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

