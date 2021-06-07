package chapter10_데커레이터패턴.exercise.ex02;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CarComponent car = new BasicCar(1000);
	
		for(String decoratorName: args)
		{
			if(decoratorName.equalsIgnoreCase("AirBag"))
			{
				car = new AirBagDecorator(car, 100);
			}
			if(decoratorName.equalsIgnoreCase("ESC"))
			{
				car = new ESCDecorator(car, 50);
			}
			if(decoratorName.equalsIgnoreCase("Navi"))
			{
				car = new NaviDecorator(car, 30);
			}
			if(decoratorName.equalsIgnoreCase("SCC"))
			{
				car = new SCCDecorator(car, 70);
			}
		}
		System.out.println(car.getPrice());
		System.out.println(car.getCarinfo());
	}

}
