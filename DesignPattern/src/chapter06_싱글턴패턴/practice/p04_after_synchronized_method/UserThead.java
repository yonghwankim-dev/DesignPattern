package chapter06_ΩÃ±€≈œ∆–≈œ.practice.p04_after_synchronized_method;

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
