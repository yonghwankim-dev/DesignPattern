package chapter10_��Ŀ����������.ch10_06;

public class ESCDecorator extends CarOptionDecorator{
	private int ESCPrice;

	public ESCDecorator(CarComponent decoratedCar, int eSCPrice) {
		super(decoratedCar);
		ESCPrice = eSCPrice;
	}

	@Override
	public int getPrice() {
		return super.getPrice() + getEscPrice();
	}

	@Override
	public String getCarinfo() {
		return super.getCarinfo() + "with ESC ";
	}

	private int getEscPrice()
	{
		return ESCPrice;
	}
	
}
