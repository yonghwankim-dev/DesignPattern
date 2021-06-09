package chapter12_팩토리메서드패턴.exercise.ex01;

import chapter12_팩토리메서드패턴.exercise.ex01.elevator.MotorVendorID;
import chapter12_팩토리메서드패턴.exercise.ex01.motor.HyundaiMotor;
import chapter12_팩토리메서드패턴.exercise.ex01.motor.LGMotor;
import chapter12_팩토리메서드패턴.exercise.ex01.motor.Motor;
import chapter12_팩토리메서드패턴.exercise.ex01.motor.MotorFactory;

public class Client {
	public static void main(String args[])
	{
		Motor lgMotor = MotorFactory.getMotor(MotorVendorID.LG);
		ElevatorController controller1 = new ElevatorController(1, lgMotor);
		controller1.gotoFloor(5);
		controller1.gotoFloor(3);
		
		Motor hyundaiMotor = MotorFactory.getMotor(MotorVendorID.HYUNDAI);
		ElevatorController controller2 = new ElevatorController(2, hyundaiMotor);
		controller2.gotoFloor(4);
		controller2.gotoFloor(6);
	}
}
