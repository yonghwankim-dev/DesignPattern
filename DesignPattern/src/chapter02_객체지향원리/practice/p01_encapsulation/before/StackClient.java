package chapter02_객체지향원리.practice.p01_encapsulation.before;


// StackClient클래스는 push 메서드나 pop 메서드를 사용하지 않고 직접 배열에 값을 저장할 수 있다.
// 이런 경우 ArrayStack과 StackClient 클래스는 강한 결합이 발생한다.
// ArrayList 클래스를 사용해 스택 구현이 변경되면 StackClient 클래스도 따라서 변경되어야함
// 하지만 StackClient 클래스가 은닉된 정보를 직접 사용하기 때문에 은닉 정보가 변경되면 해당 정보를
// 사용한 쪽도 모두 변경되어야 하는 문제점을 가지고 있다.
public class StackClient {

	public static void main(String[] args) {
		ArrayStack st = new ArrayStack(10);
		st.itemArray[++st.top] = 20;
		System.out.println(st.itemArray[st.top]);
		
	}

}
