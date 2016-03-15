package org.usfirst.frc.team5004.robot.commands;

import org.usfirst.frc.team5004.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class CameraFeed extends Command {

	public CameraFeed(){
		requires(Robot.camera);
	}
	
	protected void initialize() {
		Robot.camera.accuire();
	}

	protected void execute() {
		Robot.camera.image();
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.camera.stop();
	}

	protected void interrupted() {
		
	}

}