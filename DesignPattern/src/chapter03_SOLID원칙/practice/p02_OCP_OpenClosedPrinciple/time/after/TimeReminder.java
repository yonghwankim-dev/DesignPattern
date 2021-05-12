package chapter03_SOLID원칙.practice.p02_OCP_OpenClosedPrinciple.time.after;

public class TimeReminder {
	TimeProvider tProv;
	MP3 m = new MP3();
	
	public void setTimeProvider(TimeProvider tProv)
	{
		this.tProv = tProv;	// 테스트 스텁이나 시간을 제공하는 인스턴스 주입
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
