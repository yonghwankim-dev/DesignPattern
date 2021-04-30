package chapter12_팩토리메서드패턴.ch12_04;

public class ElevatorController {
	private int id;			// 엘리베이터 ID
	private int curFloor;	// 현재 층
	
	public ElevatorController(int id) {
		this.id = id;
		curFloor = 1;
	}
	
	public void gotoFloor(int destination)
	{
		System.out.printf("Elevator [%d] Floor: %d", id,curFloor);
		
		// 현재 층 갱신, 즉 주어진 목적지 층(destination)으로 엘리베이터가 이동함
		this.curFloor = destination;
		System.out.println(" ==> " + curFloor);
		
	}
	
}
