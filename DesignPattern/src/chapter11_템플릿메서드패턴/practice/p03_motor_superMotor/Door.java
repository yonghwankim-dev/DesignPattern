package chapter11_템플릿메서드패턴.practice.p03_motor_superMotor;

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
