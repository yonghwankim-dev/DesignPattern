package chapter02_객체지향원리.practice.p03_polymorphism.before;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog d = new Dog();
		Cat c = new Cat();
		Parrot p = new Parrot();
		
		d.bark();
		c.meow();
		p.sing();
	}

}

// 다형성을 사용하지 않는 경우 클래스별로 다르게 처리해주어야 하는 문제가 존재한다.