package chapter13_�߻����丮����.practice.p02_door_before.door;

public abstract class Door {
	private DoorStatus doorStatus;
	
	public Door()
	{
		doorStatus = DoorStatus.CLOSED;
	}
	
	public DoorStatus getDoorStatus()
	{
		return doorStatus;
	}
	
	public void close()	// ���ø� �޼��� 
	{	
		if(doorStatus==DoorStatus.CLOSED)	// �̹� ���� ���� ������ �ƹ��� ������ ���� ����.
		{
			return;
		}
		
		doClose();	// ���� ���� �ݴ� ������ ������, ���� Ŭ�������� ���ٸ��� �� ����
		doorStatus = DoorStatus.CLOSED;	// ���� ���¸� �������� �����.
	}
	
	protected abstract void doClose();	// primitive �Ǵ� hook �޼���

	public void open()
	{
		if(doorStatus==DoorStatus.OPENED)	// �̹� ���� ���� ������ �ƹ� ������ ���� ����.
		{
			return;
		}
		
		doOpen();	// ���� ���� ���� ������ ������. ���� Ŭ�������� �������̵� �� ����
		doorStatus = DoorStatus.OPENED;	// ���� ���¸� �������� �����
	}

	protected abstract void doOpen();	// primitive �Ǵ� hook �޼���
}
