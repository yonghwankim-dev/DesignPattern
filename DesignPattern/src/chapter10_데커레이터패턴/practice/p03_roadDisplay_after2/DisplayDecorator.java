package chapter10_데커레이터패턴.practice.p03_roadDisplay_after2;

public abstract class DisplayDecorator extends Display {
	private Display decoratedDisplay;
	
	public DisplayDecorator(Display decoratedDisplay)
	{
		this.decoratedDisplay = decoratedDisplay;
	}
	
	public void draw()
	{
		decoratedDisplay.draw();
	}
}
