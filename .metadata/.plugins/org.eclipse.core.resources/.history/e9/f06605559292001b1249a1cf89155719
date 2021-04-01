package chapter03_SOLID¿øÄ¢.ch03_115p;

public class TimeReminder {
	TimeProvider tProv;
	MP3 m = new MP3();
	
	public void setTimeProvider(TimeProvider tProv)
	{
		this.tProv = tProv;
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
