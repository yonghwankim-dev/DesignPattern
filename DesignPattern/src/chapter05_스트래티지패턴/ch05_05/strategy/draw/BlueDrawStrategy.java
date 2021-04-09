package chapter05_스트래티지패턴.ch05_05.strategy.draw;

import java.awt.Color;

import chapter05_스트래티지패턴.ch05_05.Ball;

public class BlueDrawStrategy extends DrawStrategy{

	@Override
	public void draw(Ball ball) {
		// TODO Auto-generated method stub
		ball.setColor(Color.blue);
	}

}
