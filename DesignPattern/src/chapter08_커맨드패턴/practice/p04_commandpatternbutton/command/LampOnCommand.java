package chapter08_커맨드패턴.practice.p04_commandpatternbutton.command;

public class LampOnCommand implements Command{
	private Lamp theLamp;
	
	public LampOnCommand(Lamp theLamp)
	{
		this.theLamp = theLamp;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		theLamp.turnOn();
	}
}
