package chapter02_��ü�������.ch02_84p;

public abstract class Animal {
	public abstract void printName();
}

class Cat extends Animal{

	@Override
	public void printName() {
		// TODO Auto-generated method stub
		System.out.println("�����");
	}
}

class Dog extends Animal{

	@Override
	public void printName() {
		// TODO Auto-generated method stub
		System.out.println("��");
	}
}

class Snake extends Animal{

	@Override
	public void printName() {
		// TODO Auto-generated method stub
		System.out.println("��");
	}
}

class Lion extends Animal{

	@Override
	public void printName() {
		// TODO Auto-generated method stub
		System.out.println("����");
	}
	
	public void ride(){
		System.out.println("���� Ÿ���Ҵ�? Ÿ���� �ʾ����� ���� ������");
	}
}

