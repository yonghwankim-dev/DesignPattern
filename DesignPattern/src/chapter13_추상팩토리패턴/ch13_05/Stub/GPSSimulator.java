package chapter13_추상팩토리패턴.ch13_05.Stub;

import chapter13_추상팩토리패턴.ch13_05.Location;
import chapter13_추상팩토리패턴.ch13_05.GPS.GPS;

public class GPSSimulator extends GPS{

	@Override
	public Location findCurrentLocation() {
		// TODO Auto-generated method stub
		System.out.println("Find current location with GPS Simulator");
		return null;
	}
	
}
