package chapter10_��Ŀ����������.practice.p03_roadDisplay_after2;

public class CrossingDecorator extends DisplayDecorator{

	public CrossingDecorator(Display decoratedDisplay) {
		super(decoratedDisplay);
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		super.draw();
		drawCrossing();
	}
	
	private void drawCrossing()
	{
		System.out.println("\t������ ǥ��");
	}	
}
