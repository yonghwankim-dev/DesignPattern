package chapter03_SOLID??Ģ.practice.p04_DIP_DependencyInversionPrinciple.after;

public class Kid {
	private Toy toy;
	
	public void setToy(Toy toy)
	{
		this.toy = toy;
	}
	
	public void play()
	{
		System.out.println(toy.toString());
	}
}
