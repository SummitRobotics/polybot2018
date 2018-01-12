package teleop;

import org.usfirst.frc.team5468.polybot.polybot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class basicDrive extends templates.TeleopProgram {
	
	polybot polybot;
	
	double drivePower = 0;
	double steerPower = 0;
	
	double leftPower = 0;
	double rightPower = 0;
	
	// Constants
	
	static final float deadzone = 0.1f;
	static final float driveExponent = 1.8f;
	

	public basicDrive(polybot robot, String name) {
		super(robot, name);
		polybot = robot;
	}

	@Override
	public void teleopInit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void teleopPeriodic() {
		
		drivePower = polybot.toExponential(polybot.gamepad1.getZ() - polybot.gamepad1.getThrottle(), driveExponent);
		steerPower = polybot.toExponential(polybot.gamepad1.getX(), driveExponent);
		
		drivePower = deadzone(drivePower);
		steerPower = deadzone(steerPower);
		
		if(steerPower < 0.1 && steerPower > -0.1){
			steerPower = 0;
		}
		
		leftPower = drivePower - steerPower;
		rightPower = drivePower * -1 - steerPower;
		
		polybot.setLeftPower(leftPower);
		polybot.setRightPower(rightPower);
		
		SmartDashboard.putNumber("Bot Yaw", polybot.getYaw());
		SmartDashboard.putNumber("Right Power", rightPower);
		SmartDashboard.putNumber("Left Power", leftPower);
	}

	@Override
	public void teleopDisabledInit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void teleopDisabledPeriodic() {
		// TODO Auto-generated method stub
		
	}
	
	double deadzone(double power) {
		if(power < 0.1 && power > -0.1) {
			power = 0;
		}
		return power;
	}
	
	

}
