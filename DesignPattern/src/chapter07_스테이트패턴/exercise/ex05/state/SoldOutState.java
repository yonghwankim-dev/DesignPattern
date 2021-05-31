package chapter07_스테이트패턴.exercise.ex05.state;

import chapter07_스테이트패턴.exercise.ex05.VendingMachine;

public class SoldOutState implements State {
	private VendingMachine machine;
	public SoldOutState(VendingMachine machine) {
		// TODO Auto-generated constructor stub
		this.machine = machine;
	}
	// 매진 상태에서 돈이 투입되면 재고가 없다는 메시지 출력
	@Override
	public void insertCoin(int money) {
		// TODO Auto-generated method stub
		System.out.println("재고가 없습니다.");
	}
	@Override
	public void pushButton(int price) {			// 매진 상태에서는 구입 버튼을 눌러도 동작하지 않음
		// TODO Auto-generated method stub
		
	}
	// 잔액을 반환한 후 NoMoney 상태로 변경
	@Override
	public void returnCoin() {
		// TODO Auto-generated method stub
		int tmp = machine.getMoneyBox().returnMoney();
		System.out.println(tmp + "원이 반환되었습니다.");
		machine.setState(machine.getNoMoneyState());	//NoMoney 상태로 변경
	}

}
