package chapter06_�̱�������.ch06_06;

public class Printer {
	private static int counter = 0;
	
	private Printer()
	{
		
	}
	
	public synchronized static void print(String str)
	{
			counter++;
			System.out.println(str+counter);
	}
}
