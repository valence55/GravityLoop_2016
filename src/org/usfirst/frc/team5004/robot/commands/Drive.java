package org.usfirst.frc.team5004.robot.commands;

import org.usfirst.frc.team5004.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Drive extends Command {

	double left;
	double right;
	double time;
	boolean done;
	
    public Drive(double l, double r, double t) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drive);
        left = l;
        right = r;
        time = t;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drive.drive(left, right);
    	Timer.delay(time);
    	Robot.drive.drive(left, right);
    	done = true;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return done;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drive.drive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
