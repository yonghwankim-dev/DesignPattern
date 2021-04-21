package chapter08_커맨드패턴.ch08_05;

import chapter08_커맨드패턴.ch08_05.command.Command;
import chapter08_커맨드패턴.ch08_05.command.Lamp;
import chapter08_커맨드패턴.ch08_05.command.LampOffCommand;
import chapter08_커맨드패턴.ch08_05.command.LampOnCommand;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lamp lamp = new Lamp();
		Command lampOnCommand = new LampOnCommand(lamp);
		Command lampOffCommand = new LampOffCommand(lamp);
		
		Button button1 = new Button(lampOnCommand);	// 램프를 켜는 커맨드를 설정함
		button1.pressed();	// 버튼을 누르면 램프가 켜짐
		
		button1.setCommand(lampOffCommand);	// 램프를 끄는 커맨드를 설정함
		button1.pressed();	// 이제 버튼을 누르면 램프가 꺼짐
	}

}
