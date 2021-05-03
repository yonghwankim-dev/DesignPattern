package chapter13_추상팩토리패턴.ch13_04.Elevator.Motor.Concrete;

import chapter13_추상팩토리패턴.ch13_04.Business.Hyundai.HyundaiMotor;
import chapter13_추상팩토리패턴.ch13_04.Business.LG.LGMotor;
import chapter13_추상팩토리패턴.ch13_04.Elevator.Factory.VendorID;
import chapter13_추상팩토리패턴.ch13_04.Elevator.Motor.Abstract.Motor;

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
