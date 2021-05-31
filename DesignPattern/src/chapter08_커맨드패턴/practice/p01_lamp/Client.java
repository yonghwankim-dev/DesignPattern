package chapter08_커맨드패턴.practice.p01_lamp;

// 버튼을 눌렀을때 램프를 켜는 프로그램
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lamp lamp = new Lamp();
		Button lampButton = new Button(lamp);
		lampButton.pressed();	// Lamp On
	}

}
