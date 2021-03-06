package chapter06_싱글턴패턴.practice.p04_after_synchronized_method;

public class Printer {
	private static Printer printer = null;
	private int counter = 0;
	
	private Printer()
	{
		
	}
	
	// synchronized 키워드는 다중 스레드 환경에서 여러 스레드가 
	// getPrinter 메서드를 소유하는 객체에 접근하는 것을 방지한다.
	public synchronized static Printer getPrinter()
	{
		if(printer==null)
		{
			printer = new Printer();
		}
		return printer;
	}
	
	public void print(String str)
	{
		synchronized (this) {	// 오직 하나의 스레드만 접근을 허용함
			counter++;
			System.out.println(str+counter);
		}
	}
}
