package chapter02_객체지향원리.practice.p03_polymorphism.after;

public class Main {

	public static void main(String[] args) {
		Pet[] pets = {new Cat(), new Dog(), new Parrot()};
		
		for(Pet p : pets)
		{
			p.talk();
		}
	}

}

// 다형성을 사용하는 경우에는 구체적으로 현재 어떤 클래스 객체가 참조되는지와 무관하게 프로그래밍을 할 수 있다. 
// 따라서 새로운 애완동물을 나타내는 클래스가 자식 클래스로 추가되더라도 코드는 영향을 받지 안흔다.
// 위와 같이 가능한 이유는 일반화 관계에 있을때 부모 클래스의 참조 변수가 자식 클래스의 객체를 참조할 수 있기 때문이다.
