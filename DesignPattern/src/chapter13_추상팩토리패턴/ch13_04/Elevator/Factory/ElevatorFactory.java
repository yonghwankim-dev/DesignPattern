package chapter13_�߻����丮����.ch13_04.Elevator.Factory;

import chapter13_�߻����丮����.ch13_04.Elevator.Door.Abstract.Door;
import chapter13_�߻����丮����.ch13_04.Elevator.Motor.Abstract.Motor;

public abstract class ElevatorFactory {	// �߻� ��ǰ�� �����ϴ� �߻� ���丮
	public abstract Motor createMotor();
	public abstract Door createDoor();

}
