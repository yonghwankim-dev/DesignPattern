package chapter13_추상팩토리패턴.ch13_02;

import chapter13_추상팩토리패턴.ch13_02.Door.Door;
import chapter13_추상팩토리패턴.ch13_02.Door.DoorFactory;
import chapter13_추상팩토리패턴.ch13_02.Motor.Direction;
import chapter13_추상팩토리패턴.ch13_02.Motor.Motor;
import chapter13_추상팩토리패턴.ch13_02.Motor.MotorFactory;

public class Client {
	public static void main(String args[])
	{
		Door lgDoor = DoorFactory.createMotor(VendorID.LG);
		Motor lgMotor = MotorFactory.createMotor(VendorID.LG);
		
		lgMotor.setDoor(lgDoor);
		lgDoor.open();
		lgMotor.move(Direction.UP);
	}
}
