package chapter13_추상팩토리패턴.practice.p03_door_after;


import chapter13_추상팩토리패턴.practice.p03_door_after.door.Door;
import chapter13_추상팩토리패턴.practice.p03_door_after.door.HyundaiDoor;
import chapter13_추상팩토리패턴.practice.p03_door_after.door.LGDoor;
import chapter13_추상팩토리패턴.practice.p03_door_after.motor.HyundaiMotor;
import chapter13_추상팩토리패턴.practice.p03_door_after.motor.LGMotor;
import chapter13_추상팩토리패턴.practice.p03_door_after.motor.Motor;

public class HyundaiElevatorFactory extends ElevatorFactory{

	@Override
	public Motor createMotor() {
		// TODO Auto-generated method stub
		return new HyundaiMotor();
	}

	@Override
	public Door createDoor() {
		// TODO Auto-generated method stub
		return new HyundaiDoor();
	}

}
