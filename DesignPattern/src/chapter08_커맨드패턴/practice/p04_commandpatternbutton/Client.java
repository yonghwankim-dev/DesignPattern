package chapter08_Ŀ�ǵ�����.practice.p04_commandpatternbutton;

import chapter08_Ŀ�ǵ�����.practice.p04_commandpatternbutton.command.Alarm;
import chapter08_Ŀ�ǵ�����.practice.p04_commandpatternbutton.command.AlarmStartCommand;
import chapter08_Ŀ�ǵ�����.practice.p04_commandpatternbutton.command.Command;
import chapter08_Ŀ�ǵ�����.practice.p04_commandpatternbutton.command.Lamp;
import chapter08_Ŀ�ǵ�����.practice.p04_commandpatternbutton.command.LampOnCommand;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lamp lamp = new Lamp();
		Command lampOnCommand = new LampOnCommand(lamp);
		
		Button button1 = new Button(lampOnCommand);	// ������ �Ѵ� Ŀ�ǵ带 ������
		button1.pressed(); // ��ư�� ������ ���� �Ѵ� ����� �����
		
		Alarm alarm = new Alarm();
		Command alarmOnCommand = new AlarmStartCommand(alarm);
		
		Button button2 = new Button(alarmOnCommand);	// �˶��� �︮�� Ŀ�ǵ带 ������
		button2.pressed(); // ���� ��ư�� ������ �˶��� �︮�� ����� �����
		
		button2.setCommand(lampOnCommand);
		button2.pressed();	// ������ ������ �Ѵ� ����� �����	
	}
}
