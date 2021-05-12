package chapter01_객체지향모델링.practice.p09;

// 의존 관계
public class Person {
	private Car owns;
	
	public Car getOwns() {
		return owns;
	}
	public void setOwns(Car owns) {
		this.owns = owns;
	}
	
}
