package chapter01_객체지향모델링.practice.p08;

public abstract class HomeAppliancies {
	private int serialNo;			// 제조번호
	private String manufacturer;	// 제조회사
	private int year;				// 제조년도
	
	public abstract void turnOn();
	public abstract void turnOff();
}
