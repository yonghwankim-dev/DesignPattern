package chapter13_추상팩토리패턴.practice.p03_door_after2.business.samsung;

import chapter13_추상팩토리패턴.practice.p03_door_after2.elevator.door.Abstract.Door;

public class SamsungDoor extends Door{

	@Override
	protected void doClose() {
		// TODO Auto-generated method stub
		System.out.println("close Samsung Door");
	}

	@Override
	protected void doOpen() {
		// TODO Auto-generated method stub
		System.out.println("open Samsung Door");
	}
	
}
