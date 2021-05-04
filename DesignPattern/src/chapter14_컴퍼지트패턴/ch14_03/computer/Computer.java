package chapter14_컴퍼지트패턴.ch14_03.computer;

import java.util.ArrayList;
import java.util.List;

import chapter14_컴퍼지트패턴.ch14_01.computer.part.Body;
import chapter14_컴퍼지트패턴.ch14_01.computer.part.Keyboard;
import chapter14_컴퍼지트패턴.ch14_01.computer.part.Monitor;
import chapter14_컴퍼지트패턴.ch14_02.computer.part.Speaker;
import chapter14_컴퍼지트패턴.ch14_03.computer.computerDevice.ComputerDevice;

public class Computer {
	// 복수개의 ComputerDevice 객체를 가리킴
	private List<ComputerDevice> components = new ArrayList<ComputerDevice>();
	
	// ComputerDevice 객체를 Computer 클래스에 추가함
	public void addComponent(ComputerDevice component)
	{
		components.add(component);
	}
	
	// CompouterDevice 객체를 Computer 클래스에서 제거함
	public void removeComponent(ComputerDevice component)
	{
		components.remove(component);
	}
	
	// 전체 가격을 포함하는 각 부품의 가격을 합산함
	public int getPrice()
	{
		int price = 0;
		for(ComputerDevice c : components)
		{
			price += c.getPrice();
		}
		
		return price;
	}
	
	// 전체 전력을 포함하는 각 부품의 전력을 합산함.
	public int getPower()
	{
		int power = 0;
		for(ComputerDevice c : components)
		{
			power += c.getPower();
		}
		
		return power;
	}
}
