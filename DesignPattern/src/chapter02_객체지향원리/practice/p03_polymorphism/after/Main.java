package chapter02_��ü�������.practice.p03_polymorphism.after;

public class Main {

	public static void main(String[] args) {
		Pet[] pets = {new Cat(), new Dog(), new Parrot()};
		
		for(Pet p : pets)
		{
			p.talk();
		}
	}

}

// �������� ����ϴ� ��쿡�� ��ü������ ���� � Ŭ���� ��ü�� �����Ǵ����� �����ϰ� ���α׷����� �� �� �ִ�. 
// ���� ���ο� �ֿϵ����� ��Ÿ���� Ŭ������ �ڽ� Ŭ������ �߰��Ǵ��� �ڵ�� ������ ���� �����.
// ���� ���� ������ ������ �Ϲ�ȭ ���迡 ������ �θ� Ŭ������ ���� ������ �ڽ� Ŭ������ ��ü�� ������ �� �ֱ� �����̴�.
