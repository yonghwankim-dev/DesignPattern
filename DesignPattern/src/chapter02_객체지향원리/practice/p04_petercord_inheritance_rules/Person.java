package chapter02_객체지향원리.practice.p04_petercord_inheritance_rules;

public class Person {
	private Role r;
	
	public void setRole(Role r)
	{
		this.r = r;
	}
	
	public Role getRole()
	{
		return r;
	}
	
	public void doIt()
	{
		r.doIt();
	}
}
