package chapter02_��ü�������.exercise.ex06.after;

import java.util.LinkedList;

public class Queue<String>{
	
	// LinkedList�� ��ӹ��� �ʰ� �ʿ��� ����� �Ӽ��� ���ӹޱ� ���� �ʵ�� ����
	private LinkedList<String> q = new LinkedList<String>();
	
	// Queue�� element �߰�
	public boolean addQueue(String element)
	{
		return q.offer(element);
	}
	
	// Queue�� element ����
	public String removeQueue()
	{
		return q.poll();
	}
	
	// Queue�� element ��ȯ
	public String peekQueue()
	{
		return q.peek();
	}
}
