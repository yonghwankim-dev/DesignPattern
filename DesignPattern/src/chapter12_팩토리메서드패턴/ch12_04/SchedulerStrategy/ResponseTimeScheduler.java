package chapter12_팩토리메서드패턴.ch12_04.SchedulerStrategy;

import chapter12_팩토리메서드패턴.ch12_04.ElevatorManager;

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
