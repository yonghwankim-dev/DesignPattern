package chapter10_데커레이터패턴.exercise.ex02;

public class SCCDecorator extends CarOptionDecorator{
	private int SCCPrice;

	public SCCDecorator(CarComponent decoratedCar, int sCCPrice) {
		super(decoratedCar);
		SCCPrice = sCCPrice;
	}

	@Override
	public int getPrice() {
		return super.getPrice() + getSCCPrice();
	}

	@Override
	public String getCarinfo() {
		return super.getCarinfo() + "with SCC ";
	}

	private int getSCCPrice()
	{
		return SCCPrice;
	}
	
}
