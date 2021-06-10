package chapter13_추상팩토리패턴.ch13_02.Motor;

import chapter13_추상팩토리패턴.ch13_02.Door.Door;

public abstract class Motor {
	private MotorStatus motorStatus;
	private Door door;
	
	public Motor()
	{
		motorStatus = MotorStatus.STOPPED;
	}
	
	public MotorStatus getMotorStatus()
	{
		return motorStatus;
	}
	
	public void setMotorStatus(MotorStatus motorStatus)
	{
		this.motorStatus = motorStatus;
	}
	
	public void setDoor(Door door)
	{
		this.door = door;
	}
	
	public void move(Direction direction)
	{
		MotorStatus motorStatus = getMotorStatus();
		if(motorStatus==MotorStatus.MOVING)
		{
			return;
		}
		door.close();
		moveMotor(direction);
		setMotorStatus(MotorStatus.MOVING);
	}
	
	protected abstract void moveMotor(Direction direction);
	
	public void stop()
	{
		motorStatus = MotorStatus.STOPPED;
	}
}
