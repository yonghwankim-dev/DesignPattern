package chapter08_커맨드패턴.practice.p03_lampAlarm;

// 버튼을 누르는 동작에 따라 다른 기능을 실행하는 경우
// 버튼을 처음 눌렀을대는 램프를 켜고, 두번 눌럿을 때는 알람을 동작하게 한다.
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lamp lamp = new Lamp();
		Alarm alarm = new Alarm();
		Button button = new Button(lamp,alarm);
		
		button.setMode(Mode.LAMP);
		button.pressed();
		
		button.setMode(Mode.ALARM);
		button.pressed();
		
	}

}
