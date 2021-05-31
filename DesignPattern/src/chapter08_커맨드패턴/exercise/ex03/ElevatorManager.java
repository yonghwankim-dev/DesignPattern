package chapter08_커맨드패턴.exercise.ex03;

import java.util.ArrayList;
import java.util.List;

import chapter08_커맨드패턴.exercise.ex03.command.Direction;



public class ElevatorManager {	// 복수 개의 엘리베이터를 관리하는 클래스
	private List<ElevatorController> controllers;

	public ElevatorManager(int controllerCount) {
		controllers = new ArrayList<ElevatorController>(controllerCount);
	}
	
	// ElevatorController 객체를 추가함
	public void addController(ElevatorController controller)
	{
		controllers.add(controller);
	}
	
	public void requestElevator(int destination, Direction direction)
	{
		// 적절한 엘리베이터를 선택함
		int selectedElevator = selectElevator(destination, direction);
		
		// 선택된 에릴베이터를 목적지 층으로 이동함
		controllers.get(selectedElevator).gotoFloor(destination);
	}
	
	// 목적지 층과 요청 방향에 따라 엘리베이터를 선택함
	private int selectElevator(int destination, Direction direction)
	{
		return 0;
		// 엘리베이터를 선택함, 현재는 첫번째 엘리베이터를 선택하고 있음.
	}
}
