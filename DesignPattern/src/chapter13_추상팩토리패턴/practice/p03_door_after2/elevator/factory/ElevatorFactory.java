package chapter13_추상팩토리패턴.practice.p03_door_after2.elevator.factory;

import chapter13_추상팩토리패턴.practice.p03_door_after2.elevator.door.Abstract.Door;
import chapter13_추상팩토리패턴.practice.p03_door_after2.elevator.motor.Abstract.Motor;

public abstract class ElevatorFactory {	// 추상 부품을 생성하는 추상 팩토리
	public abstract Motor createMotor();
	public abstract Door createDoor();

}
