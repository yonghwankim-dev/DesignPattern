package chapter13_추상팩토리패턴.ch13_05.CLIENT;

import chapter13_추상팩토리패턴.ch13_05.Location;
import chapter13_추상팩토리패턴.ch13_05.FACTORY.BasicNaviFactory;
import chapter13_추상팩토리패턴.ch13_05.FACTORY.NaviFactory;
import chapter13_추상팩토리패턴.ch13_05.GPS.GPS;
import chapter13_추상팩토리패턴.ch13_05.MAP.Map;
import chapter13_추상팩토리패턴.ch13_05.PATHFINDER.PathFinder;
import chapter13_추상팩토리패턴.ch13_05.SCREEN.Screen;
import chapter13_추상팩토리패턴.ch13_05.Stub.NaviTestFacotry;

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
