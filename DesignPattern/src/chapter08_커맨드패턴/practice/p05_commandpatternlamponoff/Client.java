package chapter08_Ŀ�ǵ�����.practice.p05_commandpatternlamponoff;

import chapter08_Ŀ�ǵ�����.practice.p05_commandpatternlamponoff.command.Command;
import chapter08_Ŀ�ǵ�����.practice.p05_commandpatternlamponoff.command.Lamp;
import chapter08_Ŀ�ǵ�����.practice.p05_commandpatternlamponoff.command.LampOffCommand;
import chapter08_Ŀ�ǵ�����.practice.p05_commandpatternlamponoff.command.LampOnCommand;

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
