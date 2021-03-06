package chapter08_커맨드패턴.practice.p05_commandpatternlamponoff;

import chapter08_커맨드패턴.practice.p05_commandpatternlamponoff.command.Command;

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
	
	public void pressed()		// 버튼이 눌리면 주어진 Command의 execute 메서드를 호출함.
	{
		theCommand.execute();
	}
}
