package chapter02_객체지향원리.practice.p01_encapsulation.before;

// 캡슐화를 위한 ArrayStack 예제
public class ArrayStack {
	// 문제점은 접근 제어자가 public으로 선언되어 있어 외부에서 필드를 참조가 가능하다.
	public int top;
	public int[] itemArray;
	public int stackSize;
	
	// 생성자
	public ArrayStack(int stackSize)
	{
		itemArray = new int[stackSize];
		this.stackSize = stackSize;
	}
	
	// 스택이 비어있는지 확인
	public boolean isEmpty()
	{
		return (top==-1);
	}
	
	// 스택이 가득차있는지 확인
	public boolean isFull()
	{
		return (top==this.stackSize-1);
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
			itemArray[++top] = item;
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
			return itemArray[top--];
		}
	}
	
	// 스택 top의 item 반환
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
