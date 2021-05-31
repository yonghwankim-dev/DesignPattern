package chapter07_스테이트패턴.ch07_04;

public class Light {
	private State state = OFF.getInstance();			// 형광등의 현재 상태
	
	public void setState(State state)
	{
		this.state = state;
	}
	
	public void on_button_pushed() 
	{
		state.on_button_pushed(this);
	}
	
	public void off_button_pushed()
	{
		state.off_button_pushed(this);
	}
}
