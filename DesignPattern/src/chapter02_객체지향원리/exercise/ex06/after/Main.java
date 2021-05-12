package chapter02_객체지향원리.exercise.ex06.after;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<String> q = new Queue<String>();
		q.addQueue("insang1");
		q.addQueue("insang2");
		q.addQueue("insang3");
		System.out.println(q);
	}

}

// 기존 Queue<String>에 LinkedList에 대한 위임을 적용함
// 따라서 LinekdList의 모든 속성과 연산을 사용하지 않고 Clinet는 필요한 기능만 접근할 수 있음
