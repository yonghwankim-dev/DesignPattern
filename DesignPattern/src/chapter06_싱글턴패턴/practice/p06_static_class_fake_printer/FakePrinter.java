package chapter06_싱글턴패턴.practice.p06_static_class_fake_printer;

public class FakePrinter implements Printer { // 테스트용 가짜 데이터
	private String str;

	@Override
	public void print(String str) 
	{
		this.str = str;
	}
	
	public String get() 
	{
		return str; 
	}
	
	
}
