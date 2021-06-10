package chapter13_�߻����丮����.practice.p03_door_after2.elevator.factory.hyundai;

import chapter13_�߻����丮����.practice.p03_door_after2.business.hyundai.HyundaiDoor;
import chapter13_�߻����丮����.practice.p03_door_after2.business.hyundai.HyundaiMotor;
import chapter13_�߻����丮����.practice.p03_door_after2.elevator.door.Abstract.Door;
import chapter13_�߻����丮����.practice.p03_door_after2.elevator.factory.ElevatorFactory;
import chapter13_�߻����丮����.practice.p03_door_after2.elevator.motor.Abstract.Motor;


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
