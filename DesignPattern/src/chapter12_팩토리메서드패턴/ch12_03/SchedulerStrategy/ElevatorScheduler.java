package chapter12_팩토리메서드패턴.ch12_03.SchedulerStrategy;

import chapter12_팩토리메서드패턴.ch12_03.ElevatorManager;

public interface ElevatorScheduler {
	public abstract int selectElevator(ElevatorManager manager, int destination, Direction direction);
}
