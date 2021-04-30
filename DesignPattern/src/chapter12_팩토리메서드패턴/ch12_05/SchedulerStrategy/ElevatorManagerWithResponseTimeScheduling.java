package chapter12_팩토리메서드패턴.ch12_05.SchedulerStrategy;

import chapter12_팩토리메서드패턴.ch12_05.ElevatorManager;

public class ElevatorManagerWithResponseTimeScheduling extends ElevatorManager{

	public ElevatorManagerWithResponseTimeScheduling(int controllerCount) {
		super(controllerCount);
	}
	
	protected ElevatorScheduler getScheduler() {
		ElevatorScheduler scheduler = ResponseTimeScheduler.getInstance();
		return scheduler;
	}
	
}
