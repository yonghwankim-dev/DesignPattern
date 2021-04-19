package chapter07_스테이트패턴.ch07_05;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VendingMachine machine = new VendingMachine(5, 1000);
		machine.insertMoney(1000);
		machine.insertMoney(500);
		machine.pushButton();
		machine.returnMoney();
		machine.insertMoney(1000);
		machine.insertMoney(1000);
		machine.pushButton();
	}

}
