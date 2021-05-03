package chapter13_추상팩토리패턴.ch13_03;


import chapter13_추상팩토리패턴.ch13_03.Door.Door;
import chapter13_추상팩토리패턴.ch13_03.Door.HyundaiDoor;
import chapter13_추상팩토리패턴.ch13_03.Door.LGDoor;
import chapter13_추상팩토리패턴.ch13_03.Motor.HyundaiMotor;
import chapter13_추상팩토리패턴.ch13_03.Motor.LGMotor;
import chapter13_추상팩토리패턴.ch13_03.Motor.Motor;

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
