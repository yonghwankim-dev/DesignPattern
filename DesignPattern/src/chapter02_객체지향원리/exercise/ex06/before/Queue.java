package chapter02_��ü�������.exercise.ex06.before;

import java.util.LinkedList;

public class Queue<String> extends LinkedList<String>{
	
	// Queue���� element �߰�
	public boolean addQueue(String element)
	{
		return this.offer(element);
	}
	
	// Queue���� element ����
	public String removeQueue()
	{
		return this.poll();
	}
	
	// Queue���� element ��ȯ
	public String peekQueue()
	{
		return this.peek();
	}
}


