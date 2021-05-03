package chapter13_추상팩토리패턴.ch13_03;

import chapter13_추상팩토리패턴.ch13_03.Door.Door;
import chapter13_추상팩토리패턴.ch13_03.Motor.Motor;

public abstract class ElevatorFactory {	// 추상 부품을 생성하는 추상 팩토리
	public abstract Motor createMotor();
	public abstract Door createDoor();

}
