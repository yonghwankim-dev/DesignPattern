package chapter13_추상팩토리패턴.exercise.ex01.stub;

import chapter13_추상팩토리패턴.exercise.ex01.map.Map;
import chapter13_추상팩토리패턴.exercise.ex01.screen.Screen;

public class TestScreen extends Screen {

	@Override
	public void drawMap(Map map) {
		// TODO Auto-generated method stub
		System.out.println("Draw map " + map.getClass().getName() + " on Test screen");
	}

}
