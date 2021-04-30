package chapter12_팩토리메서드패턴.ch12_05.SchedulerStrategy;

import java.util.Calendar;

import chapter12_팩토리메서드패턴.ch12_05.ElevatorManager;

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
