package chapter13_추상팩토리패턴.ch13_03.Motor;

public class HyundaiMotor extends Motor {
	
	@Override
	protected void moveMotor(Direction direction) {
		// TODO Auto-generated method stub
		System.out.println("move Hyundai Motor " + direction);
	}

}
