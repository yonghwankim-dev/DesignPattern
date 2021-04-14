package chapter06_ΩÃ±€≈œ∆–≈œ.ch06_10;

public class FakeServer implements Server{
	private StringBuffer result = new StringBuffer();

	@Override
	public void doSomeThing() {
		// TODO Auto-generated method stub
		result.append("invoked");
	}
	
	public String getResult()
	{
		return result.toString();
	}
	
	
}
