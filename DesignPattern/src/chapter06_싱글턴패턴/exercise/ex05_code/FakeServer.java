package chapter06_ΩÃ±€≈œ∆–≈œ.exercise.ex05_code;

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
