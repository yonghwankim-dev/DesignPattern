package chapter11_���ø��޼�������.ch11_04;

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
