package chapter07_������Ʈ����.ch07_04;

public class Light {
	private State state = OFF.getInstance();			// �������� ���� ����
	
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
