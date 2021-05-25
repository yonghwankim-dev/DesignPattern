package chapter05_스트래티지패턴.exercise.p03_1_code;

public class BookDiscountPricePolicy implements PricePolicy{

	@Override
	public int calcPrice(int price, int n) {	// 책 자체 가격 할인 정책
		// TODO Auto-generated method stub
		return (int)(price*n*0.95);
	}

}
