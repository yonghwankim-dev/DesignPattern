package chapter13_추상팩토리패턴.practice.p02_door_before.door;

public class LGDoor extends Door{

	@Override
	protected void doClose() {
		// TODO Auto-generated method stub
		System.out.println("close LG Door");
	}

	@Override
	protected void doOpen() {
		// TODO Auto-generated method stub
		System.out.println("open LG Door");
	}
	
}
