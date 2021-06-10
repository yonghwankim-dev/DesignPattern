package chapter13_�߻����丮����.practice.p02_door_before;

import chapter13_�߻����丮����.practice.p02_door_before.door.Door;
import chapter13_�߻����丮����.practice.p02_door_before.door.DoorFactory;
import chapter13_�߻����丮����.practice.p02_door_before.motor.Direction;
import chapter13_�߻����丮����.practice.p02_door_before.motor.Motor;
import chapter13_�߻����丮����.practice.p02_door_before.motor.MotorFactory;

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
