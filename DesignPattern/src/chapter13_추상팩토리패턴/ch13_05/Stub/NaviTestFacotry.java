package chapter13_추상팩토리패턴.ch13_05.Stub;

import chapter13_추상팩토리패턴.ch13_05.FACTORY.NaviFactory;
import chapter13_추상팩토리패턴.ch13_05.GPS.GPS;
import chapter13_추상팩토리패턴.ch13_05.MAP.Map;
import chapter13_추상팩토리패턴.ch13_05.PATHFINDER.PathFinder;
import chapter13_추상팩토리패턴.ch13_05.SCREEN.Screen;

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
