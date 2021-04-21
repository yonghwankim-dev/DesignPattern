package chapter08_커맨드패턴.ch08_06;

public class TwoButtonController {
	private TV tv;

	public TwoButtonController(TV tv) {
		this.tv = tv;
	}
	
	public void button1Pressed()
	{
		tv.power();
	}
	
	public void button2Pressed()
	{
		tv.mute();
	}
	
	
}
