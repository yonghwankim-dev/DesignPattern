package chapter13_추상팩토리패턴.exercise.ex01.gps;

import chapter13_추상팩토리패턴.exercise.ex01.Location;

public class CheapGPS extends GPS{
	public Location findCurrentLocation()
	{
		System.out.println("Find current location with Cheap GPS");
		return null;
	}
}
