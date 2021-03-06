package chapter02_객체지향원리.practice.p02_inheritance_encapsulation.vectorStack;

import java.util.Vector;

// 해당 VectorStack 클래스는 Vector 클래스를 사용하여
// Stack 클래스를 구현한 코드이다.
// Vector 클래스에는 많은 기능이 있지만 그중에서 add, remove, isempty, size와
// 같은 기능만 상속받아 구현하고 싶기 때문에 Vector 클래스에 대해서 위임을 받아 구현한 코드이다.
// 위임을 사용하지 않으면 Vector 클래스의 원치 않은 기능을 상속받아 사용될 수 있는 문제가 있다.

// 위임 생성과정은 p02_inheritance_encapsulation.after.Mystack.java 참조
public class VectorStack{
	
	private Vector<String> v = new Vector<String>();
	
	public void push(String element) 
	{
		v.add(element);
	}
	
	public String pop()
	{
		return v.remove(v.size()-1);
	}
	
	public boolean isEmpty()
	{
		return v.isEmpty();
	}
	
	public int size()
	{
		return v.size();
	}
}
