package chapter09_�ɼ�������.exercise.ex02;

public class VoiceNotice implements Observer {
	private ElevatorController controller;
	
	public VoiceNotice(ElevatorController controller) {
		this.controller = controller;
	}


	@Override
	public void update() {
		// TODO Auto-generated method stub
		int curFloor = controller.getCurFloor();
		System.out.println("���� ���� " + curFloor + "�� �Դϴ�.");
	}

}
