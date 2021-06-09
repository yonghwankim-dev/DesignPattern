package chapter12_���丮�޼�������.practice.p05_elevator_after3.scheduler_strategy;

import java.util.Calendar;

import chapter12_���丮�޼�������.practice.p05_elevator_after3.ElevatorManager;

public class ElevatorManagerWithDynamicScheduling extends ElevatorManager{

	public ElevatorManagerWithDynamicScheduling(int controllerCount) {
		super(controllerCount);
	}
	
	protected ElevatorScheduler getScheduler() {
		ElevatorScheduler scheduler = null;
		
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		
		if(hour<12)
		{
			scheduler = ResponseTimeScheduler.getInstance();
		}
		else
		{
			scheduler = ThroughputScheduler.getInstance();
		}
		
		return scheduler;
	}
	
}
