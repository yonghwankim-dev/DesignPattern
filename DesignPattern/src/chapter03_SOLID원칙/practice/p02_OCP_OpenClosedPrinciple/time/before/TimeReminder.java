package chapter03_SOLID��Ģ.practice.p02_OCP_OpenClosedPrinciple.time.before;

import java.util.Calendar;


// Question
// �Ʒ��� �ڵ�� ���� 10�ð� �Ǹ� MP3�� �۵����� ������ �����Ѵ�.
// �׷��� �� �ڵ尡 ����� �۵��ϴ��� �׽�Ʈ�Ϸ��� ���� 10�ñ��� ��ٷ��� �Ѵ�.
// OCP�� ������ �� ������ �ذ��ϴ� �ڵ带 �ۼ��϶�.
public class TimeReminder {
	private MP3 m;
	
	public void reminder()
	{
		Calendar cal = Calendar.getInstance();
		m = new MP3();
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		
		if(hour>=22) {
			m.playSong();
		}
	}
}

// �������
// 1. ���� �ð��� ����ؼ� �׽�Ʈ�ϴ� ����� �ſ� ���ŷӰ� �ð��� ���� �ɸ��Ƿ� �ð��� ���ϴ´�� ������ �̿��� �� �ִ� ����� ã�ƾ� �Ѵ�.
// 2. �������̽��� ����� �� �������̽����� �Ļ��� 2���� Ŭ������ �����.
// 3. �� Ŭ������ ��¥ �ð��� �����ϴ� Ŭ������, �ٸ� �� Ŭ������ �׽�Ʈ�� ����� �� �ְ� ������ �ð��� ���ϴ� ��� ������ �� �ִ� Ŭ������.
// 4. �̷��� ����� TimeReminder Ŭ������ ���� �������� �ʰ� �ֺ��� ȯ���� �ٲ� �� �ִ�.