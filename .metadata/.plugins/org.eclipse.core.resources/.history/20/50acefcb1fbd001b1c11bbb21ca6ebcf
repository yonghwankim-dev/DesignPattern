package chapter05_스트래티지패턴.ch05_05.strategy.direction;

import chapter05_스트래티지패턴.ch05_05.Ball;
import chapter05_스트래티지패턴.ch05_05.BallFrame;

public class DiagonalMoveStrategy extends DirectionStrategy{

	@Override
	public void move(Ball ball) {
		// TODO Auto-generated method stub
		ball.setIntervals(Ball.INTERVAL, Ball.INTERVAL);
		
		while(true)
		{
			ball.setX(ball.getX()+ball.getxInterval());
			ball.setY(ball.getY()+ball.getyInterval());
			
			if((ball.getX()<0 && ball.getxInterval()<0) ||
					ball.getX()+Ball.SIZE > BallFrame.WIDTH - 15 && 
					ball.getxInterval()>0)
			{
				ball.setIntervals(-ball.getxInterval(), ball.getyInterval());
			}
			
			if((ball.getY()<0 && ball.getyInterval()<0) ||
					ball.getY()+Ball.SIZE > BallFrame.HEIGHT - 40 && 
					ball.getyInterval()>0)
			{
				ball.setIntervals(ball.getxInterval(), -ball.getyInterval());
			}
			
			try {
				Thread.sleep(30);
			}catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}
