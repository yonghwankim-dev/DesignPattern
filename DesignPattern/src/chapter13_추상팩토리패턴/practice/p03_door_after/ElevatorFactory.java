package chapter13_�߻����丮����.practice.p03_door_after;

import chapter13_�߻����丮����.practice.p03_door_after.door.Door;
import chapter13_�߻����丮����.practice.p03_door_after.motor.Motor;

public abstract class ElevatorFactory {	// �߻� ��ǰ�� �����ϴ� �߻� ���丮
	public abstract Motor createMotor();
	public abstract Door createDoor();
}
