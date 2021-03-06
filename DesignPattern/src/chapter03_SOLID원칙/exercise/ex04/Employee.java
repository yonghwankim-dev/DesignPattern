package chapter03_SOLID원칙.exercise.ex04;

// Question
// 1. 다음 종업원 클래스는 정상 작업 시간(workHours 속성)과 잔업시간(overTimeHours 속성)을
// 기반으로 임금을 계산하기 기능(calculatePay 메서드)을 제공한다.
// 2. 현재의 설계는 임금을 계산하는 다양한 로직 중 하나를 사용해 구현했다.

public class Employee {
	private String id;			// 아이디
	private String name;		// 이름
	private int workHours;		// 정상 작업시간
	private int overTimeHours;	// 잔업시간
	
	// 임금계산
	public void calculatePay()
	{
		// 계산 로직
	}
	
}

// 문제점
// 1. 위 클래스는 SRP(Single Responsibility Principle)을 만족하지만 OCP(Open Closed Principle)을 만족하지 않는다.
// 2. 이유는 임금 게산 로직이 추가도리 경우 calculatePay() 메서드가 변경되기 때문이다.
