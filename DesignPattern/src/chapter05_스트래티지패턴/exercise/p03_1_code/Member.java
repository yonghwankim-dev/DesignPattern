package chapter05_��Ʈ��Ƽ������.exercise.p03_1_code;

public class Member {
	// ȸ���� �̸��� ���� �뿩 �ݾ��� ����
	private String name;	// �̸�
	private int accPrice;	// ���� �뿩 �ݾ�
	
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
