package templates;

import org.usfirst.frc.team5468.polybot.polybot;

public abstract class AutoProgram {
	
	public polybot mainRobot;
	public String programName;
	public AutoProgram(polybot robot,String name)
	{
		mainRobot = robot;
		programName = name;
	}
	
	public abstract void autonomousInit();
	public abstract void autonomousPeriodic();
	public abstract void autonomousDisabledInit();
	public abstract void autonomousDisabledPeriodic();
	
}
