package chapter10_데커레이터패턴.ch10_03;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Display road = new RoadDisplay();
		for(String decoratorName: args)
		{
			if(decoratorName.equalsIgnoreCase("Lane"))
			{
				road = new LaneDecorator(road);
			}
			if(decoratorName.equalsIgnoreCase("Traffic"))
			{
				road = new TrafficDecorator(road);
			}
			if(decoratorName.equalsIgnoreCase("Crossing"))
			{
				road = new CrossingDecorator(road);
			}
		}
		road.draw();
	}

}
