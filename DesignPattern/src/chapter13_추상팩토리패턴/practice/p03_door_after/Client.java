package chapter13_�߻����丮����.practice.p03_door_after;

import chapter13_�߻����丮����.practice.p03_door_after.door.Door;
import chapter13_�߻����丮����.practice.p03_door_after.door.DoorFactory;
import chapter13_�߻����丮����.practice.p03_door_after.motor.Direction;
import chapter13_�߻����丮����.practice.p03_door_after.motor.Motor;
import chapter13_�߻����丮����.practice.p03_door_after.motor.MotorFactory;

public class Client {
	public static void main(String args[])
	{
		ElevatorFactory factory = null;
		String vendorName = args[0];
		if(vendorName.equalsIgnoreCase("LG"))	// ���ڿ� ���� LG �Ǵ� ���� ���丮�� ������
		{
			factory = new LGElevatorFactory();
		}
		else if(vendorName.equalsIgnoreCase("Samsung"))	// �Ｚ ��ǰ�� �����ϴ� �Ｚ ���丮�� �̿���
		{
			factory = new SamsungElevatorFactory();
		}
		else
		{
			factory = new HyundaiElevatorFactory();
		}
		
		Door door = factory.createDoor();
		Motor motor = factory.createMotor();
		motor.setDoor(door);
		
		door.open();
		motor.move(Direction.UP);
	}
}
