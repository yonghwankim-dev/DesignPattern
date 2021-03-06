package chapter12_팩토리메서드패턴.exercise.ex01.motor;

import chapter12_팩토리메서드패턴.exercise.ex01.elevator.Direction;
import chapter12_팩토리메서드패턴.exercise.ex01.elevator.MotorStatus;

public abstract class Motor {
	private MotorStatus motorStatus;
	
	public Motor()
	{
		motorStatus = MotorStatus.STOPPED;
	}

	public MotorStatus getMotorStatus() {
		return motorStatus;
	}

	public void setMotorStatus(MotorStatus motorStatus) {
		this.motorStatus = motorStatus;
	}
	
	public void move(Direction direction)
	{
		MotorStatus motorStatus = getMotorStatus();
		if(motorStatus==MotorStatus.MOVING)
		{
			return;
		}
		moveMotor(direction);
		setMotorStatus(MotorStatus.MOVING);
	}
	
	protected abstract void moveMotor(Direction direction);
	
	public void stop()
	{
		motorStatus = MotorStatus.STOPPED;
	}
}
