package chapter08_커맨드패턴.exercise.ex02.command;

public class PowerCommand implements Command {
	private TV tv;
	
	
	public PowerCommand(TV tv) {
		this.tv = tv;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		tv.power();
	}
	
}
