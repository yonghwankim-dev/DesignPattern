package chapter09_옵서버패턴.exercise.ex02;

public class ControlRoomDisplay implements Observer{
	private ElevatorController controller;
	
	public ControlRoomDisplay(ElevatorController controller) {
		this.controller = controller;
	}


	@Override
	public void update() {
		// TODO Auto-generated method stub
		int curFloor = controller.getCurFloor();
		System.out.println("[지휘통제실] 현재 층 : " + curFloor);
	}
	
}
