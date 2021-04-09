package chapter05_스트래티지패턴.ch05_06;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import chapter05_스트래티지패턴.ch05_06.strategy.MovingStrategy;
import chapter05_스트래티지패턴.ch05_06.strategy.WalkingStrategy;


public class Field extends JPanel implements Runnable{
	private JLabel lbl;
	private MovingStrategy strategy = new WalkingStrategy();
	
	public void setMovingStrategy(MovingStrategy strategy)
	{
		this.strategy = strategy;
	}
	
	public Field() {
		setLayout(new BorderLayout());
		lbl = new JLabel();
		lbl.setIcon(new ImageIcon("./src/chapter05_스트래티지태펀/ch05_06/"));
		add(lbl, BorderLayout.CENTER);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		strategy.drawImages(lbl);
	}

}
