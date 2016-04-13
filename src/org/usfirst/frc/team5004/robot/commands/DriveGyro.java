package org.usfirst.frc.team5004.robot.commands;

import org.usfirst.frc.team5004.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveGyro extends Command {

	double targetAngle;
	double speed;
	double Kp = 0.03;
	boolean done = false;
	
    public DriveGyro(double s, double angle) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drive);
        targetAngle = angle; 
        speed = s;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double angle = Robot.gyro.angle();
    	
    	if(Math.abs(targetAngle - angle) > 15){
    		Robot.drive.driveAngle(-1.0, (targetAngle-angle)*Kp);
    	}else{
    		Robot.drive.drive(0.0, 0.0);
    		done = true;
    	}
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
