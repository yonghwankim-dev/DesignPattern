package chapter13_추상팩토리패턴.ch13_05.PATHFINDER;

import chapter13_추상팩토리패턴.ch13_05.Location;
import chapter13_추상팩토리패턴.ch13_05.Path;

public abstract class PathFinder {
	public abstract Path findPath(Location from, Location to);
}
