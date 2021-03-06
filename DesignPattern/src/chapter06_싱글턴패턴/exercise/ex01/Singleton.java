package chapter06_싱글턴패턴.exercise.ex01;

public class Singleton {
	//private Singleton instance = null; static을 붙여야함
	private static Singleton instance = null;
	/*
	 * 문제점 : public이 아닌 private
	public Singleton()	
	{
		
	}
	*/
	private Singleton()
	{
		
	}
	public static Singleton getInstance()
	{
		if(instance==null)
		{
			instance = new Singleton();
		}
		return instance;
	}
	
	public void doSomething()
	{
		//...
	}
}
