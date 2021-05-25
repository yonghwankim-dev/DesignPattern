package chapter05_스트래티지패턴.exercise.p03_1_code;

public class OrdinaryPricePolicy implements PricePolicy{

	@Override
	public int calcPrice(int price, int n) {
		// TODO Auto-generated method stub
		return price*n;
	}

}
