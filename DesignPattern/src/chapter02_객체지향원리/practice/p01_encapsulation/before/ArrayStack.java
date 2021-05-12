package chapter02_��ü�������.practice.p01_encapsulation.before;

// ĸ��ȭ�� ���� ArrayStack ����
public class ArrayStack {
	// �������� ���� �����ڰ� public���� ����Ǿ� �־� �ܺο��� �ʵ带 ������ �����ϴ�.
	public int top;
	public int[] itemArray;
	public int stackSize;
	
	// ������
	public ArrayStack(int stackSize)
	{
		itemArray = new int[stackSize];
		this.stackSize = stackSize;
	}
	
	// ������ ����ִ��� Ȯ��
	public boolean isEmpty()
	{
		return (top==-1);
	}
	
	// ������ �������ִ��� Ȯ��
	public boolean isFull()
	{
		return (top==this.stackSize-1);
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
			itemArray[++top] = item;
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
			return itemArray[top--];
		}
	}
	
	// ���� top�� item ��ȯ
	public int peek()
	{
		if(isEmpty())
		{
			System.out.println("Peeking fail! Array Stack is empty");
			return -1;
		}
		else
		{
			return itemArray[top];
		}
	}
}
