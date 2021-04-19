package chapter07_스테이트패턴.ch07_04;

public class SLEEPING implements State{
	private static SLEEPING sleeping = new SLEEPING();
			
	public static State getInstance() {
		// TODO Auto-generated method stub
		return sleeping;
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
		light.setState(OFF.getInstance());
		System.out.println("Light Off");
	}
}
