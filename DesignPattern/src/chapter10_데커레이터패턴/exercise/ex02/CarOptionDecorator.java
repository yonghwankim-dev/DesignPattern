package chapter10_데커레이터패턴.exercise.ex02;

public class CarOptionDecorator extends CarComponent{

	private CarComponent decoratedCar;

	public CarOptionDecorator(CarComponent decoratedCar) {		
		this.decoratedCar = decoratedCar;
	}

	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return decoratedCar.getPrice();
	}

	@Override
	public String getCarinfo() {
		// TODO Auto-generated method stub
		return decoratedCar.getCarinfo();
	}
	
}
