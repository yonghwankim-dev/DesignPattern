package chapter12_팩토리메서드패턴.ch12_05.SchedulerStrategy;

import chapter12_팩토리메서드패턴.ch12_05.ElevatorManager;

public class ElevatorManagerWithThroughputScheduling extends ElevatorManager{

	public ElevatorManagerWithThroughputScheduling(int controllerCount) {
		super(controllerCount);
	}
	
	protected ElevatorScheduler getScheduler() {
		ElevatorScheduler scheduler = ThroughputScheduler.getInstance();
		return scheduler;
	}
	
}
