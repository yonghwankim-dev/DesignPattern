package chapter11_���ø��޼�������.practice.p02_motor_addedLGMotor;



public class LGMotor {
	private Door door;
	private MotorStatus motorStatus;
	
	public LGMotor(Door door) {
		this.door = door;
		motorStatus = MotorStatus.STOPPED;
	}
	
	private void moveLGMotor(Direction direction)
	{
		// LG Motor�� ������Ŵ
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
		if(motorStatus==MotorStatus.MOVING)	// �̹� �̵� ���̸� �ƹ� �۾��� ���� ����.
		{
			return;
		}
		
		DoorStatus doorStatus = door.getDoorStatus();
		if(doorStatus==DoorStatus.OPENED)	// ���� ���� ���� ������ �켱 ���� ����
		{
			door.close();
		}
		
		moveLGMotor(direction); // move �޼���� �� ������ �����ϸ� HyundaiMotor�� ������
		setMotorStatus(MotorStatus.MOVING);
		
	}
	
}
