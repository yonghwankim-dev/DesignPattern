package chapter13_추상팩토리패턴.practice.p03_door_after2.business.lg;

import chapter13_추상팩토리패턴.practice.p03_door_after2.elevator.motor.Abstract.Direction;
import chapter13_추상팩토리패턴.practice.p03_door_after2.elevator.motor.Abstract.Motor;

public class LGMotor extends Motor {
	
	@Override
	protected void moveMotor(Direction direction) {
		// TODO Auto-generated method stub
		System.out.println("move LG Motor " + direction);
	}

}
