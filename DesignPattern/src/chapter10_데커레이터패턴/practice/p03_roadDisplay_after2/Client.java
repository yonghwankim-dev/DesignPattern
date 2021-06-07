package chapter10_��Ŀ����������.practice.p03_roadDisplay_after2;

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
