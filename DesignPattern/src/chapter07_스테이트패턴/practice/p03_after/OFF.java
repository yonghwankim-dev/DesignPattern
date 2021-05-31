package chapter07_스테이트패턴.practice.p03_after;

public class OFF implements State{
	private static OFF off = new OFF();
	
	public OFF()
	{
		
	}
	
	public static State getInstance() {
		// TODO Auto-generated method stub
		return off;
	}
	
	@Override
	public void on_button_pushed(Light light) {
		// TODO Auto-generated method stub
		light.setState(ON.getInstance());
		System.out.println("Light On");
		
	}

	@Override
	public void off_button_pushed(Light light) {
		// TODO Auto-generated method stub
		System.out.println("반응 없음");
	}

	

}
