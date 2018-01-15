package org.usfirst.frc.team5468.polybot;

import Autonomous.demoAuto;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import teleop.basicDrive;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	final String defaultAuto = "Default";
	final String customAuto = "My Auto";
	basicDrive teleop;
	demoAuto auto;
	String autoSelected;
	SendableChooser<String> chooser = new SendableChooser<>();
	static polybot robot;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		chooser.addDefault("Default Auto", defaultAuto);
		chooser.addObject("My Auto", customAuto);
		SmartDashboard.putData("Auto choices", chooser);
		robot = new polybot();
		teleop = new basicDrive(robot, "Basic Drive");
		auto = new demoAuto(robot,  "Test Auto");
	}

	//TODO Still need to implement the file selector. Hardcoding this in is bad.
	@Override
	public void autonomousInit() {
		auto.autonomousInit();
	}

	@Override
	public void autonomousPeriodic() {
		auto.autonomousPeriodic();
	}
	
	//TODO Make the program selector work / make it not auto choose the teleop.

	@Override
	public void teleopInit(){
		teleop.teleopInit();
	}
	
	@Override
	public void teleopPeriodic() {
		teleop.teleopPeriodic();
	}
	

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
	}
	
}

