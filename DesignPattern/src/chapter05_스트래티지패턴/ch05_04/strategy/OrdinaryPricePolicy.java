package chapter05_스트래티지패턴.ch05_04.strategy;

public class OrdinaryPricePolicy implements PricePolicy{

	@Override
	public int calcPrice(int price, int n) {
		// TODO Auto-generated method stub
		return price*n;
	}

}
