package chapter08_Ŀ�ǵ�����.exercise.ex03.command;

import chapter08_Ŀ�ǵ�����.exercise.ex03.ElevatorController;

public class DestinationSelectionCommand implements Command{
	private int destination;
	private ElevatorController controller;
	
	
	
	public DestinationSelectionCommand(int destination, ElevatorController controller) {
		this.destination = destination;
		this.controller = controller;
	}



	@Override
	public void execute() {
		// TODO Auto-generated method stub
		controller.gotoFloor(destination);
	}

}
