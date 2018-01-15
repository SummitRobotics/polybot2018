package control;

import java.util.List;

import org.usfirst.frc.team5468.polybot.polybot;

import com.ctre.phoenix.motorcontrol.ControlMode;

public class autoManager {

	private polybot robot;
	
	//TODO Set the error to finish that trajectory point
	private static double finishedError = 0;
	
	private List<trajectoryPoint> trajectoryPointList;
	
	private int trajectoryState;
	private int lastTrajectoryState;
	private boolean trajectoryClosed;
	private int totalTrajectoryPoints;
	
	private int fGain;
	private int pGain;
	private int iGain;
	private int dGain;
	
	private boolean leftDone;
	private boolean rightDone;
	
	public autoManager(polybot robot) {
		trajectoryState = 0;
		trajectoryClosed = false;
		this.robot = robot;
		
		//TODO Implement various gain and sensor settings for the talons
	}
	
	public void addStraight(double distance) {

		trajectoryPointList.add( new trajectoryPoint(inchesToEncoder(distance),inchesToEncoder(distance)) );
	}
	
	public void addArc(double radius, int angle) {
		//TODO Implement arc movements
	}
	
	public void addPivot(int angle) {
		//TODO Implement pivot rotation
	}
	
	public void dropCube() {
		//Empty method just for the example.
	}
	
	public boolean isDone() {
		return trajectoryState >= totalTrajectoryPoints;
	}
	
	public void end() {
		trajectoryClosed = true;
		totalTrajectoryPoints = trajectoryPointList.size();
	}
	
	private int inchesToEncoder(double distance) {
		return (int) Math.round(((distance) / (Math.PI*(9)) * 4096));
	}
	
	private void incTrajectoryState() {
		if(trajectoryState < totalTrajectoryPoints) {
			lastTrajectoryState = trajectoryState;
			trajectoryState++;
		}
		
	}
	
	public void run() {

		//The trajectory path must be closed before it will run. Call end() after defining all points
		if(!trajectoryClosed) {
			return;
		}
		
		leftDone = false;
		rightDone = false;
		
		//Tell the encoders the values to move to again
		robot.leftDrive.set(ControlMode.MotionMagic, trajectoryPointList.get(trajectoryState).getLeftTargetPoint());
		robot.rightDrive.set(ControlMode.MotionMagic, trajectoryPointList.get(trajectoryState).getRightTargetPoint());
		
		//Check if the left side has reached its target
		if(robot.leftDrive.getClosedLoopError(0) < finishedError) {
			leftDone = true;
		} 
		
		//Then check the right side
		if(robot.rightDrive.getClosedLoopError(0) < finishedError) {
			rightDone = true;
		} 
				
		
		//If both the left and right sides have reached their target it is now time to move on
		if(leftDone && rightDone) {
			incTrajectoryState();
		}
	}
	
	
}
