package chapter05_스트래티지패턴.ch05_01;

public class TaekwonV extends Robot{
	public TaekwonV(String name) 
	{
		super(name);
	}
	
	@Override
	public void attack()
	{
		System.out.println("I have Missile and can attack with it.");
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("I can only walk");
	}
	
	
}
