package chapter13_추상팩토리패턴.exercise.ex01.factory;

import chapter13_추상팩토리패턴.exercise.ex01.gps.GPS;
import chapter13_추상팩토리패턴.exercise.ex01.map.Map;
import chapter13_추상팩토리패턴.exercise.ex01.pathfinder.PathFinder;
import chapter13_추상팩토리패턴.exercise.ex01.screen.Screen;

public abstract class NaviFactory {
	public abstract GPS createGPS();
	public abstract Map createMap();
	public abstract Screen createScreen();
	public abstract PathFinder createPathFinder();
}
