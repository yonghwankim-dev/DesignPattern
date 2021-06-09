package chapter12_���丮�޼�������.practice.p04_elevator_after2;

public class ElevatorController {
	private int id;			// ���������� ID
	private int curFloor;	// ���� ��
	
	public ElevatorController(int id) {
		this.id = id;
		curFloor = 1;
	}
	
	public void gotoFloor(int destination)
	{
		System.out.printf("Elevator [%d] Floor: %d", id,curFloor);
		
		// ���� �� ����, �� �־��� ������ ��(destination)���� ���������Ͱ� �̵���
		this.curFloor = destination;
		System.out.println(" ==> " + curFloor);
		
	}
	
}
