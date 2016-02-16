package org.usfirst.frc.team5004.robot.subsystems;

import org.usfirst.frc.team5004.robot.Robot;
import org.usfirst.frc.team5004.robot.RobotMap;
import org.usfirst.frc.team5004.robot.commands.TankDrive;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	Joystick joyLeft = Robot.oi.joyDriverLeft;
	Joystick joyRight = Robot.oi.joyDriverRight;
	
	CANTalon motorLeft = new CANTalon(RobotMap.leftMotor);
	CANTalon motorRight = new CANTalon(RobotMap.rightMotor);

	public void tankDrive(){
		motorLeft.set(joyLeft.getY());
		motorRight.set(joyRight.getY());
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new TankDrive());
    }
}

