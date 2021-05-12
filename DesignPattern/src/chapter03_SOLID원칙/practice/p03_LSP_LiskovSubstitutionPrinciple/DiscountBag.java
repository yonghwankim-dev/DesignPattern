package chapter03_SOLID¿øÄ¢.practice.p03_LSP_LiskovSubstitutionPrinciple;

public class DiscountBag extends Bag{
	private double discountedBag = 0;

	public void setDiscountedBag(double discountedBag) {
		this.discountedBag = discountedBag;
	}
	
	public void applyDiscount(int price){
		super.setPrice(price - (int)(discountedBag*price));
	}
}
