package chapter13_추상팩토리패턴.ch13_05.SCREEN;

import chapter13_추상팩토리패턴.ch13_05.MAP.Map;

public class SDScreen extends Screen{

	@Override
	public void drawMap(Map map) {
		// TODO Auto-generated method stub
		System.out.println("Draw map " + map.getClass().getName() + " on SD Screen");
	}

}
