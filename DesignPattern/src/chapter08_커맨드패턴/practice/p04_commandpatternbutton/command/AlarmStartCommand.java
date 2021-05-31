package chapter08_커맨드패턴.practice.p04_commandpatternbutton.command;

public class AlarmStartCommand implements Command{
	private Alarm theAlarm;
	
	
	
	public AlarmStartCommand(Alarm theAlarm) {
		this.theAlarm = theAlarm;
	}



	@Override
	public void execute() {
		// TODO Auto-generated method stub
		theAlarm.start();
	}

}
