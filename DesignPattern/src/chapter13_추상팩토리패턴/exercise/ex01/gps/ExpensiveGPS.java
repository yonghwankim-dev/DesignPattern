package chapter13_추상팩토리패턴.exercise.ex01.gps;

import chapter13_추상팩토리패턴.exercise.ex01.Location;

public class ExpensiveGPS extends GPS{
	public Location findCurrentLocation()
	{
		System.out.println("Find current location with Expensive GPS");
		return null;
	}
}
