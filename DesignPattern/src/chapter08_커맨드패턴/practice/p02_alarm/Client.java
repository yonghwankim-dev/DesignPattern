package chapter08_커맨드패턴.practice.p02_alarm;
// 버튼을 눌렀을때 다른 기능을 실행하는 경우
// 램프를 켜는 대신 알람을 시작하게 Alarm 클래스를 추가하는 프로그램
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Alarm alarm = new Alarm();
		Button alarmButton = new Button(alarm);
		alarmButton.pressed(); // Alarming...
		
	}
}
