package chapter02_객체지향원리.practice.p01_encapsulation.after;


public class StackClient {
	public static void main(String[] args)
	{
		ArrayListStack st = new ArrayListStack(10);
		st.push(10);
		System.out.println(st.peek());
	}
	
}

// StackClient는 push, pop, peek 메서드의 연산만으로 스택을 사용 가능하다.
// 하지만 push, pop, peek 메서드 등이 어떤 방식으로 어떤 자료구조를 사용해 작업을
// 실행하는지는 알 수 없다. 즉, 스택과 이를 사용하는 코드의 결합도가 낮아지는 것이다.