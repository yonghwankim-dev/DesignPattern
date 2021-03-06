package chapter07_스테이트패턴.exercise.ex05.state;

import chapter07_스테이트패턴.exercise.ex05.VendingMachine;

public class NoEnoughMoneyState implements State {
	private VendingMachine machine;
	public NoEnoughMoneyState(VendingMachine machine)
	{
		this.machine = machine;
	}
	@Override
	public void insertCoin(int money) {
		// TODO Auto-generated method stub
		machine.getMoneyBox().insert(money);
		System.out.println(money + "원을 넣었습니다.");
		
		// 돈이 충분하게 투입되지 않은 상태에서 음료를 사기에 충분한 돈을 투입한 경우
		if(money >= machine.getDrinking().getPrice())
		{
			machine.setState(machine.getEnoughMoneyState());	// EnoughMoney 상태로 변경
		}
		else	// 음료를 사기에 충분한 돈이 투입되지 않은 경우
		{
			machine.setState(machine.getNoEnoughMoneyState());	// NoEnoughMoney 상태로 진입
		}
		System.out.println("현재 금액은 " + machine.getMoneyBox().getMoney());
	}
	@Override
	public void pushButton(int price) {		// 돈이 충분치 않은 상태에서 버튼을 누르는 경우
		// TODO Auto-generated method stub
		System.out.println("동전을 넣어주세요.");
	}
	@Override
	public void returnCoin() {
		// TODO Auto-generated method stub
		int tmp = machine.getMoneyBox().returnMoney();
		System.out.println(tmp + "원이 반환되었습니다.");
		machine.setState(machine.getNoMoneyState());
	}
}
