package chapter07_스테이트패턴.exercise.ex05.state;

public interface State {
	public void insertCoin(int money);
	public void pushButton(int price);
	public void returnCoin();
}
