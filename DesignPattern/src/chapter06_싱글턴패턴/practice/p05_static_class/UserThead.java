package chapter06_�̱�������.practice.p05_static_class;

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
