package chapter06_�̱�������.ch06_06;

public class UserThead extends Thread {
	public UserThead(String name)
	{
		super(name);
	}
	
	public void run()
	{
		Printer.print(Thread.currentThread().getName() + " print using " + ".");
		
	}
}
