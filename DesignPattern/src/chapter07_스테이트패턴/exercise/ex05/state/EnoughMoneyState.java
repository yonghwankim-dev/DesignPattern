package chapter07_스테이트패턴.exercise.ex05.state;

import chapter07_스테이트패턴.exercise.ex05.VendingMachine;

public class EnoughMoneyState implements State {
	private VendingMachine machine;
	
	public EnoughMoneyState(VendingMachine machine)
	{
		this.machine = machine;
	}

	@Override
	public void insertCoin(int money) {
		// TODO Auto-generated method stub
		machine.getMoneyBox().insert(money);
		System.out.println(money + "원을 넣었습니다.");
		System.out.println("현재 금액은 "+machine.getMoneyBox().getMoney() + "원입니다.");
	}

	@Override
	public void pushButton(int price) {
		// TODO Auto-generated method stub
		machine.getMoneyBox().dispense(price);
		machine.getDrinking().dispense();	// 음료수 구입
		System.out.println("음료수가 나왔습니다.");
		
		if(machine.getDrinking().getStock()==0)	// 음료수 재고가 없다면
		{
			machine.setState(machine.getSoldOutState());	// 매진 상태로 변경
		}
		// 잔액이 새 음료수를 구입하기에 충분하지 못한 경우
		else if(machine.getMoneyBox().getMoney() < machine.getDrinking().getPrice())
		{
			machine.setState(machine.getNoEnoughMoneyState());	// NoEnough 상태로 변경
		}
		// 잔액이 하나도 없는 경우
		else if(machine.getMoneyBox().getMoney()==0)
		{
			machine.setState(machine.getNoMoneyState());	// NoMoney 상태로 변경
		}
	}
	
	// 잔액을 반환한 후 NoMoney 상태로 변경
	@Override
	public void returnCoin() {
		// TODO Auto-generated method stub
		int tmp = machine.getMoneyBox().returnMoney();
		System.out.println(tmp + "원이 반환되었습니다.");
		machine.setState(machine.getNoMoneyState()); // NoMoney 상태로 변경
	}
}
