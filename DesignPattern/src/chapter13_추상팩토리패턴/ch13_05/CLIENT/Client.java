package chapter13_추상팩토리패턴.ch13_05.CLIENT;

import chapter13_추상팩토리패턴.ch13_05.Location;
import chapter13_추상팩토리패턴.ch13_05.FACTORY.BasicNaviFactory;
import chapter13_추상팩토리패턴.ch13_05.FACTORY.NaviFactory;
import chapter13_추상팩토리패턴.ch13_05.FACTORY.PremiumNaviFactory;
import chapter13_추상팩토리패턴.ch13_05.GPS.GPS;
import chapter13_추상팩토리패턴.ch13_05.MAP.Map;
import chapter13_추상팩토리패턴.ch13_05.PATHFINDER.PathFinder;
import chapter13_추상팩토리패턴.ch13_05.SCREEN.Screen;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//NaviFactory factory = new BasicNaviFactory();
		NaviFactory factory = new PremiumNaviFactory();
		
		GPS gps = factory.createGPS();
		Screen mapScreen = factory.createScreen();
		PathFinder pathFinder = factory.createPathFinder();
		
		Map map = factory.createMap();
		mapScreen.drawMap(map);
		
		Location l1 = gps.findCurrentLocation();
		Location l2 = gps.findCurrentLocation();
		
		pathFinder.findPath(l1, l2);
	}

}
