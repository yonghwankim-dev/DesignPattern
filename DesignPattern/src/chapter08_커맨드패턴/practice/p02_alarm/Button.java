package chapter08_커맨드패턴.practice.p02_alarm;

public class Button {
	private Alarm theAlarm;
	
	public Button(Alarm theAlarm)
	{
		this.theAlarm = theAlarm;
	}
	
	public void pressed()
	{
		theAlarm.start();	// 버튼을 누르면 알람이 울림
	}
}
