package chapter07_스테이트패턴.practice.p02_before_add_sleeping;

public class Light {
	private static int ON = 0;	// 형광등이 켜진 상태
	private static int OFF = 1;	// 형광등이 꺼진 상태
	private static int SLEEPING = 2;	// 취침등 상태
	private int state;			// 형광등의 현재 상태
	
	public Light() 
	{
		this.state = OFF;	// 형광등 초기 상태는 꺼저 있는 상태임
	}
	
	public void on_button_pushed() 
	{
		if(state==ON)	// 형광등이 켜저 있는 상태에서 On 버튼을 누르면 취침등 상태로 전환됨
		{
			System.out.println("취침등 상태");
			state = SLEEPING;
		}
		else if(state==SLEEPING)	// 형광등이 취침등 상태에 있는 경우
		{
			System.out.println("Light On!");
			state = ON;
		}
		else
		{
			System.out.println("Light On");
			state = ON;
		}
	}
	
	public void off_button_pushed()
	{
		if(state==OFF)
		{
			System.out.println("반응 없음");
		}
		else if(state==SLEEPING)	// 형광등이 취침등 상태에 있는 경우
		{
			System.out.println("Light Off!");	// Off 버튼을 누르면 OFF로 전환됨
			state = OFF;
		}
		else	// 형광등이 켜저 있을 때 Off 버튼을 누르면 꺼진 상태로 전환됨
		{
			System.out.println("Light Off");
			state = OFF;
		}
	}
}
