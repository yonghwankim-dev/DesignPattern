package chapter01_°´Ã¼ÁöÇâ¸ðµ¨¸µ.practice.p05;

public class Course {
	private String name;
	
	public Course(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Course [name=" + name + "]";
	}
	
}
