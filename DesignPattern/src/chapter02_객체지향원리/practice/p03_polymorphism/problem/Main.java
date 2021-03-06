package chapter02_객체지향원리.practice.p03_polymorphism.problem;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal[] animals = {new Cat(), new Dog(), new Lion(), new Snake()};
//		((Cat)animals[0]).printName();
//		((Cat)animals[1]).printName();	// 잘못된 호출 : 형변환
//		((Snake)animals[2]).printName();// 잘못된 호출 : 형변환
//		animals[2].ride();				// 잘못된 호출
//		animals[3].printName();
		
		/**
		 * ((Cat)animals[1]).printName();
		 * ((Snake)animals[2]).printName();
		 * 형제 상속 관계에서 형제 클래스 사이에 형변환을 할 수 없는데도 불구하고 강제로 형변환을
		 * 하여 에러가 발생한다.
		 * 첫번째 구문에서 Dog 객체를 Cat객체로 강제 형변환했기 때문에 에러가 발생한다.
		 * 두번째 구문에서 Lion 객체를 Snake 객체로 강제 형변환했기 대문에 에러가 발생한다.
		 * 
		 * animals[2].ride();
		 * 상속 관계에 있을때 부모 클래스의 참조 변수가 접근할 수 있는 것은 부모 클래스가 물려준 변수와
		 * 메소드뿐이다. 이경우 animal[2]로 참조 할 수 있는것은 printName 메서드 뿐이지만
		 * 코드에서는 ride 메서드를 호출해서 사용하므로 에러가 발생한다.
		 * ride 메서드를 사용하려면 Lion 객체로 형변환을 해야 한다.
		 */
		
		// 개선안
		((Cat)animals[0]).printName();
		((Dog)animals[1]).printName();
		((Lion)animals[2]).printName();
		((Lion)animals[2]).ride();				
		animals[3].printName();
	}

}
