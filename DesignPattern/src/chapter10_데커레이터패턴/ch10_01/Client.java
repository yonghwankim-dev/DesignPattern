package chapter10_��Ŀ����������.ch10_01;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RoadDisplay road = new RoadDisplay();
		road.draw();	// �⺻ ���θ� ǥ��
		
		RoadDisplay roadWithLane = new RoadDisplayWithLane();
		roadWithLane.draw();	// �⺻ ���� + ���� ǥ��
		
	}

}
