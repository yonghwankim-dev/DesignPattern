package chapter03_SOLID��Ģ.practice.p04_DIP_DependencyInversionPrinciple.before;

public class Kid {
	private Robot toy;
	
	public void setToy(Robot toy)
	{
		this.toy = toy;
	}
	
	public void play()
	{
		System.out.println(toy.toString());
	}
}
