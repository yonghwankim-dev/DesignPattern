package chapter05_스트래티지패턴.exercise.p03_1_code;

public class Member {
	// 회원은 이름과 누적 대여 금액을 갖음
	private String name;	// 이름
	private int accPrice;	// 누적 대여 금액
	
	public Member(String name) {
		this.name = name;
		this.accPrice = 0;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void addAccPrice(int price)
	{
		accPrice += price;
	}
	
	public int getAccPrice()
	{
		return accPrice;
	}
}
