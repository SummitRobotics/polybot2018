package control;

/**
 * Created by Colin on 1/14/2018.
 */
public class trajectoryPoint {

    private int leftTargetPoint;
    private int rightTargetPoint;
    private int velocityTarget = 400;
    private int accelerationTarget = 400;

    public trajectoryPoint(int leftTarget, int rightTarget) {
        leftTargetPoint = leftTarget;
        rightTargetPoint = rightTarget;
    }

    public trajectoryPoint(int leftTarget, int rightTarget, int velocity) {
        leftTargetPoint = leftTarget;
        rightTargetPoint = rightTarget;
        velocityTarget = velocity;
    }

    public trajectoryPoint(int leftTarget, int rightTarget, int velocity, int acceleration) {
        leftTargetPoint = leftTarget;
        rightTargetPoint = rightTarget;
        velocityTarget = velocity;
        accelerationTarget = acceleration;
    }

    public int getLeftTargetPoint() {
        return leftTargetPoint;
    }

    public int getRightTargetPoint() {
        return rightTargetPoint;
    }

    public int getVelocityTarget() {
        return velocityTarget;
    }

    public int getAccelerationTarget() {
        return accelerationTarget;
    }

}
