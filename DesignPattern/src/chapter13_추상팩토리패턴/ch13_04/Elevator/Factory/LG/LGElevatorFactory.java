package chapter13_추상팩토리패턴.ch13_04.Elevator.Factory.LG;

import chapter13_추상팩토리패턴.ch13_04.Business.LG.LGDoor;
import chapter13_추상팩토리패턴.ch13_04.Business.LG.LGMotor;
import chapter13_추상팩토리패턴.ch13_04.Elevator.Door.Abstract.Door;
import chapter13_추상팩토리패턴.ch13_04.Elevator.Factory.ElevatorFactory;
import chapter13_추상팩토리패턴.ch13_04.Elevator.Motor.Abstract.Motor;

public class LGElevatorFactory extends ElevatorFactory{
	private static LGElevatorFactory factory;
	
	private LGElevatorFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static ElevatorFactory getInstance()
	{
		if(factory==null)
		{
			factory = new LGElevatorFactory();
		}
		return factory;
	}
	
	@Override
	public Motor createMotor() {
		// TODO Auto-generated method stub
		return new LGMotor();
	}

	@Override
	public Door createDoor() {
		// TODO Auto-generated method stub
		return new LGDoor();
	}

}
