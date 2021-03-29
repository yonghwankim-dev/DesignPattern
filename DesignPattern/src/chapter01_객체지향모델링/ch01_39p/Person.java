package chapter01_객체지향모델링.ch01_39p;

public class Person {
	private Car owns;
	
	public Car getOwns() {
		return owns;
	}
	public void setOwns(Car owns) {
		this.owns = owns;
	}
	
}
class Car
{
	//private Person person;	// 단방향 연관 관계이므로 필요 없다.
}