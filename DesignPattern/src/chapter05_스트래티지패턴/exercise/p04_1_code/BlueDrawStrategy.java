package chapter05_스트래티지패턴.exercise.p04_1_code;

import java.awt.Color;


public class BlueDrawStrategy extends DrawStrategy{

	@Override
	public void draw(Ball ball) {
		// TODO Auto-generated method stub
		ball.setColor(Color.blue);
	}

}
