package org.usfirst.frc.team5004.robot.subsystems;

import org.usfirst.frc.team5004.robot.Robot;
import org.usfirst.frc.team5004.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	//local variables for joysticks
	Joystick joystick = Robot.oi.joySecondary;
	
	//initialize motor controllers from port numbers
	CANTalon m = new CANTalon(RobotMap.armMotor);
	
	public void joystickControl(){
		//set motor speed to joystick value
		m.set(joystick.getY());
	}
	
	public void stop(){
		m.set(0.0);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

