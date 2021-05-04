package chapter14_������Ʈ����.ch14_03.computer;

import java.util.ArrayList;
import java.util.List;

import chapter14_������Ʈ����.ch14_01.computer.part.Body;
import chapter14_������Ʈ����.ch14_01.computer.part.Keyboard;
import chapter14_������Ʈ����.ch14_01.computer.part.Monitor;
import chapter14_������Ʈ����.ch14_02.computer.part.Speaker;
import chapter14_������Ʈ����.ch14_03.computer.computerDevice.ComputerDevice;

public class Computer {
	// �������� ComputerDevice ��ü�� ����Ŵ
	private List<ComputerDevice> components = new ArrayList<ComputerDevice>();
	
	// ComputerDevice ��ü�� Computer Ŭ������ �߰���
	public void addComponent(ComputerDevice component)
	{
		components.add(component);
	}
	
	// CompouterDevice ��ü�� Computer Ŭ�������� ������
	public void removeComponent(ComputerDevice component)
	{
		components.remove(component);
	}
	
	// ��ü ������ �����ϴ� �� ��ǰ�� ������ �ջ���
	public int getPrice()
	{
		int price = 0;
		for(ComputerDevice c : components)
		{
			price += c.getPrice();
		}
		
		return price;
	}
	
	// ��ü ������ �����ϴ� �� ��ǰ�� ������ �ջ���.
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
