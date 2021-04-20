package chapter08_커맨드패턴.ch08_01;

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
