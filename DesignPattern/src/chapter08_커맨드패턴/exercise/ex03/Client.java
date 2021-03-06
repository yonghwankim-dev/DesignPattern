package chapter08_커맨드패턴.exercise.ex03;

import chapter08_커맨드패턴.exercise.ex03.command.Command;
import chapter08_커맨드패턴.exercise.ex03.command.DestinationSelectionCommand;
import chapter08_커맨드패턴.exercise.ex03.command.Direction;
import chapter08_커맨드패턴.exercise.ex03.command.ElevatorRequestCommand;


public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ElevatorController controller1 = new ElevatorController(1);
		ElevatorController controller2 = new ElevatorController(2);

		ElevatorManager em = new ElevatorManager(2);
		em.addController(controller1);
		em.addController(controller2);

		// 1번 엘리베이터를 1층에 위치시키려는 목적의 목적지 층 버튼
		Command destinationCommand1stController = new DestinationSelectionCommand(1, controller1);
		ElevatorButton destinationButton1stFloor = new ElevatorButton(destinationCommand1stController);
		destinationButton1stFloor.pressed();

		// 2번 엘리베이터를 2층에 위치시키려는 목적의 목적지 층 버튼
		Command destinationCommand2stController = new DestinationSelectionCommand(2, controller2);
		ElevatorButton destinationButton2stFloor = new ElevatorButton(destinationCommand2stController);
		destinationButton2stFloor.pressed();
		
		// 1번 엘리베이터를 2층에서 아래로 이동시키려는 엘리베이터 요청버튼
		Command requestDownCommand = new ElevatorRequestCommand(2, Direction.DOWN, em);
		ElevatorButton requestDownFloorButton2ndFloor = new ElevatorButton(requestDownCommand);
		requestDownFloorButton2ndFloor.pressed();
		

	}

}
