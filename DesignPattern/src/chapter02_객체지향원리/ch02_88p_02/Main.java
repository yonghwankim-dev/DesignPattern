package chapter02_객체지향원리.ch02_88p_02;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p = new Person();
		p.setRole(new Driver());	// 운전자로 역할 변경
		p.doIt();					// 운전자 역할 수행
		p.setRole(new Worker());	// 종업원을 역할 변경
		p.doIt();					// 종업원 역할 수행
		
		
	}

}
