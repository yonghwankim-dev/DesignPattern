package chapter03_SOLID원칙.practice.p03_LSP_LiskovSubstitutionPrinciple;

public class Main {

	public static void main(String[] args) {
		Bag b1 = new Bag();
		Bag b2 = new Bag();
		
		DiscountBag b3 = new DiscountBag();
		DiscountBag b4 = new DiscountBag();
		
		b1.setPrice(50000);
		System.out.println(b1.getPrice());
		
		b2.setPrice(b1.getPrice());
		System.out.println(b2.getPrice());
		
		b3.setPrice(50000);
		System.out.println(b3.getPrice());
		
		b4.setPrice(b3.getPrice());
		System.out.println(b4.getPrice());
		
		b3.setDiscountedBag(0.1);
		b3.applyDiscount(50000);
		System.out.println(b3.getPrice());
		
	}

}

// LSP(Liskov Substitution Principle)
// 1. 일반화 관계에 대한 이야기며 자식 클래스는 최소한 자신의 부모 클래스에서 가능한 행위는 수행할 수 있어야 한다.