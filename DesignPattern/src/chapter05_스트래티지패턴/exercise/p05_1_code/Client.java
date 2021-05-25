package chapter05_스트래티지패턴.exercise.p05_1_code;

public class Client {
	public static void main(String args[])
	{
		Field field = new Field();
//		field.setMovingStrategy(new WalkingStrategy());
		field.setMovingStrategy(new RunningStrategy());
		new Running(field);
	}
}
