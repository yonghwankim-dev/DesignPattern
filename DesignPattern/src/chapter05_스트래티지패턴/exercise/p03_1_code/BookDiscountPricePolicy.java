package chapter05_��Ʈ��Ƽ������.exercise.p03_1_code;

public class BookDiscountPricePolicy implements PricePolicy{

	@Override
	public int calcPrice(int price, int n) {	// å ��ü ���� ���� ��å
		// TODO Auto-generated method stub
		return (int)(price*n*0.95);
	}

}
