package chapter02_객체지향원리.practice.p04_petercord_inheritance_rules;

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

// 피터코드의 상속 규칙 5가지
// 상속의 오용을 막기 위해 상속의 사용을 엄격하게 제한하는 규칙
// 5가지 규칙중 어느 하나라도 만족하지 않는다면 상속을 사용해서는 안된다.
// 1. 자식 클래스와 부모 클래스 사이는 '역할 수행(is role played by') 관계가 아니어야 한다.
// 2. 한 클래스의 인스턴스는 다른 서브 클래스의 객체로 변환할 필요가 절대 없어야 한다.
// 3. 자식 클래스가 부모 클래스의 책임을 무시하거나 재정의하지 않고 확장만 수행해야 한다.
// 4. 자식 클래스가 단지 일부 기능을 재사용할 목적으로 유틸리티 역할을 수행하는 클래스를 상속하지 않아야 한다.
// 5. 자식 클래스가 '역할(role)', '트랜잭션(transaction)', '디바이스(device)' 등을 특수화(specialization)해야 한다.
