package chapter08_Ŀ�ǵ�����.practice.p02_alarm;

public class Button {
	private Alarm theAlarm;
	
	public Button(Alarm theAlarm)
	{
		this.theAlarm = theAlarm;
	}
	
	public void pressed()
	{
		theAlarm.start();	// ��ư�� ������ �˶��� �︲
	}
}
