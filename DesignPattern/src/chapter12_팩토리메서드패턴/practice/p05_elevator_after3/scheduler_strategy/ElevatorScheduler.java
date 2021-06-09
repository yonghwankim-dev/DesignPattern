package chapter12_팩토리메서드패턴.practice.p05_elevator_after3.scheduler_strategy;

import chapter12_팩토리메서드패턴.practice.p05_elevator_after3.ElevatorManager;

public interface ElevatorScheduler {
	public abstract int selectElevator(ElevatorManager manager, int destination, Direction direction);
}
