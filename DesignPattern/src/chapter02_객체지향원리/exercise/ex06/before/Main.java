package chapter02_객체지향원리.exercise.ex06.before;

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
// 문제점
// 1. 이 코드의 문제점은 Queue<String> 클래스는 LinkedList를 상속받음으로써
// 원하지 않는 속성과 연산을 함께 사용할 수 있다는 점이다.
// 2. A is kind of B의 관계 또한 성립되지 않는다.
// Queue가 LinkedList의 한 종류가 될 수 없기 때문이다.