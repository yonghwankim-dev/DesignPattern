package chapter05_��Ʈ��Ƽ������.exercise.p05_1_code;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class MovingStrategy {
	public void drawImages(JLabel lbl) {
		String[] path = getImageNames();
		lbl.setIcon(getImageIcon(path[0]));
		while(true)
		{
			for(int i=0;i<path.length;i++)
			{
				lbl.setIcon(getImageIcon(path[i]));
				try {
					Thread.sleep(100);
				}catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
	}
	protected abstract ImageIcon getImageIcon(String name);
	protected abstract String[] getImageNames();
	
}
