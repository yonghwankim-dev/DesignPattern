package chapter08_Ŀ�ǵ�����.practice.p05_commandpatternlamponoff;

import chapter08_Ŀ�ǵ�����.practice.p05_commandpatternlamponoff.command.Command;

public class Button {
	private Command theCommand;
	
	public Button(Command theCommand)
	{
		setCommand(theCommand);
	}
	
	public void setCommand(Command newCommand)
	{
		this.theCommand = newCommand;
	}
	
	public void pressed()		// ��ư�� ������ �־��� Command�� execute �޼��带 ȣ����.
	{
		theCommand.execute();
	}
}
