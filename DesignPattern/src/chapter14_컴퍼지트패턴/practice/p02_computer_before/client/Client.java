package chapter14_컴퍼지트패턴.practice.p02_computer_before.client;

import chapter14_컴퍼지트패턴.practice.p02_computer_before.Computer;
import chapter14_컴퍼지트패턴.practice.p02_computer_before.computer.part.Body;
import chapter14_컴퍼지트패턴.practice.p02_computer_before.computer.part.Keyboard;
import chapter14_컴퍼지트패턴.practice.p02_computer_before.computer.part.Monitor;
import chapter14_컴퍼지트패턴.practice.p02_computer_before.computer.part.Speaker;

public class Client {

	public static void main(String[] args) {
		// 컴퓨터의 부품으로 Body, Keyboard, Monitor 객체를 생성함
		Body body = new Body(100, 70);
		Keyboard keyboard = new Keyboard(5, 2);
		Monitor monitor = new Monitor(20, 30);
		Speaker speaker = new Speaker(100, 50);
		
		// Computer 객체를 생성하고 부품 객체들을 설정함
		Computer computer = new Computer();
		computer.addBody(body);
		computer.addKeyboard(keyboard);
		computer.addMonitor(monitor);
		computer.addSpeaker(speaker);
		
		// 컴퓨터의 가격과 전력 소비량을 구함
		int computerPrice = computer.getPrice();
		int computerPower = computer.getPower();
		System.out.println("Computer Price : " + computerPrice + "W");
		System.out.println("Computer Power : " + computerPower + "만 원");
		
	}

}
