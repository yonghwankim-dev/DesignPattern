package chapter03_SOLID��Ģ.practice.p04_DIP_DependencyInversionPrinciple.before;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * �Ʒ��� ���� �������� Kid Ŭ������ Lego Ŭ������ ������ ��� ������
		 * Kid Ŭ������ Robot ��ü�� �ʵ�� ������ �ֱ� ������ ������ �Ұ����ϴ�.
		 * �̴� ���� ���� ��Ģ(DIP)�� ������ ��������Ģ(OCP)�� ������ �ʷ��Ѵ�.
		 */
		Robot t = new Robot();
		Kid k = new Kid();
		k.setToy(t);
		k.play();
	}

}

// ������
// 1. Kid Ŭ������ Lego Ŭ������ ������ ��� ������ Kid Ŭ������ Robot ��ü�� �ʵ�� 
// ������ �ֱ� ������ ������ �Ұ����ϴ�.
// 2. �̴� ���� ���� ��Ģ(DIP, DependencyInversionPrinciple)�� ������ OCP(OpenClosedPrinciple)�� ������ �ʷ��Ѵ�.