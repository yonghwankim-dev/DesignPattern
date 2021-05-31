package chapter07_스테이트패턴.ch07_05.state;

import chapter07_스테이트패턴.ch07_05.VendingMachine;

public class NoMoneyState implements State {
	private VendingMachine machine;
	public NoMoneyState(VendingMachine machine)
	{
		this.machine = machine;
	}
	
	@Override
	public void insertCoin(int money) {
		// TODO Auto-generated method stub
		machine.getMoneyBox().insert(money);
		System.out.println(money + "원을 넣었습니다.");
		
		// 돈이 전혀 투입되지 않은 상태에서 음료를 사기에 충분한 돈을 투입한 경우
		if(money >= machine.getDrinking().getPrice())
		{
			machine.setState(machine.getEnoughMoneyState());	// EnoughMoney 상태로 변경
		}
		else	// 음료를 사기에 충분한 돈이 투입되지 않은 경우
		{
			machine.setState(machine.getNoEnoughMoneyState());	// NoEnoughMoney 상태로 진입
		}
		System.out.println("현재 금액은 " + machine.getMoneyBox().getMoney() + "입니다.");
		
	}
	@Override
	public void pushButton(int price) {		// 돈이 전혀 투입되지 않고 버튼을 누르는 경우
		// TODO Auto-generated method stub
		System.out.println("동전을 넣어주세요.");	// 동전 투입 요구 메시지 출력
	}
	@Override
	public void returnCoin() {	// 돈이 전혀 투입되지 않은 경우에 돈 반환을 요구하는 경우
		// TODO Auto-generated method stub
		System.out.println("반환할 동전이 없습니다.");	// 반환할 동전이 없다는 메시지 출력
	}
}
