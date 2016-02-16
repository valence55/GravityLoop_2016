package org.usfirst.frc.team5004.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	
	//the two motors on the left side of the drivetrain
	public static int leftMotor1 = 1;
	public static int leftMotor2 = 2;
	
	//the two motors on the right side of the drivetrain
	public static int rightMotor1 = 3;
	public static int rightMotor2 = 4;
	
	//the two motors on the lift mechanism
	public static int liftMotor1 = 5;
	public static int liftMotor2 = 6;
	
	//the motor for the door opener thing
	public static int armMotor = 7;
}
