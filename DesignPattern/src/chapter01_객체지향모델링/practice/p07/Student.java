package chapter01_객체지향모델링.practice.p07;

import java.util.Iterator;

/**
 * Student 클래스와 Course 클래스의 연관 관계가 양방향 연관 관계이기
 * 때문에 양쪽 클래스에서 서로를 참조 할 수 있는 속성을 정의했다.
 * 또한 다중성이 다대다이므로 참조 속성은 Vector를 이용했다.
 */

import java.util.Vector;

public class Student {
	private Vector<Transcript> transcripts;
	private String name;

	public Student(String name) {
		this.name = name;
		transcripts = new Vector<Transcript>();
	}

	public void addTranscript(Transcript transcript)
	{
		transcripts.add(transcript);
	}
	
	public Vector<Course> getCourses()
	{
		Vector<Course> courses = new Vector<Course>();
		Iterator<Transcript> itor = transcripts.iterator();
		
		while(itor.hasNext())
		{
			Transcript tr = itor.next();
			courses.add(tr.getCourse());
		}
		return courses;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
