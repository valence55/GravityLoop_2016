package org.usfirst.frc.team5004.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ToolSelect extends Command {

	boolean usingLift = false;
	boolean finished = false;
	
    public ToolSelect() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(usingLift){
    		Command liftStop = new StopLift();
    		Command armCommand = new ArmJoystick();
    		
    		liftStop.start();
    		armCommand.start();
    		
    		usingLift = false;
    	}else{
    		Command armStop = new StopArm();
    		Command liftCommand = new LiftJoystick();
    		
    		armStop.start();
    		liftCommand.start();
    		
    		usingLift = true;
    	}
    	
    	finished = true;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
