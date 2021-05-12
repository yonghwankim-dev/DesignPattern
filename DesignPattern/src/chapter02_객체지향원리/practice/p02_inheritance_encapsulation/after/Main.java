package chapter02_객체지향원리.practice.p02_inheritance_encapsulation.after;

public class Main {

	public static void main(String[] args) {
		MyStack<String> myStack = new MyStack<String>();
		
		myStack.push("A");
		myStack.push("B");
		myStack.push("C");
		myStack.push("D");
		myStack.push("E");
		
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
	}

}

// 일반화 관계(상속)과 달리 필요한 연산과 속성만을 위임받아 사용할 수 있게 되었다.
// 기능을 재사용할 때는 상속보다 위임을 이용하라.