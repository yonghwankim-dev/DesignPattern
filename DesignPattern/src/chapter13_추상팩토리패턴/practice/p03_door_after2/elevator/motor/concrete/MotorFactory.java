package chapter13_추상팩토리패턴.practice.p03_door_after2.elevator.motor.concrete;

import chapter13_추상팩토리패턴.practice.p03_door_after2.business.hyundai.HyundaiMotor;
import chapter13_추상팩토리패턴.practice.p03_door_after2.business.lg.LGMotor;
import chapter13_추상팩토리패턴.practice.p03_door_after2.elevator.factory.VendorID;
import chapter13_추상팩토리패턴.practice.p03_door_after2.elevator.motor.Abstract.Motor;

public class MotorFactory {
	// vendorID에 따라 LGMotor 또는 HyundaiMotor 객체를 생성함
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
