package chapter08_Ŀ�ǵ�����.exercise.ex03;

import java.util.ArrayList;
import java.util.List;

import chapter08_Ŀ�ǵ�����.exercise.ex03.command.Direction;



public class ElevatorManager {	// ���� ���� ���������͸� �����ϴ� Ŭ����
	private List<ElevatorController> controllers;

	public ElevatorManager(int controllerCount) {
		controllers = new ArrayList<ElevatorController>(controllerCount);
	}
	
	// ElevatorController ��ü�� �߰���
	public void addController(ElevatorController controller)
	{
		controllers.add(controller);
	}
	
	public void requestElevator(int destination, Direction direction)
	{
		// ������ ���������͸� ������
		int selectedElevator = selectElevator(destination, direction);
		
		// ���õ� ���������͸� ������ ������ �̵���
		controllers.get(selectedElevator).gotoFloor(destination);
	}
	
	// ������ ���� ��û ���⿡ ���� ���������͸� ������
	private int selectElevator(int destination, Direction direction)
	{
		return 0;
		// ���������͸� ������, ����� ù��° ���������͸� �����ϰ� ����.
	}
}
