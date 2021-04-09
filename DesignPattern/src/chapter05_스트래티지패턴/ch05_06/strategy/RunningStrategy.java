package chapter05_스트래티지패턴.ch05_06.strategy;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class RunningStrategy extends MovingStrategy{
	private String[] runningImage = {"run1.gif","run2.gif","run3.gif"};

	@Override
	protected ImageIcon getImageIcon(String name) {
		// TODO Auto-generated method stub
		return new ImageIcon("./src/chapter05_스트래티지패턴/ch05_06/"+name);
	}

	@Override
	protected String[] getImageNames() {
		// TODO Auto-generated method stub
		return runningImage;
	}
	

}
