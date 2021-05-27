package chapter06_ΩÃ±€≈œ∆–≈œ.exercise.ex04_code;

public class UserThead extends Thread {
	private Printer myPrinter;
	public UserThead(String name)
	{
		super(name);
	}
	
	public void run()
	{
		PrinterManager mgr = PrinterManager.getPrinterManager();
		myPrinter = mgr.getPrinter();
		myPrinter.print(getName());
		
	}
}
