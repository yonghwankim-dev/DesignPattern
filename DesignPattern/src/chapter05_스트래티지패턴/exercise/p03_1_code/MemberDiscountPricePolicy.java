package chapter05_��Ʈ��Ƽ������.exercise.p03_1_code;

public class MemberDiscountPricePolicy implements PricePolicy{

	@Override
	public int calcPrice(int price, int n) {	// ȸ�� ���� ���� ��å
		// TODO Auto-generated method stub
		return (int)(price*n*0.9);
	}

}
