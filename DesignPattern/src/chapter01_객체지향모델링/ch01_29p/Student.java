package chapter01_객체지향모델링.ch01_29p;

/**
 * Student 클래스와 Course 클래스의 연관 관계가 양방향 연관 관계이기
 * 때문에 양쪽 클래스에서 서로를 참조 할 수 있는 속성을 정의했다.
 * 또한 다중성이 다대다이므로 참조 속성은 Vector를 이용했다.
 */

import java.util.Vector;

public class Student {
	private String name;
	private Vector<Course> cources;
	
	public Student(String name) {
		this.name = name;
		cources = new Vector<Course>();
	}

	public void registerCourse(Course cource)
	{
		cources.add(cource);
		cource.addStudent(this);
	}
	
	public void dropCourse(Course cource)
	{
		if(cources.contains(cource))
		{
			cources.remove(cource);
			cource.dropStudent(this);
		}
	}
	
	public Vector<Course> getCources()
	{
		return cources;
	}
	
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
}
