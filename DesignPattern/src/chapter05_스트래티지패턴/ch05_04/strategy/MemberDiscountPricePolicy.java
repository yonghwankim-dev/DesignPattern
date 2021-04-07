package chapter05_스트래티지패턴.ch05_04.strategy;

public class MemberDiscountPricePolicy implements PricePolicy{

	@Override
	public int calcPrice(int price, int n) {	// 회원 가격 할인 정책
		// TODO Auto-generated method stub
		return (int)(price*n*0.9);
	}

}
