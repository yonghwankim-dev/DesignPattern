package chapter10_��Ŀ����������.exercise.ex02;

public class NaviDecorator extends CarOptionDecorator{
	private int naviPrice;

	public NaviDecorator(CarComponent decoratedCar, int naviPrice) {
		super(decoratedCar);
		this.naviPrice = naviPrice;
	}

	@Override
	public int getPrice() {
		return super.getPrice() + getNaviPrice();
	}

	@Override
	public String getCarinfo() {
		return super.getCarinfo() + "with Navigation ";
	}

	private int getNaviPrice()
	{
		return naviPrice;
	}
	
}
