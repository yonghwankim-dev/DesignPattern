package chapter09_옵서버패턴.ch09_07;

public class Client {

	public static void main(String[] args) {

		
		ElevatorController controller = new ElevatorController();
		
		ElevatorDisplay elevatorDisplay = new ElevatorDisplay(controller);
		VoiceNotice voiceNotice = new VoiceNotice(controller);
		FloorDisplay floorDisplay = new FloorDisplay(controller);
		ControlRoomDisplay controlRoomDisplay = new ControlRoomDisplay(controller);
		
		controller.attach(elevatorDisplay);
		controller.attach(voiceNotice);
		controller.attach(floorDisplay);
		controller.attach(controlRoomDisplay);
		
		controller.gotoFloor(5);
		controller.gotoFloor(10);
	}

}
