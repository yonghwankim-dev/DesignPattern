package chapter13_�߻����丮����.ch13_05.Stub;

import chapter13_�߻����丮����.ch13_05.MAP.Map;
import chapter13_�߻����丮����.ch13_05.SCREEN.Screen;

public class TestScreen extends Screen {

	@Override
	public void drawMap(Map map) {
		// TODO Auto-generated method stub
		System.out.println("Draw map " + map.getClass().getName() + " on Test screen");
	}

}
