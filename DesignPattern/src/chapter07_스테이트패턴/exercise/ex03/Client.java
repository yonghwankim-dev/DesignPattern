package chapter07_스테이트패턴.exercise.ex03;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Light light = new Light();
		light.off_button_pushed();	// 반응 없음
		light.on_button_pushed();	// 형광등 ON
		light.on_button_pushed();	// 취침등 ON
		light.on_button_pushed();	// 형광등 ON
		light.off_button_pushed();	// 형광등 OFF
	}
}
