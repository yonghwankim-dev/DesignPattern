package chapter14_컴퍼지트패턴.practice.p01_computer;

public class Keyboard {
	private int price;
	private int power;
	
	public Keyboard(int price, int power) {
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
