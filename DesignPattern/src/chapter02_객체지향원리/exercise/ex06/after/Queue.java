package chapter02_객체지향원리.exercise.ex06.after;

import java.util.LinkedList;

public class Queue<String>{
	
	// LinkedList를 상속받지 않고 필요한 연산과 속성을 위임받기 위해 필드로 선언
	private LinkedList<String> q = new LinkedList<String>();
	
	// Queue에 element 추가
	public boolean addQueue(String element)
	{
		return q.offer(element);
	}
	
	// Queue에 element 제거
	public String removeQueue()
	{
		return q.poll();
	}
	
	// Queue에 element 반환
	public String peekQueue()
	{
		return q.peek();
	}
}
