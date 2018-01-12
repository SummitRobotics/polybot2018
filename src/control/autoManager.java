package control;

import java.util.List;

public class autoManager {

	private double maxAccel = 400;
	private double maxVelo = 400;
	
	private List<Integer> leftTrajectoryList;
	private List<Integer> rightTrajectoryList;
	
	
	public autoManager( ) {
		
	}
	
	public void addStraight(double distance) {
		leftTrajectoryList.add(feetToEncoder(distance));
		rightTrajectoryList.add(feetToEncoder(distance));
	}
	
	public void addArc(double radius, int angle) {
		//TODO Implement arc movements
	}
	
	public void addPivot(int angle) {
		//TODO Implement pivot rotation
	}
	
	private int feetToEncoder(double distance) {
		//TODO Implement this conversion
		return 0;
	}
	
	public void run() {
		//TODO Implement this
	}
	
	
}
