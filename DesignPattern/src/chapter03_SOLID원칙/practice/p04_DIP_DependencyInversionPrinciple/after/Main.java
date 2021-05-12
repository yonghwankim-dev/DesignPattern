package chapter03_SOLID원칙.practice.p04_DIP_DependencyInversionPrinciple.after;

public class Main {

	public static void main(String[] args) {
		// 아이 객체 생성
		Kid kid = new Kid();
		
		// 로봇 장난감 객체 생성, 주입
		Toy robot = new Robot();
		kid.setToy(robot);
		kid.play();
		
		// 레고 장난감 객체 생성, 주입
		Toy lego = new Lego();
		kid.setToy(lego);
		kid.play();
	}

}

// DIP(Dependency Inversion Principle, 의존 역전 원칙)
// 1. DIP는 의존 관계를 맺을 때 변화하기 쉬운 것 도는 자주 변화하는 것보다는 변화하기 어려운 것, 거의 변화가 없는 것에 의존하라는 원칙이다.
// 2. 객체지향 관점에서는 변하기 어려운 추상적인 것들을 표현하는 수단으로 추상 클래스와 인터페이스가 존재한다.
// 3. DIP를 만족하려면 어떤 클래스가 도움을 받을 때 구체적인 클래스보다는 인터페이스나 추상 클래스와 의존 관계를 맺도록 설계해야 한다.
// 4. DIP를 만족하는 설계는 변화에 유연한 시스템이 된다.
// 5. DIP를 만족하면 의존성 주입(Dependency Injection)이라는 기술로 변화를 쉽게 수용할 수 있는 코드를 작성 할 수 있다.

// DI(Dependency Injection, 의존성 주입)
// 1. 클래스 외부에서 의존 되는 것을 대상 객체의 인스턴스 변수에 주입하는 기술이다.
// 2. 의존성 주입을 이용하여 대상 객체를 변경하지 않고도 오비ㅜ에서 대상 객체의 외부 의존 객체를 바꿀 수 있다.
// ex) Toy toy = new Robot();

