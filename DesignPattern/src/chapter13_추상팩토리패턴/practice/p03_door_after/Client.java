package chapter13_추상팩토리패턴.practice.p03_door_after;

import chapter13_추상팩토리패턴.practice.p03_door_after.door.Door;
import chapter13_추상팩토리패턴.practice.p03_door_after.door.DoorFactory;
import chapter13_추상팩토리패턴.practice.p03_door_after.motor.Direction;
import chapter13_추상팩토리패턴.practice.p03_door_after.motor.Motor;
import chapter13_추상팩토리패턴.practice.p03_door_after.motor.MotorFactory;

public class Client {
	public static void main(String args[])
	{
		ElevatorFactory factory = null;
		String vendorName = args[0];
		if(vendorName.equalsIgnoreCase("LG"))	// 인자에 따라 LG 또는 현대 팩토리를 생성함
		{
			factory = new LGElevatorFactory();
		}
		else if(vendorName.equalsIgnoreCase("Samsung"))	// 삼성 부품을 생성하는 삼성 팩토리를 이용함
		{
			factory = new SamsungElevatorFactory();
		}
		else
		{
			factory = new HyundaiElevatorFactory();
		}
		
		Door door = factory.createDoor();
		Motor motor = factory.createMotor();
		motor.setDoor(door);
		
		door.open();
		motor.move(Direction.UP);
	}
}
