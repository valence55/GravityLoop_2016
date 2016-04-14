package org.usfirst.frc.team5004.robot.commands;

import org.usfirst.frc.team5004.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoLowBar extends Command {

    public AutoLowBar() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.arm.drive(-0.5);
    	Timer.delay(2.0);
    	Robot.arm.drive(0.0);
    	Robot.drive.drive(0.7, -0.7);
    	Timer.delay(3.0);
    	Robot.drive.drive(0.0, 0.0);
    	Timer.delay(0.5);
    	/*Robot.drive.drive(-0.5, 0.5);
    	Timer.delay(4.0);
    	Robot.drive.drive(0.0, 0.0);
    	Timer.delay(0.5);
    	Robot.drive.drive(0.7, -0.7);
    	Timer.delay(3.0);
    	Robot.drive.drive(0.0, 0.0);*/
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
