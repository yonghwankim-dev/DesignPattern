package chapter06_?̱???????.practice.p05_static_class;

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
