package chapter07_������Ʈ����.exercise.ex05.state;

import chapter07_������Ʈ����.exercise.ex05.VendingMachine;

public class SoldOutState implements State {
	private VendingMachine machine;
	public SoldOutState(VendingMachine machine) {
		// TODO Auto-generated constructor stub
		this.machine = machine;
	}
	// ���� ���¿��� ���� ���ԵǸ� ��� ���ٴ� �޽��� ���
	@Override
	public void insertCoin(int money) {
		// TODO Auto-generated method stub
		System.out.println("��� �����ϴ�.");
	}
	@Override
	public void pushButton(int price) {			// ���� ���¿����� ���� ��ư�� ������ �������� ����
		// TODO Auto-generated method stub
		
	}
	// �ܾ��� ��ȯ�� �� NoMoney ���·� ����
	@Override
	public void returnCoin() {
		// TODO Auto-generated method stub
		int tmp = machine.getMoneyBox().returnMoney();
		System.out.println(tmp + "���� ��ȯ�Ǿ����ϴ�.");
		machine.setState(machine.getNoMoneyState());	//NoMoney ���·� ����
	}

}
