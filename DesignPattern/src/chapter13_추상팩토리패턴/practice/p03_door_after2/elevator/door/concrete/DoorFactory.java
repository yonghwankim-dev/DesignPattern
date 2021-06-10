package chapter13_�߻����丮����.practice.p03_door_after2.elevator.door.concrete;

import chapter13_�߻����丮����.practice.p03_door_after2.business.hyundai.HyundaiDoor;
import chapter13_�߻����丮����.practice.p03_door_after2.business.lg.LGDoor;
import chapter13_�߻����丮����.practice.p03_door_after2.elevator.door.Abstract.Door;
import chapter13_�߻����丮����.practice.p03_door_after2.elevator.factory.VendorID;

public class DoorFactory {
	// vendorID�� ���� LGMotor �Ǵ� HyundaiMotor ��ü�� ������
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
