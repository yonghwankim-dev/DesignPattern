package chapter12_팩토리메서드패턴.ch12_06.motor;

import chapter12_팩토리메서드패턴.ch12_06.elevator.MotorVendorID;

public class MotorFactory {
	public static Motor getMotor(MotorVendorID venforID)
	{
		Motor motor = null;
		switch(venforID)
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
