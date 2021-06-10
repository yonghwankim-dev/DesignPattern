package chapter13_�߻����丮����.practice.p03_door_after2.elevator.factory.samsung;

import chapter13_�߻����丮����.practice.p03_door_after2.business.samsung.SamsungDoor;
import chapter13_�߻����丮����.practice.p03_door_after2.business.samsung.SamsungMotor;
import chapter13_�߻����丮����.practice.p03_door_after2.elevator.door.Abstract.Door;
import chapter13_�߻����丮����.practice.p03_door_after2.elevator.factory.ElevatorFactory;
import chapter13_�߻����丮����.practice.p03_door_after2.elevator.motor.Abstract.Motor;

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
