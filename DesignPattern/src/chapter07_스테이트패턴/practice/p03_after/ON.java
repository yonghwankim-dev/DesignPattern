package chapter07_스테이트패턴.practice.p03_after;

public class ON implements State{
	private static ON on = new ON();	// ON 클래스의 인스턴스로 초기화
	
	public ON()
	{
		
	}
	
	public static ON getInstance()	// 초기화된 ON 클래스의 인스턴스를 반환함
	{
		return on;
	}
	
	@Override
	public void on_button_pushed(Light light) {
		// TODO Auto-generated method stub
		System.out.println("반응 없음");
	}

	@Override
	public void off_button_pushed(Light light) {
		// TODO Auto-generated method stub
		light.setState(OFF.getInstance());
		System.out.println("Light Off");
		
	}

}
