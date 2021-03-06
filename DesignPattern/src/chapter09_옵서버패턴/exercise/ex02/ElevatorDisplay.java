package chapter09_옵서버패턴.exercise.ex02;

public class ElevatorDisplay implements Observer{
	private ElevatorController controller;
	
	public ElevatorDisplay(ElevatorController controller) {
		this.controller = controller;
	}

	@Override
	public void update() {
		int curFloor = controller.getCurFloor();
		System.out.println("[엘리베이터 내부] 현재 층 : " + curFloor);
	}

}
