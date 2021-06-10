package chapter13_추상팩토리패턴.exercise.ex01.stub;

import chapter13_추상팩토리패턴.exercise.ex01.Location;
import chapter13_추상팩토리패턴.exercise.ex01.Path;
import chapter13_추상팩토리패턴.exercise.ex01.pathfinder.PathFinder;

public class TestPathFinder extends PathFinder{

	@Override
	public Path findPath(Location from, Location to) {
		// TODO Auto-generated method stub
		System.out.println("Test Path Finder");
		return null;
	}
	
}
