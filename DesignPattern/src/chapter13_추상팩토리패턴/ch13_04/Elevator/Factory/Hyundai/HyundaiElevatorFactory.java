package chapter13_추상팩토리패턴.ch13_04.Elevator.Factory.Hyundai;

import chapter13_추상팩토리패턴.ch13_04.Business.Hyundai.HyundaiDoor;
import chapter13_추상팩토리패턴.ch13_04.Business.Hyundai.HyundaiMotor;
import chapter13_추상팩토리패턴.ch13_04.Elevator.Door.Abstract.Door;
import chapter13_추상팩토리패턴.ch13_04.Elevator.Factory.ElevatorFactory;
import chapter13_추상팩토리패턴.ch13_04.Elevator.Motor.Abstract.Motor;


public class HyundaiElevatorFactory extends ElevatorFactory{
	private static HyundaiElevatorFactory factory;
	
	private HyundaiElevatorFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static ElevatorFactory getInstance()
	{
		if(factory==null)
		{
			factory = new HyundaiElevatorFactory();
		}
		return factory;
	}
	
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
