package chapter05_��Ʈ��Ƽ������.exercise.p06_1_code;

public class FakePrinter implements ReceiptPrinter{
	private String s;
	@Override
	public void print(String s) {
		// TODO Auto-generated method stub
		this.s = s;
	}
	
	public String getReceiptContents() 
	{
		return s;
	}

}
