package chapter13_�߻����丮����.practice.p03_door_after2.client;

import chapter13_�߻����丮����.practice.p03_door_after2.elevator.door.Abstract.Door;
import chapter13_�߻����丮����.practice.p03_door_after2.elevator.factory.ElevatorFactory;
import chapter13_�߻����丮����.practice.p03_door_after2.elevator.factory.ElevatorFactoryFactory;
import chapter13_�߻����丮����.practice.p03_door_after2.elevator.factory.VendorID;
import chapter13_�߻����丮����.practice.p03_door_after2.elevator.factory.hyundai.HyundaiElevatorFactory;
import chapter13_�߻����丮����.practice.p03_door_after2.elevator.factory.lg.LGElevatorFactory;
import chapter13_�߻����丮����.practice.p03_door_after2.elevator.factory.samsung.SamsungElevatorFactory;
import chapter13_�߻����丮����.practice.p03_door_after2.elevator.motor.Abstract.Direction;
import chapter13_�߻����丮����.practice.p03_door_after2.elevator.motor.Abstract.Motor;

public class Client {
	public static void main(String args[])
	{
		ElevatorFactory factory = null;
		String vendorName = args[0];
		VendorID vendorID;
		if(vendorName.equalsIgnoreCase("LG"))	// ���ڿ� ���� LG �Ǵ� ���� ���丮�� ������
		{
			vendorID = VendorID.LG;
		}
		else if(vendorName.equalsIgnoreCase("Samsung"))	// �Ｚ ��ǰ�� �����ϴ� �Ｚ ���丮�� �̿���
		{
			vendorID = VendorID.SAMSUNG;
		}
		else
		{
			vendorID = VendorID.HYUNDAI;
		}
		
		factory = ElevatorFactoryFactory.getFactory(vendorID);
		
		Door door = factory.createDoor();
		Motor motor = factory.createMotor();
		motor.setDoor(door);
		
		door.open();
		motor.move(Direction.UP);
	}
}
