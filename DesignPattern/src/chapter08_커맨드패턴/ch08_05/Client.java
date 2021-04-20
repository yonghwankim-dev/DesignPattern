package chapter08_Ŀ�ǵ�����.ch08_05;

import chapter08_Ŀ�ǵ�����.ch08_05.command.Command;
import chapter08_Ŀ�ǵ�����.ch08_05.command.Lamp;
import chapter08_Ŀ�ǵ�����.ch08_05.command.LampOffCommand;
import chapter08_Ŀ�ǵ�����.ch08_05.command.LampOnCommand;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lamp lamp = new Lamp();
		Command lampOnCommand = new LampOnCommand(lamp);
		Command lampOffCommand = new LampOffCommand(lamp);
		
		Button button1 = new Button(lampOnCommand);	// ������ �Ѵ� Ŀ�ǵ带 ������
		button1.pressed();	// ��ư�� ������ ������ ����
		
		button1.setCommand(lampOffCommand);	// ������ ���� Ŀ�ǵ带 ������
		button1.pressed();	// ���� ��ư�� ������ ������ ����
	}

}
