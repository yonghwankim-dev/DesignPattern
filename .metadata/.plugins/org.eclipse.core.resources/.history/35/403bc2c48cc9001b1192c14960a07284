package chapter13_추상팩토리패턴.ch13_04.Client;

import chapter13_추상팩토리패턴.ch13_04.Elevator.Door.Abstract.Door;
import chapter13_추상팩토리패턴.ch13_04.Elevator.Factory.ElevatorFactory;
import chapter13_추상팩토리패턴.ch13_04.Elevator.Factory.ElevatorFactoryFactory;
import chapter13_추상팩토리패턴.ch13_04.Elevator.Factory.VendorID;
import chapter13_추상팩토리패턴.ch13_04.Elevator.Factory.Hyundai.HyundaiElevatorFactory;
import chapter13_추상팩토리패턴.ch13_04.Elevator.Factory.LG.LGElevatorFactory;
import chapter13_추상팩토리패턴.ch13_04.Elevator.Factory.Samsung.SamsungElevatorFactory;
import chapter13_추상팩토리패턴.ch13_04.Elevator.Motor.Abstract.Direction;
import chapter13_추상팩토리패턴.ch13_04.Elevator.Motor.Abstract.Motor;

public class Client {
	public static void main(String args[])
	{
		ElevatorFactory factory = null;
		String vendorName = args[0];
		VendorID vendorID;
		if(vendorName.equalsIgnoreCase("LG"))	// 인자에 따라 LG 또는 현대 팩토리를 생성함
		{
			vendorID = VendorID.LG;
		}
		else if(vendorName.equalsIgnoreCase("Samsung"))	// 삼성 부품을 생성하는 삼성 팩토리를 이용함
		{
			vendorID = VendorID.SAMSUNG;
		}
		else
		{
			vendorID = VendorID.HYUNDAI;
		}
		
		factory = ElevatorFactoryFactory.getFactory(vendorID);
		
		Door door = factory.createDoor();
		Motor motor = factory.createMotor();
		motor.setDoor(door);
		
		door.open();
		motor.move(Direction.UP);
	}
}
