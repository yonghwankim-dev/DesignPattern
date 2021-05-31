package chapter08_Ŀ�ǵ�����.practice.p04_commandpatternbutton.command;

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
