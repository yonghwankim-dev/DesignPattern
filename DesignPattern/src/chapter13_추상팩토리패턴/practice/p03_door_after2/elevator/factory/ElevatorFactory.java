package chapter13_�߻����丮����.practice.p03_door_after2.elevator.factory;

import chapter13_�߻����丮����.practice.p03_door_after2.elevator.door.Abstract.Door;
import chapter13_�߻����丮����.practice.p03_door_after2.elevator.motor.Abstract.Motor;

public abstract class ElevatorFactory {	// �߻� ��ǰ�� �����ϴ� �߻� ���丮
	public abstract Motor createMotor();
	public abstract Door createDoor();

}
