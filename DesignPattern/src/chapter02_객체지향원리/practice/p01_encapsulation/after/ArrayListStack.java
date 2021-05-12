package chapter02_객체지향원리.practice.p01_encapsulation.after;

import java.util.ArrayList;

// 캡슐화를 적용한 ArrayListStack 클래스
public class ArrayListStack {
	private int stackSize;
	private ArrayList<Integer> items;	// 자료구조가 배열에서 ArrayList로 변경됨
	
	// 생성자
	public ArrayListStack(int stackSize)
	{
		items = new ArrayList<Integer>(stackSize);
		this.stackSize = stackSize;
	}
	
	// 스택이 비어있는지 확인
	public boolean isEmpty()
	{
		return items.isEmpty();
	}
	
	// 스택이 꽉차있는지 확인
	public boolean isFull()
	{
		return (items.size()>=stackSize);
	}
	
	// 스택에 item 추가
	public void push(int item)
	{
		if(isFull())
		{
			System.out.println("Inserting fail");
		}
		else
		{
			items.add(item);
			System.out.println("Inserted Item : " + item);
		}
	}
	
	// 스택에 item 제거
	public int pop()
	{
		if(isEmpty())
		{
			System.out.println("Deleting fail");
			return -1;
		}
		else
		{
			return items.remove(items.size()-1);
		}
	}
	
	// 스택에 item 반환
	public int peek()
	{
		if(isEmpty())
		{
			System.out.println("Peeking fail! Array Stack is empty");
			return -1;
		}
		else
		{
			return items.get(items.size()-1);
		}
	}
}
