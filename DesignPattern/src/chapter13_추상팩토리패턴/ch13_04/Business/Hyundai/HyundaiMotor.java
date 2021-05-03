package chapter13_추상팩토리패턴.ch13_04.Business.Hyundai;

import chapter13_추상팩토리패턴.ch13_04.Elevator.Motor.Abstract.Direction;
import chapter13_추상팩토리패턴.ch13_04.Elevator.Motor.Abstract.Motor;

public class HyundaiMotor extends Motor {
	
	@Override
	protected void moveMotor(Direction direction) {
		// TODO Auto-generated method stub
		System.out.println("move Hyundai Motor " + direction);
	}

}
