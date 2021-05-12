package chapter01_객체지향모델링.practice.p05;

public class Main {

	public static void main(String[] args) {
		
		// student 객체 생성
		Student s = new Student("홍길동");
		
		// Course 객체 생성
		Course java = new Course("java");
		Course ds = new Course("Data Struct");
		Course network = new Course("network");
		
		s.registerCourse(java);
		s.registerCourse(ds);
		s.registerCourse(network);

		System.out.println(s);
		
		// 학생 객체는 수업을 취소한다.
		s.dropCourse(java);
		
		System.out.println(s);
	}

}
