package chapter10_데커레이터패턴.ch10_06;

public class BasicCar extends CarComponent{
	private int price;
	
	public BasicCar(int price) {
		this.price = price;
	}

	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return price;
	}

	@Override
	public String getCarinfo() {
		// TODO Auto-generated method stub
		return "BasicCar ";
	}
	
}
