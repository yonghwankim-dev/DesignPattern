package chapter02_객체지향원리.practice.p02_inheritance_encapsulation.after;

import java.util.ArrayList;


// 3. 서브 클래스에서 일반화된 관계 선언을 제거
public class MyStack<String>{
//public class MyStack<String> extends ArrayList<String>{
	
	// 1. 자식 클래스에 부모 클래스의 인스턴스를 참조하는 속성을 만든다. 이 속성 필드를 this로 초기화한다.
	//private ArrayList<String> arList = this;
	
	// 4. 위임 속성 필드에 슈퍼 클래스의 객체를 생성해 대입
	private ArrayList<String> arList = new ArrayList<>();
	
	// 2. 서브 클래스에 정의된 각 메서드에 1번에서 만든 위임 속성 필드를 참조하도록 변경한다.
	public void push(String element)
	{
		// add(element);
		arList.add(element);
	}
	
	// 2. 서브 클래스에 정의된 각 메서드에 1번에서 만든 위임 속성 필드를 참조하도록 변경한다.
	public String pop()
	{
		// return remove(size()-1);
		return arList.remove(arList.size()-1);
	}
	
	// 5. 서브 클래스에서 사용된 슈퍼 클래스의 메서드에도 위임 메서드를 추가
	public boolean isEmpty()
	{
		return arList.isEmpty();
	}
	
	// 5. 서브 클래스에서 사용된 슈퍼 클래스의 메서드에도 위임 메서드를 추가
	public int size()
	{
		return arList.size();
	}
}
