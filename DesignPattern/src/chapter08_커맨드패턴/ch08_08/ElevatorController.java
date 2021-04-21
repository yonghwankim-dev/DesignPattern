package chapter08_커맨드패턴.ch08_08;

public class ElevatorController {
	private int id;			// 엘리베이터 식별자
	private int curFloor;	// 엘리베이터의 현재 위치(층)
	
	public ElevatorController(int id) {
		this.id = id;
	}


	public void gotoFloor(int destination) {
		// TODO Auto-generated method stub
		this.curFloor = destination;
		System.out.printf("Elevator [%d] Current Floor: %d\n",id,curFloor);
	}
	
}
