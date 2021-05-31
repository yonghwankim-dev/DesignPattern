package chapter08_커맨드패턴.exercise.ex03;

import chapter08_커맨드패턴.exercise.ex03.command.Command;

public class ElevatorButton {	// 엘리베이터 내부 또는 층에서 엘리베이터를 이동/요청하는 버튼
	private Command command;

	// DestinationSelectionCommand 또는 ElevatorRequestCommand 객체가 주어짐
	public ElevatorButton(Command command) {
		this.command = command;
	}
	
	public void pressed()	// 버튼이 눌리면 주어진 command의 execute를 호출한다.
	{
		command.execute();
	}
	
}
