package chapter13_�߻����丮����.practice.p03_door_after.motor;

import chapter13_�߻����丮����.practice.p03_door_after.VendorID;

public class MotorFactory {
	// vendorID�� ���� LGMotor �Ǵ� HyundaiMotor ��ü�� ������
	public static Motor createMotor(VendorID vendorID)
	{
		Motor motor = null;
		switch(vendorID)
		{
		case LG:
			motor = new LGMotor();
			break;
		case HYUNDAI:
			motor = new HyundaiMotor();
			break;
		}
		return motor;
		
	}
}
