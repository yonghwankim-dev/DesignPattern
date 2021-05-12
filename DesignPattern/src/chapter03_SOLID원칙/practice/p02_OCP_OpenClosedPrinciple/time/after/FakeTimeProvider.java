package chapter03_SOLID��Ģ.practice.p02_OCP_OpenClosedPrinciple.time.after;

import java.util.Calendar;

// ��¥ �ð� ��ü�� ���� Ŭ����
public class FakeTimeProvider implements TimeProvider{
	private Calendar cal;
	
	public FakeTimeProvider() 
	{
		cal = Calendar.getInstance();
	}
	
	public FakeTimeProvider(int hours) 
	{
		cal = Calendar.getInstance();
		setHours(hours);
	}
	
	// �־��� �ð����� �ð� ����
	@Override
	public void setHours(int hours) 
	{
		cal.set(Calendar.HOUR_OF_DAY,hours);
	}

	// ���� �ð����� ��ȯ
	@Override
	public int getTime() 
	{
		return cal.get(Calendar.HOUR_OF_DAY);
	}

}
