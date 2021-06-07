package chapter10_데커레이터패턴.practice.p01_roadDisplay_before;

public class RoadDisplayWithTraffic extends RoadDisplay {

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		super.draw();	// 상위 클래스, 즉 RoadDisplay 클래스의 draw 메서드를 호출해서 기본 도로를 표시
		drawTraffic();
	}

	private void drawTraffic() {
		// TODO Auto-generated method stub
		System.out.println("교통량 표시");
	}
}
