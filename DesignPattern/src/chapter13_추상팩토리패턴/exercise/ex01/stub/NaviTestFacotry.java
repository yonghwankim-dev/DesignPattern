package chapter13_추상팩토리패턴.exercise.ex01.stub;

import chapter13_추상팩토리패턴.exercise.ex01.factory.NaviFactory;
import chapter13_추상팩토리패턴.exercise.ex01.gps.GPS;
import chapter13_추상팩토리패턴.exercise.ex01.map.Map;
import chapter13_추상팩토리패턴.exercise.ex01.pathfinder.PathFinder;
import chapter13_추상팩토리패턴.exercise.ex01.screen.Screen;

public class NaviTestFacotry extends NaviFactory{

	@Override
	public GPS createGPS() {
		// TODO Auto-generated method stub
		return new GPSSimulator();
	}

	@Override
	public Map createMap() {
		// TODO Auto-generated method stub
		return new TestMap();
	}

	@Override
	public Screen createScreen() {
		// TODO Auto-generated method stub
		return new TestScreen();
	}

	@Override
	public PathFinder createPathFinder() {
		// TODO Auto-generated method stub
		return new TestPathFinder();
	}
	
}
