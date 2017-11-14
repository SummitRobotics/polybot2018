package org.usfirst.frc.team5468.polybot;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Joystick;

public class polybot {
	
	//------------------- ID Config -----------------------//
	// The settings for various robot parts are defined    //
	// here. When changing parts or part IDs please change //
	// the settings here, and don't make a new  motor in   //
	// some other random area of the code.                 //
	//-----------------------------------------------------//
	
	//--------- Drive Motors -------------//
	
		//Back left drive motor
		private int blDriveId = 29;
		
		//Front left drive motor
		private int flDriveId = 25;
		
		//Back right drive motor
		private int brDriveId = 24;
		
		//Front right drive motor
		private int frDriveId = 26;
		
		
	//------------- End of ID Config-------------//
	// You have reached the end of the config.   //
	// Unless you are adding or removing a new   //
	// part, you probably don't need to change   //
	// anything below here.                      //
	//-------------------------------------------//
	
	public CANTalon blDrive;
	public CANTalon flDrive;
	public CANTalon brDrive;
	public CANTalon frDrive;
	
	private ADXRS450_Gyro gyro;
	
	public Joystick gamepad1;
	public Joystick gamepad2;
	
	
	private double yawAngle = 0;
	
	public polybot(){
		
		//Attempt to create instances of all the parts listed above
		
		try {
			
			blDrive = new CANTalon(blDriveId);
			flDrive = new CANTalon(flDriveId);
			brDrive = new CANTalon(brDriveId);
			frDrive = new CANTalon(frDriveId);
			
			gyro = new ADXRS450_Gyro();
			
			
		}
		catch(Exception e){
			
		}
		
		//Attempt to create joysticks. We do this seperatly to ensure that a missing second joystick does not crash all the code
		
		try{
			gamepad1 = new Joystick(0);
			gamepad2 = new Joystick(1);
		}
		catch(Exception e){
			
		}
	
	}
	
	//----------- Helper Functions ----------//
	// Useful methods that will make things  //
	// easier. Read the comments for info    //
	// on each specific method               //
	//---------------------------------------//
	
	//Sets the power for both left drive motors
	public void setLeftPower(double power){
		blDrive.set(power);
		flDrive.set(power);
	}
	
	//Sets the power for both right drive motors
	public void setRightPower(double power){
		brDrive.set(power);
		frDrive.set(power);
	}
	
	//Enable all motors
	public void enableAllMotors(){
		blDrive.enable();
		flDrive.enable();
		brDrive.enable();
		frDrive.enable();
	}
	
	//Disable all motors
	public void edisableAllMotors(){
		blDrive.disable();
		flDrive.disable();
		brDrive.disable();
		frDrive.disable();
	}
	
	//Creates an exponential curve from a value. Mainly used for joystick input
	public double toExponential(double value, double exponent)
	{
		value = Math.pow(Math.abs(value), exponent) * Math.signum(value);
		
		return value;
	}
	
	double rawYawAngle;
	double overAngleCount;
	
	//TODO Make the getYaw() method actually work
	
	public double getYaw() {
		rawYawAngle = gyro.getAngle();
		return rawYawAngle % 360;
	}

}
