package chapter12_���丮�޼�������.practice.p02_elevator_problem;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ElevatorManager {
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
	
	public void requestElevator(int destination, Direction direction)
	{
		ElevatorScheduler scheduler;
		
		// 0..23
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		
		if(hour<12)	// �������� ResponseTimeScheduler�� �̿���
		{
			scheduler = new ResponseTimeScheduler();
		}
		else	// ���Ŀ��� ThroughputScheduler�� �̿���
		{
			scheduler = new ThroughputScheduler();
		}
		
		// ThroughputScheduler�� �̿��� ���������͸� ������
		int selectedElevator = scheduler.selectElevator(this, destination, direction);
		
		// ���õ� ���������͸� �̵���Ŵ
		controllers.get(selectedElevator).gotoFloor(destination); 
	}
}
