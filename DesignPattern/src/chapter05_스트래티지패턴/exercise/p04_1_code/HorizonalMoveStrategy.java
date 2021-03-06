package chapter05_스트래티지패턴.exercise.p04_1_code;


public class HorizonalMoveStrategy extends DirectionStrategy{

	@Override
	public void move(Ball ball) {
		// TODO Auto-generated method stub
		ball.setIntervals(Ball.INTERVAL, 0);
		
		while(true)
		{
			ball.setX(ball.getX()+ball.getxInterval());
			
			if((ball.getX()<0 && ball.getxInterval()<0) ||
					ball.getX()+Ball.SIZE > BallFrame.WIDTH - 15 && 
					ball.getxInterval()>0)
			{
				ball.setIntervals(-ball.getxInterval(), 0);
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
