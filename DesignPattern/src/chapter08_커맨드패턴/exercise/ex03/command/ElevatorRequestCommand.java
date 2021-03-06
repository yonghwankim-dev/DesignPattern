package chapter08_커맨드패턴.exercise.ex03.command;

import chapter08_커맨드패턴.exercise.ex03.ElevatorManager;

// 건물의 층에서 버튼을 눌렀을 때 여러 엘리베이터 중에서 적절한 엘리베이터를 해당 층으로 이동시킴
public class ElevatorRequestCommand implements Command{
	private int destination;		// 요청방향, 즉 위로 또는 아래로
	private Direction direction;	// 목적지 층, 즉 버튼이 눌린 층
	private ElevatorManager em;		// 적절한 엘리베이터를 이동시킬 때 필요한 ElevatorManager
	

	public ElevatorRequestCommand(int destination, Direction direction, ElevatorManager em) {
		this.destination = destination;
		this.direction = direction;
		this.em = em;
	}


	// 주어진 ElevatorManager의 requestElevator 메서드를 호출해 목적지 층(destination)과
	// 요청 방향(direction)에 따라 적절한 엘리베이터를 이동시킴
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		em.requestElevator(destination, direction);
	}

}
