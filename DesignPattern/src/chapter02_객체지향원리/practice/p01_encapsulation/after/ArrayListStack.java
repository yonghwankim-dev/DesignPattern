package chapter02_��ü�������.practice.p01_encapsulation.after;

import java.util.ArrayList;

// ĸ��ȭ�� ������ ArrayListStack Ŭ����
public class ArrayListStack {
	private int stackSize;
	private ArrayList<Integer> items;	// �ڷᱸ���� �迭���� ArrayList�� �����
	
	// ������
	public ArrayListStack(int stackSize)
	{
		items = new ArrayList<Integer>(stackSize);
		this.stackSize = stackSize;
	}
	
	// ������ ����ִ��� Ȯ��
	public boolean isEmpty()
	{
		return items.isEmpty();
	}
	
	// ������ �����ִ��� Ȯ��
	public boolean isFull()
	{
		return (items.size()>=stackSize);
	}
	
	// ���ÿ� item �߰�
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
	
	// ���ÿ� item ����
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
	
	// ���ÿ� item ��ȯ
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
