package chapter05_스트래티지패턴.exercise.p03_1_code;

/**
 * 스트래티지 패턴을 사용해 다음 요구사항을 만족하는 코드를 작성하라.
	- 회원은 이름과 누적 대여 금액을 갖는다.
	- 책은 서명, 출파년도, 가격을 갖는다.(재고는 무한대라고 가정)
	- 회원은 하나의 책을 1권 이상 살 수 있다.
	- 가격 정책에 따라 책 값이 할인되며 다른 가격 정책이 추가될 수 있다.
	- 10년 이상된 책은 책 자체 할인, 누적 대여 금액이 만원 이상이면 회원 할인, 그 외의 경우에는 할인이 되지 않는다.

 * @author qkdlf
 *
 */
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Member member1 = new Member("member1");
		Member member2 = new Member("member2");
		
		Book book1 = new Book("book1", 2005, 1000);
		Book book2 = new Book("book2", 2004, 1200);
		Book book3 = new Book("book3", 2001, 4300);
		
		Rental rental1 = new Rental(member1, book2, new OrdinaryPricePolicy(),2);
		Rental rental2 = new Rental(member2, book1, new OrdinaryPricePolicy(), 3);
		Rental rental3 = new Rental(member2, book3, new BookDiscountPricePolicy(),4);
		Rental rental4 = new Rental(member1, book2, new MemberDiscountPricePolicy(),3);
		
		System.out.println(rental1.getPrice());
		System.out.println(rental2.getPrice());
		System.out.println(rental3.getPrice());
		System.out.println(rental4.getPrice());
	}

}
