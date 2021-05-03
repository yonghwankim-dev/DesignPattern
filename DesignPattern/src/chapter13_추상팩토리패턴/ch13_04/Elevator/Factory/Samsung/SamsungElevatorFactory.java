package chapter13_추상팩토리패턴.ch13_04.Elevator.Factory.Samsung;

import chapter13_추상팩토리패턴.ch13_04.Business.Samsung.SamsungDoor;
import chapter13_추상팩토리패턴.ch13_04.Business.Samsung.SamsungMotor;
import chapter13_추상팩토리패턴.ch13_04.Elevator.Door.Abstract.Door;
import chapter13_추상팩토리패턴.ch13_04.Elevator.Factory.ElevatorFactory;
import chapter13_추상팩토리패턴.ch13_04.Elevator.Motor.Abstract.Motor;

public class SamsungElevatorFactory extends ElevatorFactory{
	private static SamsungElevatorFactory factory;
	
	private SamsungElevatorFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static ElevatorFactory getInstance()
	{
		if(factory==null)
		{
			factory = new SamsungElevatorFactory();
		}
		return factory;
	}
	
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
