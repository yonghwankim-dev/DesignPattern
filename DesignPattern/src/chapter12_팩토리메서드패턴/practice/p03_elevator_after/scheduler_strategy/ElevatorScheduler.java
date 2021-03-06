package chapter12_팩토리메서드패턴.practice.p03_elevator_after.scheduler_strategy;

import chapter12_팩토리메서드패턴.practice.p03_elevator_after.ElevatorManager;

public interface ElevatorScheduler {
	public abstract int selectElevator(ElevatorManager manager, int destination, Direction direction);
}
