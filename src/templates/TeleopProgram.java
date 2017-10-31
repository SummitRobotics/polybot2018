package templates;

import org.usfirst.frc.team5468.polybot.polybot;

public abstract class TeleopProgram {
	public polybot mainRobot;
	public String programName;
	public TeleopProgram(polybot robot,String name)
	{
		mainRobot = robot;
		programName = name;
	}
	
	public abstract void teleopInit();
	public abstract void teleopPeriodic();
	public abstract void teleopDisabledInit();
	public abstract void teleopDisabledPeriodic();
}

