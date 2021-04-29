package chapter12_팩토리메서드패턴.ch12_04.SchedulerStrategy;

import chapter12_팩토리메서드패턴.ch12_04.ElevatorManager;

public interface ElevatorScheduler {
	public abstract int selectElevator(ElevatorManager manager, int destination, Direction direction);
}
