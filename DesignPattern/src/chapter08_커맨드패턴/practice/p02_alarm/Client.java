package chapter08_Ŀ�ǵ�����.practice.p02_alarm;
// ��ư�� �������� �ٸ� ����� �����ϴ� ���
// ������ �Ѵ� ��� �˶��� �����ϰ� Alarm Ŭ������ �߰��ϴ� ���α׷�
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Alarm alarm = new Alarm();
		Button alarmButton = new Button(alarm);
		alarmButton.pressed(); // Alarming...
		
	}
}
