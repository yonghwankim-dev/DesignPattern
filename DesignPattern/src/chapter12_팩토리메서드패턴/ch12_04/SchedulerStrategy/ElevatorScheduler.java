package chapter12_���丮�޼�������.ch12_04.SchedulerStrategy;

import chapter12_���丮�޼�������.ch12_04.ElevatorManager;

public interface ElevatorScheduler {
	public abstract int selectElevator(ElevatorManager manager, int destination, Direction direction);
}
