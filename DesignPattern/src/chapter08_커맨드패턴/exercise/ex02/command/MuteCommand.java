package chapter08_커맨드패턴.exercise.ex02.command;

public class MuteCommand implements Command{
	private TV tv;
	
	public MuteCommand(TV tv) {
		this.tv = tv;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		tv.mute();
	}
	
}
