package chapter06_싱글턴패턴.ch06_01;

public class Printer {
	private static Printer printer = null;
	private Printer()
	{
		
	}
	
	public static Printer getPrinter()
	{
		if(printer==null)
		{
			printer = new Printer();	// Printer 인스턴스 생성	
		}
		return printer;
	}
	
	public void print(String str)
	{
		System.out.println(str);
	}
}
