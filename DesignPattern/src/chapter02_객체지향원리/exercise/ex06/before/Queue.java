package chapter02_객체지향원리.exercise.ex06.before;

import java.util.LinkedList;

public class Queue<String> extends LinkedList<String>{
	
	// Queue에서 element 추가
	public boolean addQueue(String element)
	{
		return this.offer(element);
	}
	
	// Queue에서 element 제거
	public String removeQueue()
	{
		return this.poll();
	}
	
	// Queue에서 element 반환
	public String peekQueue()
	{
		return this.peek();
	}
}


