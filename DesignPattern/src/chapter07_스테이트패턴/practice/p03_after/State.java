package chapter07_스테이트패턴.practice.p03_after;

public interface State {
	public void on_button_pushed(Light light);
	public void off_button_pushed(Light light);
}
