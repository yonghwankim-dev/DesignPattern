package chapter03_SOLID��Ģ.ch03_115p;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TimeReminder sut = new TimeReminder();
		FakeTimeProvider tProvStub = new FakeTimeProvider();
		tProvStub.setHours(18);
		sut.setTimeProvider(tProvStub);
		sut.reminder();
		
		tProvStub.setHours(22);
		sut.setTimeProvider(tProvStub);
		sut.reminder();	// out : song

	}

}
