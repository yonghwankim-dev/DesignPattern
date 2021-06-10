package chapter13_�߻����丮����.practice.p03_door_after2.elevator.factory.lg;

import chapter13_�߻����丮����.practice.p03_door_after2.business.lg.LGDoor;
import chapter13_�߻����丮����.practice.p03_door_after2.business.lg.LGMotor;
import chapter13_�߻����丮����.practice.p03_door_after2.elevator.door.Abstract.Door;
import chapter13_�߻����丮����.practice.p03_door_after2.elevator.factory.ElevatorFactory;
import chapter13_�߻����丮����.practice.p03_door_after2.elevator.motor.Abstract.Motor;

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
