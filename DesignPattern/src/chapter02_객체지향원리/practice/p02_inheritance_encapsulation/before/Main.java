package chapter02_객체지향원리.practice.p02_inheritance_encapsulation.before;


/**
 * title : 일반화(상속)을 통한 기능의 재사용
 * 
 * 1. 프로그래머의 의도는 ArrayList 클래스에 정의된 isEmpty, size, add, remove
 * 메서드를 자신이 구현하지 않고 그대로 사용하길 원함
 * 
 * 2. 하지만 ArrayList 클래스에 정의된 스택과 관련없는 불필요한 연산까지 같이 상속받는 문제점
 * 이 발생한다.
 * 
 * 3. 이는 아래와 같이 push나 pop 메서드를 통하지 않고 스택의 자료구조에 직접 접근이 가능해진다.
 * 이는 스택의 무결성 조건인 LIFO에 위배된다.
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStack<String> st = new MyStack<String>();
		
		st.push("insang1");
		st.push("insang2");
		st.set(0, "insang3");	// 허용되어서는 안됨 (LFIO 위배)
		
		/**
		 * st 스택 상황
		 * [insang1,insang2] -> [insang3, insang2]
		 * 
		 * output
		 * insang2
		 * insang3
		 */
		System.out.println(st.pop());
		System.out.println(st.pop());
		
	}

}
