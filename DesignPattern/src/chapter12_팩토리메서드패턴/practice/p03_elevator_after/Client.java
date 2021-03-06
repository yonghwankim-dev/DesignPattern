package chapter12_팩토리메서드패턴.practice.p03_elevator_after;

import chapter12_팩토리메서드패턴.practice.p03_elevator_after.scheduler_strategy.Direction;
import chapter12_팩토리메서드패턴.practice.p03_elevator_after.scheduler_strategy.ScheulingStrategyID;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ElevatorManager emWithResponseTimeScheduler = new ElevatorManager(2, ScheulingStrategyID.RESPONSE_TIME);
		emWithResponseTimeScheduler.requestElevator(10, Direction.UP);
		
		ElevatorManager emWithThroughputScheduler = new ElevatorManager(2, ScheulingStrategyID.THROUGHPUT);
		emWithThroughputScheduler.requestElevator(10, Direction.UP);
		
		ElevatorManager emWithDynamicScheduler = new ElevatorManager(2, ScheulingStrategyID.DYNAMIC);
		emWithDynamicScheduler.requestElevator(10, Direction.UP);
	}

}
