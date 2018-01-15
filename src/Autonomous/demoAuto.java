package Autonomous;

import org.usfirst.frc.team5468.polybot.polybot;

import control.autoManager;

public class demoAuto extends templates.AutoProgram {

	polybot robot;
	autoManager demoAuto; 
	
	
	public demoAuto(polybot robot, String name) {
		super(robot, name);
		this.robot = robot;
	}


	@Override
	public void autonomousInit() {
		
		demoAuto.addStraight(5 * 12);
		demoAuto.dropCube();
		demoAuto.addStraight(-3 * 12);
		demoAuto.addPivot(90);
		demoAuto.addArc(10, 25);
		demoAuto.addStraight(5 * 12);
		demoAuto.end();

	}


	@Override
	public void autonomousPeriodic() {
		
		demoAuto.run();
		
		if(demoAuto.isDone()) {
			//You can now do something here if you want, the robot should had stopped itself by this point.
		}
	}


	@Override
	public void autonomousDisabledInit() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void autonomousDisabledPeriodic() {
		// TODO Auto-generated method stub
		
	}
	
	

	
	
}
