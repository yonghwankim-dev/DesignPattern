package chapter13_�߻����丮����.exercise.ex01.screen;

import chapter13_�߻����丮����.exercise.ex01.map.Map;

public class SDScreen extends Screen{

	@Override
	public void drawMap(Map map) {
		// TODO Auto-generated method stub
		System.out.println("Draw map " + map.getClass().getName() + " on SD Screen");
	}

}
