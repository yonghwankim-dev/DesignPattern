package chapter13_�߻����丮����.practice.p03_door_after2.business.hyundai;

import chapter13_�߻����丮����.practice.p03_door_after2.elevator.door.Abstract.Door;

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
