package chapter08_커맨드패턴.ch08_04;

import chapter08_커맨드패턴.ch08_04.command.Alarm;
import chapter08_커맨드패턴.ch08_04.command.Command;
import chapter08_커맨드패턴.ch08_04.command.Lamp;



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
