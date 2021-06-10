package chapter13_추상팩토리패턴.practice.p03_door_after;

import chapter13_추상팩토리패턴.practice.p03_door_after.door.Door;
import chapter13_추상팩토리패턴.practice.p03_door_after.door.SamsungDoor;
import chapter13_추상팩토리패턴.practice.p03_door_after.motor.Motor;
import chapter13_추상팩토리패턴.practice.p03_door_after.motor.SamsungMotor;

public class SamsungElevatorFactory extends ElevatorFactory{

	@Override
	public Motor createMotor() {
		// TODO Auto-generated method stub
		return new SamsungMotor();
	}

	@Override
	public Door createDoor() {
		// TODO Auto-generated method stub
		return new SamsungDoor();
	}

}
