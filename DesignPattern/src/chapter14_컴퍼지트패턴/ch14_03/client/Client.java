package chapter14_컴퍼지트패턴.ch14_03.client;

import chapter14_컴퍼지트패턴.ch14_03.computer.Computer;
import chapter14_컴퍼지트패턴.ch14_03.computer.computerDevice.Body;
import chapter14_컴퍼지트패턴.ch14_03.computer.computerDevice.Keyboard;
import chapter14_컴퍼지트패턴.ch14_03.computer.computerDevice.Monitor;

public class Client {

	public static void main(String[] args) {
		// 컴퓨터의 부품으로 Body, Keyboard, Monitor 객체를 생성함
		Body body = new Body(100, 70);
		Keyboard keyboard = new Keyboard(5, 2);
		Monitor monitor = new Monitor(20, 30);
		
		// Computer 객체를 생성하고 부품 객체들을 설정함
		Computer computer = new Computer();
		computer.addComponent(body);
		computer.addComponent(keyboard);
		computer.addComponent(monitor);
		
		// 컴퓨터의 가격과 전력 소비량을 구함
		int computerPrice = computer.getPrice();
		int computerPower = computer.getPower();
		System.out.println("Computer Price : " + computerPrice + "W");
		System.out.println("Computer Power : " + computerPower + "만 원");
		
	}

}
