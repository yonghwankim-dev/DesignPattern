package chapter12_팩토리메서드패턴.practice.p03_elevator_after;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import chapter12_팩토리메서드패턴.practice.p03_elevator_after.scheduler_strategy.Direction;
import chapter12_팩토리메서드패턴.practice.p03_elevator_after.scheduler_strategy.ElevatorScheduler;
import chapter12_팩토리메서드패턴.practice.p03_elevator_after.scheduler_strategy.SchedulerFactory;
import chapter12_팩토리메서드패턴.practice.p03_elevator_after.scheduler_strategy.ScheulingStrategyID;

public class ElevatorManager {
	private List<ElevatorController> controllers;
	private ScheulingStrategyID strategyID;
	
	public ElevatorManager(int controllerCount, ScheulingStrategyID strategyID)
	{
		controllers = new ArrayList<ElevatorController>(controllerCount);
		for(int i=0;i<controllerCount;i++)
		{
			ElevatorController controller = new ElevatorController(i+1);
			controllers.add(controller);
		}
		
		this.strategyID = strategyID;
	}
	
	public void setStrategyID(ScheulingStrategyID strategyID)
	{
		this.strategyID = strategyID;
	}
	
	public void requestElevator(int destination, Direction direction)
	{
		ElevatorScheduler scheduler = SchedulerFactory.getScheduler(strategyID);
		System.out.println(scheduler);
		int selectedElevator = scheduler.selectElevator(this, destination, direction);
		controllers.get(selectedElevator).gotoFloor(destination);
		
	}
}
