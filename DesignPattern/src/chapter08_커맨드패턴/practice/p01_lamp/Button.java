package chapter08_Ŀ�ǵ�����.practice.p01_lamp;

public class Button {
	private Lamp theLamp;
	
	public Button(Lamp theLamp)
	{
		this.theLamp = theLamp;
	}
	
	public void pressed()
	{
		theLamp.turnOn();
	}
}
