package chapter13_�߻����丮����.practice.p03_door_after.door;

import chapter13_�߻����丮����.practice.p03_door_after.VendorID;

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
