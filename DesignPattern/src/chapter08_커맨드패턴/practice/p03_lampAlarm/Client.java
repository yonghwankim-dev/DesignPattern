package chapter08_Ŀ�ǵ�����.practice.p03_lampAlarm;

// ��ư�� ������ ���ۿ� ���� �ٸ� ����� �����ϴ� ���
// ��ư�� ó�� ��������� ������ �Ѱ�, �ι� ������ ���� �˶��� �����ϰ� �Ѵ�.
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
