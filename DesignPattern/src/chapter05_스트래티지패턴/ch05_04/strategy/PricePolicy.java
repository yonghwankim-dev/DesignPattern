package chapter05_스트래티지패턴.ch05_04.strategy;

public interface PricePolicy {
	public int calcPrice(int price, int n);
}
