package chapter11_템플릿메서드패턴.practice.p03_motor_superMotor;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Door door = new Door();
		HyundaiMotor hyundaiMotor = new HyundaiMotor(door);
		hyundaiMotor.move(Direction.UP);
	}

}
