package chapter14_컴퍼지트패턴.practice.p01_computer;

public class Monitor {
	private int price;
	private int power;
	
	public Monitor(int price, int power) {
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
