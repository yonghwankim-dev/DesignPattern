package chapter12_팩토리메서드패턴.practice.p02_elevator_problem;

public interface ElevatorScheduler {
	public abstract int selectElevator(ElevatorManager manager, int destination, Direction direction);
}
