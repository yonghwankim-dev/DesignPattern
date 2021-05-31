package chapter08_Ŀ�ǵ�����.exercise.ex03;

import chapter08_Ŀ�ǵ�����.exercise.ex03.command.Command;

public class ElevatorButton {	// ���������� ���� �Ǵ� ������ ���������͸� �̵�/��û�ϴ� ��ư
	private Command command;

	// DestinationSelectionCommand �Ǵ� ElevatorRequestCommand ��ü�� �־���
	public ElevatorButton(Command command) {
		this.command = command;
	}
	
	public void pressed()	// ��ư�� ������ �־��� command�� execute�� ȣ���Ѵ�.
	{
		command.execute();
	}
	
}
