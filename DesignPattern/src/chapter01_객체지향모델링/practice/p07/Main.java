package chapter01_객체지향모델링.practice.p07;

import java.util.Vector;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s1 = new Student("manSup");
		Student s2 = new Student("gilDong");
		Course se = new Course("Software Engineering");
		Course designPattern = new Course("Design Pattern");
		
		Transcript t1 = new Transcript(s1, se);	// manSup은 소프트웨어 공학 수강
		Transcript t2 = new Transcript(s1, designPattern); // manSup은 디자인 패턴 수강
		Transcript t3 = new Transcript(s2, designPattern); // gilDong은 디자인 패턴 수강
		
		// manSup은 2012년에 소프트웨어 공학에서 B0, 디자인 패턴에서 D+ 학점 취득
		t1.setDate("2012");
		t1.setGrade("B0");
		t2.setDate("2012");
		t2.setGrade("D+");
		
		// gilDong은 2013년에 디자인 패턴에서 C+ 학점 취득
		t3.setDate("2013");
		t3.setGrade("C+");
		
		Vector<Course> courses;
		courses = s1.getCourses();
		System.out.printf("%s 학생이 수강한 과목 \n", s1.getName());
		for(int i=0;i<courses.size();i++)
		{
			System.out.println(courses.get(i).getName());
		}
		System.out.println();
		
		Vector<Student> students;
		students = se.getStudents();
		System.out.printf("%s 과목에 수강된 학생 \n", se.getName());
		for(int i=0;i<students.size();i++)
		{
			System.out.println(students.get(i).getName());
		}
		
	}

}
