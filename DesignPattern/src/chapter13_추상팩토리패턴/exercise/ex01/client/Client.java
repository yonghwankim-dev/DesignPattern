package chapter13_추상팩토리패턴.exercise.ex01.client;

import chapter13_추상팩토리패턴.exercise.ex01.Location;
import chapter13_추상팩토리패턴.exercise.ex01.factory.BasicNaviFactory;
import chapter13_추상팩토리패턴.exercise.ex01.factory.NaviFactory;
import chapter13_추상팩토리패턴.exercise.ex01.factory.PremiumNaviFactory;
import chapter13_추상팩토리패턴.exercise.ex01.gps.GPS;
import chapter13_추상팩토리패턴.exercise.ex01.map.Map;
import chapter13_추상팩토리패턴.exercise.ex01.pathfinder.PathFinder;
import chapter13_추상팩토리패턴.exercise.ex01.screen.Screen;

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
