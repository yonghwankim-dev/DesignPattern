package chapter10_��Ŀ����������.ch10_03;

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
		System.out.println("\t���뷮 ǥ��");
	}	
}
