package chapter12_팩토리메서드패턴.practice.p04_elevator_after2.scheduler_strategy;

import chapter12_팩토리메서드패턴.practice.p04_elevator_after2.ElevatorManager;

public interface ElevatorScheduler {
	public abstract int selectElevator(ElevatorManager manager, int destination, Direction direction);
}
