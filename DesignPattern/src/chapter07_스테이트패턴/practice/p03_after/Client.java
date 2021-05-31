package chapter07_스테이트패턴.practice.p03_after;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Light light = new Light();
		light.off_button_pushed();	// 반응 없음
		light.on_button_pushed();	// Light On
		light.off_button_pushed();	// Light Off
	}
}
