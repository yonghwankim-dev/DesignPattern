package chapter13_추상팩토리패턴.practice.p03_door_after.motor;

public class SamsungMotor extends Motor {
	
	@Override
	protected void moveMotor(Direction direction) {
		// TODO Auto-generated method stub
		System.out.println("move Samsung Motor " + direction);
	}

}
