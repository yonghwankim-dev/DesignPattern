package chapter13_추상팩토리패턴.exercise.ex01.factory;

import chapter13_추상팩토리패턴.exercise.ex01.gps.ExpensiveGPS;
import chapter13_추상팩토리패턴.exercise.ex01.gps.GPS;
import chapter13_추상팩토리패턴.exercise.ex01.map.LargeMap;
import chapter13_추상팩토리패턴.exercise.ex01.map.Map;
import chapter13_추상팩토리패턴.exercise.ex01.pathfinder.FastPathFinder;
import chapter13_추상팩토리패턴.exercise.ex01.pathfinder.PathFinder;
import chapter13_추상팩토리패턴.exercise.ex01.screen.HDScreen;
import chapter13_추상팩토리패턴.exercise.ex01.screen.Screen;

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
