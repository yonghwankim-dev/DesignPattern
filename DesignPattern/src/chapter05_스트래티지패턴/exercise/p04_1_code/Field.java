package chapter05_스트래티지패턴.exercise.p04_1_code;

import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JPanel;



public class Field extends JPanel implements Runnable{
	private static final long SerialVersionUID = 1L;
	private Ball[] balls;
	
	public Field(Ball[] balls)
	{
		this.balls = balls;
		setLayout(new FlowLayout());
	}
	
	public void paint(Graphics g)
	{
		g.clearRect(0, 0, BallFrame.WIDTH, BallFrame.HEIGHT);
		for(int i=0;i<balls.length;i++)
		{
			g.setColor(balls[i].getColor());
			g.fillOval(balls[i].getX(), balls[i].getY(), Ball.SIZE, Ball.SIZE);
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			repaint();
			try {
				Thread.sleep(5);
			}catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
}
