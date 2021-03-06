package chapter10_데커레이터패턴.practice.p02_roadDisplay_after;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Display road = new RoadDisplay();
		road.draw();	// 기본 도로 표시
		
		Display roadWithLane = new LaneDecorator(new RoadDisplay());
		roadWithLane.draw(); // 기본 도로 표시 + 차선 표시
		
		Display roadWithTraffic = new TrafficDecorator(new RoadDisplay());
		roadWithTraffic.draw(); // 기본 도로 표시 + 교통량 표시
		
		
		Display roadWithLaneAndTraffic = new TrafficDecorator(new LaneDecorator(new RoadDisplay()));
		roadWithLaneAndTraffic.draw();
	}

}
