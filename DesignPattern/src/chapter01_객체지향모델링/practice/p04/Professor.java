package chapter01_객체지향모델링.practice.p04;

public class Professor {
	private Student student;
	
	public void setStudent(Student student)
	{
		this.student = student;
	}
	
	public void advise() 
	{
		student.advise("상담 내뇽은 여기에...");
	}
}
