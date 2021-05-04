package chapter13_추상팩토리패턴.ch13_05.FACTORY;

import chapter13_추상팩토리패턴.ch13_05.GPS.ExpensiveGPS;
import chapter13_추상팩토리패턴.ch13_05.GPS.GPS;
import chapter13_추상팩토리패턴.ch13_05.MAP.LargeMap;
import chapter13_추상팩토리패턴.ch13_05.MAP.Map;
import chapter13_추상팩토리패턴.ch13_05.PATHFINDER.FastPathFinder;
import chapter13_추상팩토리패턴.ch13_05.PATHFINDER.PathFinder;
import chapter13_추상팩토리패턴.ch13_05.SCREEN.HDScreen;
import chapter13_추상팩토리패턴.ch13_05.SCREEN.Screen;

public class PremiumNaviFactory extends NaviFactory {

	@Override
	public GPS createGPS() {
		return new ExpensiveGPS();
	}

	@Override
	public Map createMap() {
		// TODO Auto-generated method stub
		return new LargeMap();
	}

	@Override
	public Screen createScreen() {
		// TODO Auto-generated method stub
		return new HDScreen();
	}

	@Override
	public PathFinder createPathFinder() {
		// TODO Auto-generated method stub
		return new FastPathFinder();
	}

}
