package chapter10_��Ŀ����������.practice.p01_roadDisplay_before;

public class RoadDisplayWithTraffic extends RoadDisplay {

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		super.draw();	// ���� Ŭ����, �� RoadDisplay Ŭ������ draw �޼��带 ȣ���ؼ� �⺻ ���θ� ǥ��
		drawTraffic();
	}

	private void drawTraffic() {
		// TODO Auto-generated method stub
		System.out.println("���뷮 ǥ��");
	}
}
