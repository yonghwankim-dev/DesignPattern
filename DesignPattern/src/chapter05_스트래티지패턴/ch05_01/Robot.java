package chapter05_스트래티지패턴.ch05_01;

public abstract class Robot {
	private String name;

	public Robot(String name) 
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public abstract void attack();
	public abstract void move();
}
