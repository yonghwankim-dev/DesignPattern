package chapter05_스트래티지패턴.exercise.p05_1_code;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
		lbl.setIcon(new ImageIcon("./src/chapter05_스트래티지태펀/exercise/p05_1_code/img/"));
		add(lbl, BorderLayout.CENTER);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		strategy.drawImages(lbl);
	}

}
