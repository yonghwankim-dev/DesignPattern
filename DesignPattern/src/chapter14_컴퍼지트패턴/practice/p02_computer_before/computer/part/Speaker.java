package chapter14_컴퍼지트패턴.practice.p02_computer_before.computer.part;

public class Speaker {
	private int price;
	private int power;
	
	public Speaker(int price, int power) {
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
