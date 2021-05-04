package chapter14_컴퍼지트패턴.ch14_02.computer;

import chapter14_컴퍼지트패턴.ch14_01.computer.part.Body;
import chapter14_컴퍼지트패턴.ch14_01.computer.part.Keyboard;
import chapter14_컴퍼지트패턴.ch14_01.computer.part.Monitor;
import chapter14_컴퍼지트패턴.ch14_02.computer.part.Speaker;

public class Computer {
	private Body body;
	private Keyboard keyboard;
	private Monitor monitor;
	private Speaker speaker;
	
	public void addBody(Body body)
	{
		this.body = body;
	}
	
	public void addKeyboard(Keyboard keyboard)
	{
		this.keyboard = keyboard;
	}
	
	public void addMonitor(Monitor monitor)
	{
		this.monitor = monitor;
	}
	
	public void addSpeaker(Speaker speaker)
	{
		this.speaker = speaker;
	}
	
	public int getPrice()
	{
		int bodyPrice = body.getPrice();
		int keyboardPrice = keyboard.getPrice();
		int monitorPrice = monitor.getPrice();
		int speakerPrice = speaker.getPrice();
		
		return bodyPrice + keyboardPrice + monitorPrice + speakerPrice;
	}
	
	public int getPower()
	{
		int bodyPower = body.getPower();
		int keyboardPower = keyboard.getPower();
		int monitorPower = monitor.getPower();
		int speakerPower = speaker.getPower();
		return bodyPower + keyboardPower + monitorPower + speakerPower;
	}
}
