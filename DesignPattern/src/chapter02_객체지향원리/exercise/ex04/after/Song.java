package chapter02_��ü�������.exercise.ex04.after;

import chapter02_��ü�������.exercise.ex04.after.saleMode.DiscountMode;

public class Song {
	private DiscountMode mode;
	
	public void setMode(DiscountMode mode)
	{
		this.mode = mode;
	}
	
	public double getPrice()
	{
		return 10.0-(10.0*this.mode.getDisCountRate());
	}
	
}
