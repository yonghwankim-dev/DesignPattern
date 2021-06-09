package chapter12_팩토리메서드패턴.practice.p04_elevator_after2;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import chapter12_팩토리메서드패턴.practice.p04_elevator_after2.scheduler_strategy.Direction;
import chapter12_팩토리메서드패턴.practice.p04_elevator_after2.scheduler_strategy.ElevatorScheduler;
import chapter12_팩토리메서드패턴.practice.p04_elevator_after2.scheduler_strategy.ResponseTimeScheduler;
import chapter12_팩토리메서드패턴.practice.p04_elevator_after2.scheduler_strategy.SchedulerFactory;
import chapter12_팩토리메서드패턴.practice.p04_elevator_after2.scheduler_strategy.ScheulingStrategyID;
import chapter12_팩토리메서드패턴.practice.p04_elevator_after2.scheduler_strategy.ThroughputScheduler;

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
	
	public void requestElevator(int destination, Direction direction)
	{
		ElevatorScheduler scheduler = SchedulerFactory.getScheduler(strategyID);
		System.out.println(scheduler);
		int selectedElevator = scheduler.selectElevator(this, destination, direction);
		controllers.get(selectedElevator).gotoFloor(destination);
		
	}
}
