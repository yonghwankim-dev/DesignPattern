package chapter13_추상팩토리패턴.ch13_03.Door;

import chapter13_추상팩토리패턴.ch13_03.VendorID;

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
