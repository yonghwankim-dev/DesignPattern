package chapter13_추상팩토리패턴.exercise.ex01.stub;

import chapter13_추상팩토리패턴.exercise.ex01.Location;
import chapter13_추상팩토리패턴.exercise.ex01.gps.GPS;

public class GPSSimulator extends GPS{

	@Override
	public Location findCurrentLocation() {
		// TODO Auto-generated method stub
		System.out.println("Find current location with GPS Simulator");
		return null;
	}
	
}
