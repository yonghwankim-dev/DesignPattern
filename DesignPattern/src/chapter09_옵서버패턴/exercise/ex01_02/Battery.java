package chapter09_옵서버패턴.exercise.ex01_02;

public class Battery extends Subject{
	private int level = 100;
	
	public void consume(int amount)
	{
		level -= amount;
		notifyObservers();
	}
	
	public int getLevel() {
		// TODO Auto-generated method stub
		return level;
	}
	
	
	
}
