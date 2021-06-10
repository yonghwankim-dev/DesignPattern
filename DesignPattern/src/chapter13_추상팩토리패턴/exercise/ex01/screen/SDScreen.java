package chapter13_추상팩토리패턴.exercise.ex01.screen;

import chapter13_추상팩토리패턴.exercise.ex01.map.Map;

public class SDScreen extends Screen{

	@Override
	public void drawMap(Map map) {
		// TODO Auto-generated method stub
		System.out.println("Draw map " + map.getClass().getName() + " on SD Screen");
	}

}
