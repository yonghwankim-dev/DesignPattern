package chapter11_템플릿메서드패턴.practice.p04_motor_after;



public abstract class Motor {	// HyundaiMotor와 LGMotor에 공통적인 기능을 구현하는 클래스
	protected Door door;
	private MotorStatus motorStatus;
	
	public Motor(Door door) {
		this.door = door;
		this.motorStatus = MotorStatus.STOPPED;
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
		if(motorStatus==MotorStatus.MOVING)	// 이미 이동 중이면 아무 작업을 하지 않음.
		{
			return;
		}
		
		DoorStatus doorStatus = door.getDoorStatus();
		if(doorStatus==DoorStatus.OPENED)	// 만약 문이 열려 있으면 우선 문을 닫음
		{
			door.close();
		}
		
		moveMotor(direction);
		setMotorStatus(MotorStatus.MOVING);
	}
	
	protected abstract void moveMotor(Direction direction);

}
