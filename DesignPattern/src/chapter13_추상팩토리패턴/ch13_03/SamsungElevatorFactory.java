package chapter13_�߻����丮����.ch13_03;

import chapter13_�߻����丮����.ch13_03.Door.Door;
import chapter13_�߻����丮����.ch13_03.Door.SamsungDoor;
import chapter13_�߻����丮����.ch13_03.Motor.Motor;
import chapter13_�߻����丮����.ch13_03.Motor.SamsungMotor;

public class SamsungElevatorFactory extends ElevatorFactory{

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
