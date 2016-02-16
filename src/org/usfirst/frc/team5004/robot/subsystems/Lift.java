package org.usfirst.frc.team5004.robot.subsystems;

import org.usfirst.frc.team5004.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Lift extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	//initialize motor controllers from port numbers
	CANTalon m1 = new CANTalon(RobotMap.liftMotor1);
	CANTalon m2 = new CANTalon(RobotMap.liftMotor2);
	
	public void init(){
		//tell motor m2 to follow m1
		m2.changeControlMode(TalonControlMode.Follower);
		m2.set(RobotMap.leftMotor1);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

