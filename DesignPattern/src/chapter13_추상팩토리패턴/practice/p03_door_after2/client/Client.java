package chapter13_추상팩토리패턴.practice.p03_door_after2.client;

import chapter13_추상팩토리패턴.practice.p03_door_after2.elevator.door.Abstract.Door;
import chapter13_추상팩토리패턴.practice.p03_door_after2.elevator.factory.ElevatorFactory;
import chapter13_추상팩토리패턴.practice.p03_door_after2.elevator.factory.ElevatorFactoryFactory;
import chapter13_추상팩토리패턴.practice.p03_door_after2.elevator.factory.VendorID;
import chapter13_추상팩토리패턴.practice.p03_door_after2.elevator.factory.hyundai.HyundaiElevatorFactory;
import chapter13_추상팩토리패턴.practice.p03_door_after2.elevator.factory.lg.LGElevatorFactory;
import chapter13_추상팩토리패턴.practice.p03_door_after2.elevator.factory.samsung.SamsungElevatorFactory;
import chapter13_추상팩토리패턴.practice.p03_door_after2.elevator.motor.Abstract.Direction;
import chapter13_추상팩토리패턴.practice.p03_door_after2.elevator.motor.Abstract.Motor;

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
