package chapter13_추상팩토리패턴.ch13_04.Business.LG;

import chapter13_추상팩토리패턴.ch13_04.Elevator.Motor.Abstract.Direction;
import chapter13_추상팩토리패턴.ch13_04.Elevator.Motor.Abstract.Motor;

public class LGMotor extends Motor {
	
	@Override
	protected void moveMotor(Direction direction) {
		// TODO Auto-generated method stub
		System.out.println("move LG Motor " + direction);
	}

}
