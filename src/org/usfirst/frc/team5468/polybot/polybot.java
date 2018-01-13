package org.usfirst.frc.team5468.polybot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.*;
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
	
	private TalonSRX blDrive;
	public TalonSRX leftDrive;
	private TalonSRX brDrive;
	public TalonSRX rightDrive;
	
	private ADXRS450_Gyro gyro;
	
	public Joystick gamepad1;
	public Joystick gamepad2;
	
	
	private double yawAngle = 0;
	
	public polybot(){
		
		//Attempt to create instances of all the parts listed above
		
		try {
			
			blDrive = new TalonSRX(blDriveId);
			leftDrive = new TalonSRX(flDriveId);
			brDrive = new TalonSRX(brDriveId);
			rightDrive = new TalonSRX(frDriveId);
			
			gyro = new ADXRS450_Gyro();
			
			
		}
		catch(Exception e){
			
		}
		
		//Attempt to create joysticks.
		
		try{
			gamepad1 = new Joystick(0);
			gamepad2 = new Joystick(1);
		}
		catch(Exception e){
			
		}
		
		//Setup the Leader/Follow config. You should never have to individually touch the rear motors.
		blDrive.follow(leftDrive);
		brDrive.follow(rightDrive);
		
	
	}
	
	//----------- Helper Functions ----------//
	// Useful methods that will make things  //
	// easier. Read the comments for info    //
	// on each specific method               //
	//---------------------------------------//


	//Creates an exponential curve from a value. Mainly used for joystick input
	public double toExponential(double value, double exponent)
	{
		value = Math.pow(Math.abs(value), exponent) * Math.signum(value);
		
		return value;
	}
	
	//TODO Make the getYaw() method actually work
	
	public double getYaw() {
		return gyro.getAngle() % 360;
	}

}
