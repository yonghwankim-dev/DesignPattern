package chapter10_데커레이터패턴.practice.p03_roadDisplay_after2;

public class LaneDecorator extends DisplayDecorator{

	public LaneDecorator(Display decoratedDisplay) {
		super(decoratedDisplay);
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		super.draw();
		drawLane();
	}
	
	private void drawLane()
	{
		System.out.println("\t차선 표시");
	}	
}
