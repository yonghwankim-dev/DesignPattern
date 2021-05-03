package chapter13_추상팩토리패턴.ch13_04.Elevator.Factory;

import chapter13_추상팩토리패턴.ch13_04.Elevator.Factory.Hyundai.HyundaiElevatorFactory;
import chapter13_추상팩토리패턴.ch13_04.Elevator.Factory.LG.LGElevatorFactory;
import chapter13_추상팩토리패턴.ch13_04.Elevator.Factory.Samsung.SamsungElevatorFactory;

public class ElevatorFactoryFactory {	// 팩토리 클래스에 팩토리 메서드 패턴을 적용함
	public static ElevatorFactory getFactory(VendorID vendorID)
	{
		ElevatorFactory factory = null;
		
		switch(vendorID)
		{
		case LG:
			factory = LGElevatorFactory.getInstance();	// LG 팩토리의 생성
			break;
		case HYUNDAI:
			factory = HyundaiElevatorFactory.getInstance();	// 현대 팩토리의 생성
			break;
		case SAMSUNG:
			factory = SamsungElevatorFactory.getInstance();	// 삼성 팩토리의 생성
			break;
		
		}
		return factory;
	}

}
