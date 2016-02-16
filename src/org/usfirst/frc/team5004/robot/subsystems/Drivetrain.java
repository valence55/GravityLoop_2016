package org.usfirst.frc.team5004.robot.subsystems;

import org.usfirst.frc.team5004.robot.Robot;
import org.usfirst.frc.team5004.robot.RobotMap;
import org.usfirst.frc.team5004.robot.commands.TankDrive;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	Joystick joyLeft = Robot.oi.joyDriverLeft;
	Joystick joyRight = Robot.oi.joyDriverRight;
	
	CANTalon l1 = new CANTalon(RobotMap.leftMotor1);
	CANTalon l2 = new CANTalon(RobotMap.leftMotor2);
	CANTalon r1 = new CANTalon(RobotMap.rightMotor1);
	CANTalon r2 = new CANTalon(RobotMap.rightMotor2);
	
	public void init(){
		l2.changeControlMode(TalonControlMode.Follower);
		l2.set(RobotMap.leftMotor1);
		
		r2.changeControlMode(TalonControlMode.Follower);
		r2.set(RobotMap.rightMotor1);
	}

	public void tankDrive(){
		r1.set(joyLeft.getY());
		r2.set(joyRight.getY());
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new TankDrive());
    }
}

