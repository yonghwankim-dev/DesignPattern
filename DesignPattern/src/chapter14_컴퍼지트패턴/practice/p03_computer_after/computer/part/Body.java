package chapter14_컴퍼지트패턴.practice.p03_computer_after.computer.part;

public class Body extends ComputerDevice {
	private int price;
	private int power;
	
	public Body(int price, int power) {
		this.price = price;
		this.power = power;
	}

	public int getPrice() {
		return price;
	}

	public int getPower() {
		return power;
	}
	
}
