package chapter12_팩토리메서드패턴.ch12_07;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car = new Car();
		car.speedUp(150);
		car.speedDown(130);
		
		car.engineFailedDetected();
		
		car.speedUp(100);
		car.speedDown(30);
		
		car.speedUp(50);
		car.speedUp(100);
		
		car.engineRepaired();
		car.speedUp(100);
	}

}
