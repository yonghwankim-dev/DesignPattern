package chapter06_ΩÃ±€≈œ∆–≈œ.ch06_05;

public class UserThead extends Thread {
	public UserThead(String name)
	{
		super(name);
	}
	
	public void run()
	{
		Printer printer = Printer.getPrinter();
		printer.print(Thread.currentThread().getName() +
						" print using " + printer.toString() + ".");
		
	}
}
