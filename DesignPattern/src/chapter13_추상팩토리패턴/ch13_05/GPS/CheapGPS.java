package chapter13_추상팩토리패턴.ch13_05.GPS;

import chapter13_추상팩토리패턴.ch13_05.Location;

public class CheapGPS extends GPS{
	public Location findCurrentLocation()
	{
		System.out.println("Find current location with Cheap GPS");
		return null;
	}
}
