package control;

/**
 * Created by James on 1/18/2018.
 */

//Turn with a variable arc
public class arcTurn {
	
	//right
	private double x;
	//forward
	private double y;
	
	//max speed
	private double speed;
	
	//width of drive train
	final private double w = 33;
	
	private double leftDistance;
	private double leftSpeed;
	private double rightDistance;
	private double rightSpeed;
	
	//This determines whether the left or right side of
	//the drive train is the inner or outer arc of the turn
	//if true, angle is positive
	//if false angle is negative
	private boolean angle;
	
	/*
	 * The distance forward must be non zero
	 * Try and constrain to 45* arcs until thoroughly tested
	 * Use for autonomous only
	 */
	
	//setup values
	public arcTurn(double a, double b, double maxSpeed) {
		x = a;
		y = a;
		speed = maxSpeed;
		if(x >= 0) {
			angle = true;
		}
		else {
			angle = false;
		}
		assembleDistances();
	}
	
	//this calculates all the fun stuff
	//interestingly, the trigonomic functions cancelled themselves out
	private void assembleDistances() {
		if(angle) {
			leftDistance = ((w + x) / y) + y;
			leftSpeed = speed;
			
			rightDistance = y;
			rightSpeed = (y)/(((w + x) / y) + y);
		}
		else {
			rightDistance = ((w + x) / y) + y;
			rightSpeed = speed;
			
			leftDistance = y;
			leftSpeed = (y)/(((w + x) / y) + y);
		}
	}
	
	//pull values from methods, not variables
	//hence the private global variables
	
	//right distance
	public int rightD() {
		return (int) rightDistance;
	}
	
	//left distance
	public int leftD() {
		return (int) leftDistance;
	}
	
	//right speed
	public double rightS() {
		return rightSpeed;
	}
	
	//left speed
	public double leftS() {
		return leftSpeed;
	}
}
