package chapter02_객체지향원리.exercise.ex04.after;

import chapter02_객체지향원리.exercise.ex04.after.saleMode.NonDiscounted;
import chapter02_객체지향원리.exercise.ex04.after.saleMode.OnSale;
import chapter02_객체지향원리.exercise.ex04.after.saleMode.TodayEvent;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Song s1 = new Song();
		s1.setMode(new NonDiscounted());
		
		Song s2 = new Song();
		s2.setMode(new NonDiscounted());
		
		Song s3 = new Song();
		s3.setMode(new OnSale());
		
		Song s4 = new Song();
		s4.setMode(new TodayEvent());
		
		CartForSongs c = new CartForSongs();
		
		c.add(s1);
		c.add(s2);
		c.add(s3);
		c.add(s4);
		
		System.out.println(c.calculateTotalPrice());
	}

}

// DiscountMode 클래스를 통해 구체적인 할인 모드를 캡슐화를 수행하였음
// 만약 새로운 할인 모드를 추가하려면 해당하는 할인 모드 클래스를 DiscountMode 클래스의 자식 클래스로 섲렁하면 된다.