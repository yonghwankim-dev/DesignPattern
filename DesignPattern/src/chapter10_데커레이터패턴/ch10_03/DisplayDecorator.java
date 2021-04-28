package chapter10_��Ŀ����������.ch10_03;

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
