package chapter05_스트래티지패턴.exercise.p05_1_code;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class WalkingStrategy extends MovingStrategy{
	private String[] walkingImage = {"walk1.gif","walk2.gif"};

	@Override
	protected ImageIcon getImageIcon(String name) {
		// TODO Auto-generated method stub
		return new ImageIcon("./src/chapter05_스트래티지태펀/exercise/p05_1_code/img/"+name);
	}

	@Override
	protected String[] getImageNames() {
		// TODO Auto-generated method stub
		return walkingImage;
	}
	
	

}
