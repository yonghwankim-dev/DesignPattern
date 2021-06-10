package chapter13_추상팩토리패턴.practice.p03_door_after2.elevator.door.concrete;

import chapter13_추상팩토리패턴.practice.p03_door_after2.business.hyundai.HyundaiDoor;
import chapter13_추상팩토리패턴.practice.p03_door_after2.business.lg.LGDoor;
import chapter13_추상팩토리패턴.practice.p03_door_after2.elevator.door.Abstract.Door;
import chapter13_추상팩토리패턴.practice.p03_door_after2.elevator.factory.VendorID;

public class DoorFactory {
	// vendorID에 따라 LGMotor 또는 HyundaiMotor 객체를 생성함
	public static Door createMotor(VendorID vendorID)
	{
		Door door = null;
		switch(vendorID)
		{
		case LG:
			door = new LGDoor();
			break;
		case HYUNDAI:
			door = new HyundaiDoor();
			break;
		}
		
		return door;
		
	}
}
