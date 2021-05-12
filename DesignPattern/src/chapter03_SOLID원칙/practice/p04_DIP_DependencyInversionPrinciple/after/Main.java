package chapter03_SOLID��Ģ.practice.p04_DIP_DependencyInversionPrinciple.after;

public class Main {

	public static void main(String[] args) {
		// ���� ��ü ����
		Kid kid = new Kid();
		
		// �κ� �峭�� ��ü ����, ����
		Toy robot = new Robot();
		kid.setToy(robot);
		kid.play();
		
		// ���� �峭�� ��ü ����, ����
		Toy lego = new Lego();
		kid.setToy(lego);
		kid.play();
	}

}

// DIP(Dependency Inversion Principle, ���� ���� ��Ģ)
// 1. DIP�� ���� ���踦 ���� �� ��ȭ�ϱ� ���� �� ���� ���� ��ȭ�ϴ� �ͺ��ٴ� ��ȭ�ϱ� ����� ��, ���� ��ȭ�� ���� �Ϳ� �����϶�� ��Ģ�̴�.
// 2. ��ü���� ���������� ���ϱ� ����� �߻����� �͵��� ǥ���ϴ� �������� �߻� Ŭ������ �������̽��� �����Ѵ�.
// 3. DIP�� �����Ϸ��� � Ŭ������ ������ ���� �� ��ü���� Ŭ�������ٴ� �������̽��� �߻� Ŭ������ ���� ���踦 �ε��� �����ؾ� �Ѵ�.
// 4. DIP�� �����ϴ� ����� ��ȭ�� ������ �ý����� �ȴ�.
// 5. DIP�� �����ϸ� ������ ����(Dependency Injection)�̶�� ����� ��ȭ�� ���� ������ �� �ִ� �ڵ带 �ۼ� �� �� �ִ�.

// DI(Dependency Injection, ������ ����)
// 1. Ŭ���� �ܺο��� ���� �Ǵ� ���� ��� ��ü�� �ν��Ͻ� ������ �����ϴ� ����̴�.
// 2. ������ ������ �̿��Ͽ� ��� ��ü�� �������� �ʰ� ����̿��� ��� ��ü�� �ܺ� ���� ��ü�� �ٲ� �� �ִ�.
// ex) Toy toy = new Robot();

