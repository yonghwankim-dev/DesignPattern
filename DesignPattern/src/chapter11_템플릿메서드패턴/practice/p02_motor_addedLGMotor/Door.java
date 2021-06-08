package chapter11_���ø��޼�������.practice.p02_motor_addedLGMotor;

public class Door {
	private DoorStatus doorStatus;

	public Door() {
		this.doorStatus = DoorStatus.CLOSED;
	}

	public DoorStatus getDoorStatus() {
		return doorStatus;
	}
	
	public void close()
	{
		doorStatus = DoorStatus.CLOSED;
	}
	
	public void open()
	{
		doorStatus = DoorStatus.OPENED;
	}
}
