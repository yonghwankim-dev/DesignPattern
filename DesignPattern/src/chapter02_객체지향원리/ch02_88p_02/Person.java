package chapter02_��ü�������.ch02_88p_02;

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
