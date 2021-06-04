package chapter09_옵서버패턴.exercise.ex02;

public class FloorDisplay implements Observer{
	private ElevatorController controller;
	
	public FloorDisplay(ElevatorController controller) {
		this.controller = controller;
	}



	@Override
	public void update() {
		int curFloor = controller.getCurFloor();
		System.out.println("[건물 내부 엘리베이터 층 표시] 현재 층 : " + curFloor);
		
	}

}
