package chapter08_커맨드패턴.ch08_02;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Alarm alarm = new Alarm();
		Button alarmButton = new Button(alarm);
		alarmButton.pressed();
		
	}

}
