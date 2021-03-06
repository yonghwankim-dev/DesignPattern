package chapter12_팩토리메서드패턴.practice.p05_elevator_after3;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import chapter12_팩토리메서드패턴.practice.p05_elevator_after3.scheduler_strategy.Direction;
import chapter12_팩토리메서드패턴.practice.p05_elevator_after3.scheduler_strategy.ElevatorScheduler;


public abstract class ElevatorManager {
	private List<ElevatorController> controllers;
	
	
	public ElevatorManager(int controllerCount)
	{
		controllers = new ArrayList<ElevatorController>(controllerCount);
		for(int i=0;i<controllerCount;i++)
		{
			ElevatorController controller = new ElevatorController(i+1);
			controllers.add(controller);
		}	
	}
	
	protected abstract ElevatorScheduler getScheduler();	// primitive 또는 hook 메서드
	
	public void requestElevator(int destination, Direction direction)	// 템플릿 메서드
	{
		// 하위 클래스에서 오버라이드된 getScheduler를 호출함
		ElevatorScheduler scheduler = getScheduler();
		int selectedElevator = scheduler.selectElevator(this, destination, direction);
		controllers.get(selectedElevator).gotoFloor(destination);
	}
}
