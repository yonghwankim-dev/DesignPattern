package chapter13_추상팩토리패턴.ch13_05.PATHFINDER;

import chapter13_추상팩토리패턴.ch13_05.Location;
import chapter13_추상팩토리패턴.ch13_05.Path;

public class SlowPathFinder extends PathFinder{

	@Override
	public Path findPath(Location from, Location to) {
		// TODO Auto-generated method stub
		System.out.println("Slow Path Finder");
		return null;
	}
	

}
