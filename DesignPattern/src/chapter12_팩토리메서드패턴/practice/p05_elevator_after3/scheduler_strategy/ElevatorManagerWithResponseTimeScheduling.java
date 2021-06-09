package chapter12_팩토리메서드패턴.practice.p05_elevator_after3.scheduler_strategy;

import chapter12_팩토리메서드패턴.practice.p05_elevator_after3.ElevatorManager;

public class ElevatorManagerWithResponseTimeScheduling extends ElevatorManager{

	public ElevatorManagerWithResponseTimeScheduling(int controllerCount) {
		super(controllerCount);
	}
	
	protected ElevatorScheduler getScheduler() {
		ElevatorScheduler scheduler = ResponseTimeScheduler.getInstance();
		return scheduler;
	}
	
}
