package chapter03_SOLID��Ģ.practice.p02_OCP_OpenClosedPrinciple.time.after;

public class TimeReminder {
	TimeProvider tProv;
	MP3 m = new MP3();
	
	public void setTimeProvider(TimeProvider tProv)
	{
		this.tProv = tProv;	// �׽�Ʈ �����̳� �ð��� �����ϴ� �ν��Ͻ� ����
	}
	
	public void reminder()
	{
		int hours = tProv.getTime();
		if(hours>=22)
		{
			m.playSong();
		}
	}
}
