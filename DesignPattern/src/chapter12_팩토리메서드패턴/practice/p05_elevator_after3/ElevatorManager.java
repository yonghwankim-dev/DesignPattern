package chapter12_���丮�޼�������.practice.p05_elevator_after3;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import chapter12_���丮�޼�������.practice.p05_elevator_after3.scheduler_strategy.Direction;
import chapter12_���丮�޼�������.practice.p05_elevator_after3.scheduler_strategy.ElevatorScheduler;


public abstract class ElevatorManager {
	private List<ElevatorController> controllers;
	
	
	public ElevatorManager(int controllerCount)
	{
		controllers = new ArrayList<ElevatorController>(controllerCount);
		for(int i=0;i<controllerCount;i++)
		{
			ElevatorController controller = new ElevatorController(i+1);
			controllers.add(controller);
		}	
	}
	
	protected abstract ElevatorScheduler getScheduler();	// primitive �Ǵ� hook �޼���
	
	public void requestElevator(int destination, Direction direction)	// ���ø� �޼���
	{
		// ���� Ŭ�������� �������̵�� getScheduler�� ȣ����
		ElevatorScheduler scheduler = getScheduler();
		int selectedElevator = scheduler.selectElevator(this, destination, direction);
		controllers.get(selectedElevator).gotoFloor(destination);
	}
}
