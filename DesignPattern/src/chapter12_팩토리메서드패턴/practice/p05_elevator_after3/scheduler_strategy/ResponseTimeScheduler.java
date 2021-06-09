package chapter12_팩토리메서드패턴.practice.p05_elevator_after3.scheduler_strategy;

import chapter12_팩토리메서드패턴.practice.p05_elevator_after3.ElevatorManager;

public class ResponseTimeScheduler implements ElevatorScheduler {
	
	private static ElevatorScheduler scheduler;
	private ResponseTimeScheduler() {
		// TODO Auto-generated constructor stub
	}
	
	public static ElevatorScheduler getInstance()
	{
		if(scheduler==null)
		{
			scheduler = new ResponseTimeScheduler();
		}
		return scheduler;
	}
	
	@Override
	public int selectElevator(ElevatorManager manager, int destination, Direction direction) {
		// TODO Auto-generated method stub
		return 1;
	}

}
