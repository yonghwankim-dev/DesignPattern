package chapter06_�̱�������.exercise.ex04_code;

import java.util.Random;

public class Printer {
	private boolean available = true;
	
	public boolean isAvailable()
	{
		return available;
	}
	
	public void print(String name)
	{
		try {
			Thread.sleep(new Random().nextInt(1000));
			System.out.println(name + " is using" + this.toString());
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		setAvailable(true);
	}
	
	public void setAvailable(boolean available)
	{
		this.available = available;
	}
}
