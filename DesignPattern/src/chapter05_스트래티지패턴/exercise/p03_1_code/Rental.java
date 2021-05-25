package chapter05_스트래티지패턴.exercise.p03_1_code;



public class Rental {
	private Member member;
	private Book book;
	private PricePolicy pricePolicy;	// 가격 정책 참조
	int n;
	
	public Rental(Member member, Book book, PricePolicy pricePolicy, int n) {
		this.member = member;
		this.book = book;
		this.pricePolicy = pricePolicy;
		this.n = n;
		this.member.addAccPrice(pricePolicy.calcPrice(book.getPrice(), n));
	}
	
	public int getPrice()
	{
		return pricePolicy.calcPrice(book.getPrice(), n);	// 가격 정책에 따른 책 가격을 계산함
	}
	
	
}
