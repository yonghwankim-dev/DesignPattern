package chapter13_추상팩토리패턴.exercise.ex01.factory;

import chapter13_추상팩토리패턴.exercise.ex01.gps.CheapGPS;
import chapter13_추상팩토리패턴.exercise.ex01.gps.GPS;
import chapter13_추상팩토리패턴.exercise.ex01.map.Map;
import chapter13_추상팩토리패턴.exercise.ex01.map.SmallMap;
import chapter13_추상팩토리패턴.exercise.ex01.pathfinder.PathFinder;
import chapter13_추상팩토리패턴.exercise.ex01.pathfinder.SlowPathFinder;
import chapter13_추상팩토리패턴.exercise.ex01.screen.SDScreen;
import chapter13_추상팩토리패턴.exercise.ex01.screen.Screen;

public class BasicNaviFactory extends NaviFactory{

	@Override
	public GPS createGPS() {
		return new CheapGPS();
	}

	@Override
	public Map createMap() {
		// TODO Auto-generated method stub
		return new SmallMap();
	}

	@Override
	public Screen createScreen() {
		// TODO Auto-generated method stub
		return new SDScreen();
	}

	@Override
	public PathFinder createPathFinder() {
		// TODO Auto-generated method stub
		return new SlowPathFinder();
	}

}
