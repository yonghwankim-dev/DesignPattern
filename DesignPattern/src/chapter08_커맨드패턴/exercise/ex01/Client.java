package chapter08_커맨드패턴.exercise.ex01;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TV tv = new TV();
		TwoButtonController rc = new TwoButtonController(tv);
		
		rc.button1Pressed();
		rc.button2Pressed();
		
		rc.button1Pressed();
		rc.button2Pressed();
	}

}
