package chapter08_Ŀ�ǵ�����.practice.p05_commandpatternlamponoff.command;

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
