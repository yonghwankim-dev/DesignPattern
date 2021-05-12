package chapter03_SOLID원칙.practice.p02_OCP_OpenClosedPrinciple.time.after;

import java.util.Calendar;

// 가짜 시간 객체을 위한 클래스
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
	
	// 주어진 시간으로 시간 설정
	@Override
	public void setHours(int hours) 
	{
		cal.set(Calendar.HOUR_OF_DAY,hours);
	}

	// 현재 시간으로 반환
	@Override
	public int getTime() 
	{
		return cal.get(Calendar.HOUR_OF_DAY);
	}

}
