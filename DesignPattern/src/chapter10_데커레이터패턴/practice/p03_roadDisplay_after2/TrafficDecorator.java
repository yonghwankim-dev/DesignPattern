package chapter10_데커레이터패턴.practice.p03_roadDisplay_after2;

public class TrafficDecorator extends DisplayDecorator{

	public TrafficDecorator(Display decoratedDisplay) {
		super(decoratedDisplay);
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		super.draw();
		drawTraffic();
	}
	
	private void drawTraffic()
	{
		System.out.println("\t교통량 표시");
	}	
}
