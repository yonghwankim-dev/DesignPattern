package chapter12_팩토리메서드패턴.practice.p02_elevator_problem;

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
		
		if(hour<12)	// 오전에는 ResponseTimeScheduler를 이용함
		{
			scheduler = new ResponseTimeScheduler();
		}
		else	// 오후에는 ThroughputScheduler를 이용함
		{
			scheduler = new ThroughputScheduler();
		}
		
		// ThroughputScheduler를 이용해 엘리베이터를 선택함
		int selectedElevator = scheduler.selectElevator(this, destination, direction);
		
		// 선택된 엘리베이터를 이동시킴
		controllers.get(selectedElevator).gotoFloor(destination); 
	}
}
