package chapter05_��Ʈ��Ƽ������.practice.p01_before;

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
