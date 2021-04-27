package chapter09_옵서버패턴.ch09_07;

public class VoiceNotice implements Observer {
	private ElevatorController controller;
	
	public VoiceNotice(ElevatorController controller) {
		this.controller = controller;
	}


	@Override
	public void update() {
		// TODO Auto-generated method stub
		int curFloor = controller.getCurFloor();
		System.out.println("현재 층은 " + curFloor + "층 입니다.");
	}

}
