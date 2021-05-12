package chapter02_객체지향원리.exercise.ex04.before;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Song s1 = new Song();
		s1.setMode("NonDiscounted");
		
		Song s2 = new Song();
		s2.setMode("NonDiscounted");
		
		Song s3 = new Song();
		s3.setMode("OnSale");
		
		Song s4 = new Song();
		s4.setMode("TodayEvent");
		
		CartForSongs c = new CartForSongs();
		
		c.add(s1);
		c.add(s2);
		c.add(s3);
		c.add(s4);
		
		System.out.println(c.calculateTotalPrice());
	}

}

// 현재 문제점
// 1. 현재 프로그램 구조는 새로운 요구사항(새로운 할인 방법)이 있을때마다 매번 수정되어야 한다.
// 개선 방법
// 1. 일반화 관계를 통해 할인율 모드를 외부에 은닉(캡슐화)할 필요가 있다.
// 2. 다형성과 동적 바인딩을 통해 적합한 할인율이 적용되도록 해야 한다.