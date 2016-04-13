package org.usfirst.frc.team5004.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Gyro;

/**
 *
 */
public class Gyroscope extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	Gyro gyro = new AnalogGyro(0);
	
	public double angle(){
		return gyro.getAngle();
	}
	
	public void reset(){
		gyro.reset();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

