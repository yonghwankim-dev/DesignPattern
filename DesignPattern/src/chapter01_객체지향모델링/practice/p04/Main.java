package chapter01_객체지향모델링.practice.p04;

/**
 * 이 코드의 연관 관게는 양방향 연관 관계이므로 Professor 클래스 객체에서
 * Student 클래스 객체를 참조할 수 있는 속성이 있고 Student 클래스 객체에서
 * Professor 클래스 객체를 참조할 수 있는 속성(advisor)이 있다.
 * 또한 이 속성의 이름이 역할 이름을 활용한 것임을 알 수 있다.
 * @author qkdlf
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Professor hongGilDong = new Professor();
		Student manSup = new Student();
		hongGilDong.setStudent(manSup);
		hongGilDong.advise();
		
	}

}
