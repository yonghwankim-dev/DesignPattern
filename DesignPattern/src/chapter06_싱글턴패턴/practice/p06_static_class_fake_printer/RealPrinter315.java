package chapter06_싱글턴패턴.practice.p06_static_class_fake_printer;

public class RealPrinter315 implements Printer{	// 싱글턴 패턴을 사용
	private static Printer printer = null;
	private RealPrinter315() 
	{
		
	}
	
	public synchronized static Printer getPrinter() 
	{
		if(printer==null)
		{
			printer = new RealPrinter315();
		}
		return printer;
	}

	@Override
	public void print(String str) {
		// 실제 프린터 하드웨어드를 조작하는 코드
	}
}

