package chapter14_������Ʈ����.practice.p03_computer_after.client;

import chapter14_������Ʈ����.practice.p03_computer_after.computer.Computer;
import chapter14_������Ʈ����.practice.p03_computer_after.computer.part.Body;
import chapter14_������Ʈ����.practice.p03_computer_after.computer.part.Keyboard;
import chapter14_������Ʈ����.practice.p03_computer_after.computer.part.Monitor;

public class Client {

	public static void main(String[] args) {
		// ��ǻ���� ��ǰ���� Body, Keyboard, Monitor ��ü�� ������
		Body body = new Body(100, 70);
		Keyboard keyboard = new Keyboard(5, 2);
		Monitor monitor = new Monitor(20, 30);
		
		// Computer ��ü�� �����ϰ� ��ǰ ��ü���� ������
		Computer computer = new Computer();
		computer.addComponent(body);
		computer.addComponent(keyboard);
		computer.addComponent(monitor);
		
		// ��ǻ���� ���ݰ� ���� �Һ��� ����
		int computerPrice = computer.getPrice();
		int computerPower = computer.getPower();
		System.out.println("Computer Price : " + computerPrice + "W");		// 125W
		System.out.println("Computer Power : " + computerPower + "�� ��");	// 102����
		
	}

}
