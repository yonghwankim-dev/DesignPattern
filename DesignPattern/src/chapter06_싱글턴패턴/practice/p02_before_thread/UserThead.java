package chapter06_?̱???????.practice.p02_before_thread;

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
