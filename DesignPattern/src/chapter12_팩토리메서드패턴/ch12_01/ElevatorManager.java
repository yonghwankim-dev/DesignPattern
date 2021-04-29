package chapter12_���丮�޼�������.ch12_01;

import java.util.ArrayList;
import java.util.List;

public class ElevatorManager {
	private List<ElevatorController> controllers;
	private ThroughputScheduler scheduler;
	
	public ElevatorManager(int controllerCount)
	{
		controllers = new ArrayList<ElevatorController>(controllerCount);
		for(int i=0;i<controllerCount;i++)
		{
			ElevatorController controller = new ElevatorController(i);
			controllers.add(controller);
		}
		scheduler = new ThroughputScheduler();	// ThroughputScheduler ��ü�� ������
	}
	
	public void requestElevator(int destination, Direction direction)
	{
		// ThroughputScheduler�� �̿��� ���������͸� ������
		int selectedElevator = scheduler.selectElevator(this, destination, direction);
		
		// ���õ� ���������͸� �̵���Ŵ
		controllers.get(selectedElevator).gotoFloor(destination);
	}
}
