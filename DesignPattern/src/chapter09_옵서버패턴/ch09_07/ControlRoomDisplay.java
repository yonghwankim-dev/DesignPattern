package chapter09_�ɼ�������.ch09_07;

public class ControlRoomDisplay implements Observer{
	private ElevatorController controller;
	
	public ControlRoomDisplay(ElevatorController controller) {
		this.controller = controller;
	}


	@Override
	public void update() {
		// TODO Auto-generated method stub
		int curFloor = controller.getCurFloor();
		System.out.println("[����������] ���� �� : " + curFloor);
	}
	
}
