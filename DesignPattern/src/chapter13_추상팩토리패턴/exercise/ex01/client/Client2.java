package chapter13_추상팩토리패턴.exercise.ex01.client;

import chapter13_추상팩토리패턴.exercise.ex01.Location;
import chapter13_추상팩토리패턴.exercise.ex01.factory.BasicNaviFactory;
import chapter13_추상팩토리패턴.exercise.ex01.factory.NaviFactory;
import chapter13_추상팩토리패턴.exercise.ex01.gps.GPS;
import chapter13_추상팩토리패턴.exercise.ex01.map.Map;
import chapter13_추상팩토리패턴.exercise.ex01.pathfinder.PathFinder;
import chapter13_추상팩토리패턴.exercise.ex01.screen.Screen;
import chapter13_추상팩토리패턴.exercise.ex01.stub.NaviTestFacotry;

public class Client2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NaviFactory testFactory = new NaviTestFacotry();
		NaviFactory basicNaviFactory = new BasicNaviFactory();
		
		GPS gps = testFactory.createGPS();
		Map map = testFactory.createMap();
		Screen screen = testFactory.createScreen();
		PathFinder pathFinder = basicNaviFactory.createPathFinder();
		
		screen.drawMap(map);
		
		Location l1 = gps.findCurrentLocation();
		Location l2 = gps.findCurrentLocation();
		
		pathFinder.findPath(l1, l2);
		
	}

}
