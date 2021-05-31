package chapter08_커맨드패턴.practice.p05_commandpatternlamponoff.command;

public class LampOffCommand implements Command{
	private Lamp theLamp;
	
	public LampOffCommand(Lamp theLamp)
	{
		this.theLamp = theLamp;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		theLamp.turnOff();
	}
	
}
