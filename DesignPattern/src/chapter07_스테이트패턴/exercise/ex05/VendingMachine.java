package chapter07_스테이트패턴.exercise.ex05;

import chapter07_스테이트패턴.exercise.ex05.state.EnoughMoneyState;
import chapter07_스테이트패턴.exercise.ex05.state.NoEnoughMoneyState;
import chapter07_스테이트패턴.exercise.ex05.state.NoMoneyState;
import chapter07_스테이트패턴.exercise.ex05.state.SoldOutState;
import chapter07_스테이트패턴.exercise.ex05.state.State;

public class VendingMachine {
	private State noMoneyState;	// 돈이 하나도 없는 상태
	private State noEnoughMoneyState;	// 돈은 있으나 음료를 사기에 부족한 상태
	private State enoughMoneyState;		// 음료를 사기에 돈이 충분한 상태
	private State soldOutState;			// 음료가 매진된 상태
	private State state;
	
	private MoneyBox moneyBox;
	private Drinking drinking;
	
	public VendingMachine(int stock, int price)
	{
		noMoneyState = new NoMoneyState(this);
		noEnoughMoneyState = new NoEnoughMoneyState(this);
		enoughMoneyState = new EnoughMoneyState(this);
		soldOutState = new SoldOutState(this);
		
		moneyBox = new MoneyBox();
		drinking = new Drinking(stock, price);
		
		if(drinking.getStock()>0)
		{
			// 음료 재고가 있는 경우 돈이 하나도 없는 상태가 벤딩 머신의 초기 상태임
			state = noMoneyState;
		}
		else
		{
			// 음료 재고가 없는 경우 벤딩 머신의 초기 상태는 매진 상태임
			state = soldOutState;
		}
	}
	
	public void setState(State state)	// 현재 상태를 설정함
	{
		this.state = state;
	}
	
	public void insertMoney(int money)
	{
		state.insertCoin(money);
	}
	
	public void pushButton()
	{
		int price = drinking.getPrice();
		state.pushButton(price);
	}
	
	public void returnMoney()
	{
		state.returnCoin();
	}

	public State getNoMoneyState() {
		return noMoneyState;
	}

	public State getNoEnoughMoneyState() {
		return noEnoughMoneyState;
	}

	public State getEnoughMoneyState() {
		return enoughMoneyState;
	}

	public State getSoldOutState() {
		return soldOutState;
	}

	public MoneyBox getMoneyBox() {
		return moneyBox;
	}

	public Drinking getDrinking() {
		return drinking;
	}
	
	
}
