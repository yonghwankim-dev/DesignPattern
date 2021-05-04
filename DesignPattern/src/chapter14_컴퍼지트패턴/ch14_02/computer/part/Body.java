package chapter14_컴퍼지트패턴.ch14_02.computer.part;

public class Body {
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
