package chapter01_��ü����𵨸�.practice.p04;

/**
 * �� �ڵ��� ���� ���Դ� ����� ���� �����̹Ƿ� Professor Ŭ���� ��ü����
 * Student Ŭ���� ��ü�� ������ �� �ִ� �Ӽ��� �ְ� Student Ŭ���� ��ü����
 * Professor Ŭ���� ��ü�� ������ �� �ִ� �Ӽ�(advisor)�� �ִ�.
 * ���� �� �Ӽ��� �̸��� ���� �̸��� Ȱ���� ������ �� �� �ִ�.
 * @author qkdlf
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Professor hongGilDong = new Professor();
		Student manSup = new Student();
		hongGilDong.setStudent(manSup);
		hongGilDong.advise();
		
	}

}
