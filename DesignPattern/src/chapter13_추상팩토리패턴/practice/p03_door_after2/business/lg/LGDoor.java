package chapter13_추상팩토리패턴.practice.p03_door_after2.business.lg;

import chapter13_추상팩토리패턴.practice.p03_door_after2.elevator.door.Abstract.Door;

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
