package org.usfirst.frc.team5004.robot.subsystems;

import org.usfirst.frc.team5004.robot.commands.CameraFeed;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.ShapeMode;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Camera extends Subsystem{

	Image i;
	NIVision.Rect rect;
	
	int session;
	
	public void init(){ // initialization function
		boolean done = false;
		
		while(!done){
			try{
				i = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0); //create a blank image

		        session = NIVision.IMAQdxOpenCamera("cam0", //access the camera
		                NIVision.IMAQdxCameraControlMode.CameraControlModeController);
		        NIVision.IMAQdxConfigureGrab(session);
		        done = true;
			}catch(Exception e){
				done = false;
			}
		}
	}
	
	public void accuire(){ //start pulling images from the camera
		NIVision.IMAQdxStartAcquisition(session);
		
		rect = new NIVision.Rect(10, 10, 100, 100);
	}
	
	public void stop(){//stop pulling images from the camera
		NIVision.IMAQdxStopAcquisition(session);
	}
	
	public void image(){

	    NIVision.IMAQdxGrab(session, i, 1); //pull one image from the camera
	            
	    CameraServer.getInstance().setImage(i); //send image to the driver station 
	    Timer.delay(0.005); //wait for the driver station to update
	}
	
	
	
	protected void initDefaultCommand() {
		//setDefaultCommand(new CameraFeed());
	}

}

