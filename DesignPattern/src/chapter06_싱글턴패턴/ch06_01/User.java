package chapter06_ΩÃ±€≈œ∆–≈œ.ch06_01;

public class User {
	private String name;
	
	public User(String name)
	{
		this.name = name;
	}
	
	public void print()
	{
		Printer printer = Printer.getPrinter();
		printer.print(this.name + " print user " + printer.toString() + ".");
	}
}
