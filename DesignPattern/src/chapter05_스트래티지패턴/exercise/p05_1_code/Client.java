package chapter05_��Ʈ��Ƽ������.exercise.p05_1_code;

public class Client {
	public static void main(String args[])
	{
		Field field = new Field();
//		field.setMovingStrategy(new WalkingStrategy());
		field.setMovingStrategy(new RunningStrategy());
		new Running(field);
	}
}
