package chapter08_커맨드패턴.practice.p04_commandpatternbutton;

import chapter08_커맨드패턴.practice.p04_commandpatternbutton.command.Alarm;
import chapter08_커맨드패턴.practice.p04_commandpatternbutton.command.AlarmStartCommand;
import chapter08_커맨드패턴.practice.p04_commandpatternbutton.command.Command;
import chapter08_커맨드패턴.practice.p04_commandpatternbutton.command.Lamp;
import chapter08_커맨드패턴.practice.p04_commandpatternbutton.command.LampOnCommand;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lamp lamp = new Lamp();
		Command lampOnCommand = new LampOnCommand(lamp);
		
		Button button1 = new Button(lampOnCommand);	// 램프를 켜는 커맨드를 설정함
		button1.pressed(); // 버튼이 눌리면 램프 켜는 기능이 실행됨
		
		Alarm alarm = new Alarm();
		Command alarmOnCommand = new AlarmStartCommand(alarm);
		
		Button button2 = new Button(alarmOnCommand);	// 알람을 울리는 커맨드를 설정함
		button2.pressed(); // 이제 버튼이 눌리면 알람을 울리는 기능이 실행됨
		
		button2.setCommand(lampOnCommand);
		button2.pressed();	// 이제는 램프를 켜는 기능이 실행됨	
	}
}
