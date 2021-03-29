package chapter02_객체지향원리.ch02_85p;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a1 = new A1();
		A1 a2 = new A1();
		
		a1.doIt();
		a1.doThat();
		
		a2.doIt();
		/**
		 * 	output
		 * 	DoIt: A class method
			DoThat: A1 class method
			A1 class method
			
			결과를 분석하면 정적 메서드는 상속을 통해 오버라이드 되지 않음을 알 수 있다.
			이는 정적 메소드를 실행할때 동적 바인딩을 실행하는 것이 아니고 컴파일할때
			결정된 객체의 타입에 따라 실행될 메서드가 결정된다는 의미이다.
		 */
		
	}

}
