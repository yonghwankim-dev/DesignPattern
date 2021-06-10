package chapter13_추상팩토리패턴.exercise.ex01.pathfinder;

import chapter13_추상팩토리패턴.exercise.ex01.Location;
import chapter13_추상팩토리패턴.exercise.ex01.Path;

public abstract class PathFinder {
	public abstract Path findPath(Location from, Location to);
}
