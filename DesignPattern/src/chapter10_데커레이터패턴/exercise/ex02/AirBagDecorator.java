package chapter10_데커레이터패턴.exercise.ex02;

public class AirBagDecorator extends CarOptionDecorator{
	private int airBagPrice;
	
	public AirBagDecorator(CarComponent decoratedCar, int airBagPrice) {
		super(decoratedCar);
		this.airBagPrice = airBagPrice;
	}

	@Override
	public int getPrice() {
		return super.getPrice() + getAirBagPrice();
	}

	@Override
	public String getCarinfo() {
		return super.getCarinfo() + "with Air Bag ";
	}

	private int getAirBagPrice()
	{
		return airBagPrice;
	}
	
}
