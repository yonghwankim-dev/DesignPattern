package chapter01_객체지향모델링.practice.p05;

/**
 * 이 코드는 Student 객체 하나에 하나 이상의 Course 객체가 연관되어
 * 있기 때문에 다중성을 구현했으며, Student 클래스에 대표적 컬렉션
 * 자료구조인 Vector를 이용해 여러 개의 Course 클래스 객체를 참조할 수 있게
 * 했다.
 * 컬렉션 자료구조에는 Vector 외에도 Set, Map, ArrayList 등 여러가지가
 * 있으므로 상황에 맞는 적절한 자료구조를 선택해 사용하면 된다.
 * 또한 이 코드는 Student 클래스에서 Course 클로스로 향하는 단방향 연관 관계
 * 이기 때문에 Course 클래스에는 Student 객체를 참조하는 속성이 정의되어 있지 않다.
 */

import java.util.Vector;

public class Student {
	private String name;
	private Vector<Course> cources;
	
	// 생성자
	public Student(String name) {
		this.name = name;
		cources = new Vector<Course>();
	}

	// 수강 등록
	public void registerCourse(Course cource)
	{
		cources.add(cource);
	}
	
	// 수강 취소
	public void dropCourse(Course cource)
	{
		if(cources.contains(cource))
		{
			cources.remove(cource);
		}
	}
	
	public Vector<Course> getCources()
	{
		return cources;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", cources=" + cources + "]";
	}
	
	
}
