package chapter13_추상팩토리패턴.ch13_02.Door;

public class HyundaiDoor extends Door{

	@Override
	protected void doClose() {
		// TODO Auto-generated method stub
		System.out.println("close Hyundai Door");
	}

	@Override
	protected void doOpen() {
		// TODO Auto-generated method stub
		System.out.println("open Hyudani Door");
	}
	
}
