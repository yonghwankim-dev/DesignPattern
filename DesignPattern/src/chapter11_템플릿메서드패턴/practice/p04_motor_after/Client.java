package chapter11_���ø��޼�������.practice.p04_motor_after;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Door door = new Door();
		HyundaiMotor hyundaiMotor = new HyundaiMotor(door);
		hyundaiMotor.move(Direction.UP);
	}

}
