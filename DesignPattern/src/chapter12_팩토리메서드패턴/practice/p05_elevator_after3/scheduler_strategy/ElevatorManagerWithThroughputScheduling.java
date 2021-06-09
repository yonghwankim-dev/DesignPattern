package chapter12_팩토리메서드패턴.practice.p05_elevator_after3.scheduler_strategy;

import chapter12_팩토리메서드패턴.practice.p05_elevator_after3.ElevatorManager;

public class ElevatorManagerWithThroughputScheduling extends ElevatorManager{

	public ElevatorManagerWithThroughputScheduling(int controllerCount) {
		super(controllerCount);
	}
	
	protected ElevatorScheduler getScheduler() {
		ElevatorScheduler scheduler = ThroughputScheduler.getInstance();
		return scheduler;
	}
	
}
