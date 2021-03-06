package chapter13_추상팩토리패턴.practice.p03_door_after2.elevator.factory;

import chapter13_추상팩토리패턴.practice.p03_door_after2.elevator.factory.hyundai.HyundaiElevatorFactory;
import chapter13_추상팩토리패턴.practice.p03_door_after2.elevator.factory.lg.LGElevatorFactory;
import chapter13_추상팩토리패턴.practice.p03_door_after2.elevator.factory.samsung.SamsungElevatorFactory;

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
