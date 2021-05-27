package chapter06_�̱�������.practice.p01_before;

public class Printer {
	private static Printer printer = null;
	private Printer()
	{
		
	}
	
	public static Printer getPrinter()
	{
		if(printer==null)
		{
			printer = new Printer();	// Printer �ν��Ͻ� ����	
		}
		return printer;
	}
	
	public void print(String str)
	{
		System.out.println(str);
	}
}
