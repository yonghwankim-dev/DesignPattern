package chapter04_디자인패턴.ch04_02;

public class A1 {
	public void doA1()
	{
		A2 a2 = new A2();
		a2.doA2(this);
	}

	public void doIt(A3 a3) {
		// TODO Auto-generated method stub
		a3.doIt();
	}
}
