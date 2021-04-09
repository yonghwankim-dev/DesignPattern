package chapter05_스트래티지패턴.ch05_06;

import chapter05_스트래티지패턴.ch05_06.strategy.RunningStrategy;
import chapter05_스트래티지패턴.ch05_06.strategy.WalkingStrategy;

public class Client {
	public static void main(String args[])
	{
		Field field = new Field();
//		field.setMovingStrategy(new WalkingStrategy());
		field.setMovingStrategy(new RunningStrategy());
		new Running(field);
	}
}
