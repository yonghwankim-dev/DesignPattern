package chapter01_°´Ã¼ÁöÇâ¸ğµ¨¸µ.practice.p06;

import java.util.Vector;

public class Course
{
	private String name;
	private Vector<Student> students;
	
	public Course(String name)
	{
		this.name = name;
		students = new Vector<Student>();
	}
	
	public void addStudent(Student student)
	{
		students.add(student);
	}
	
	public void dropStudent(Student student)
	{
		students.remove(student);
	}
		
	public Vector<Student> getStudents() {
		return students;
	}

	public String getName()
	{
		return this.name;
	}
}
