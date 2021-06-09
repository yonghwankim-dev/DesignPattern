package chapter12_팩토리메서드패턴.exercise.ex01.motor;

import chapter12_팩토리메서드패턴.exercise.ex01.elevator.Direction;

public class LGMotor extends Motor {

	@Override
	protected void moveMotor(Direction direction) {
		// TODO Auto-generated method stub
		System.out.println("move LG Motor " + direction);
	}
}

