package chapter02_객체지향원리.practice.p03_polymorphism.problem;

public class Lion extends Animal{

	@Override
	public void printName() {
		System.out.println("사자");
	}
	
	public void ride() {
		System.out.println("사자 타보았니? 타보지 않았으면 말을 하지마!");
	}
	
}
