package chapter02_��ü�������.practice.p01_encapsulation.after;


public class StackClient {
	public static void main(String[] args)
	{
		ArrayListStack st = new ArrayListStack(10);
		st.push(10);
		System.out.println(st.peek());
	}
	
}

// StackClient�� push, pop, peek �޼����� ���길���� ������ ��� �����ϴ�.
// ������ push, pop, peek �޼��� ���� � ������� � �ڷᱸ���� ����� �۾���
// �����ϴ����� �� �� ����. ��, ���ð� �̸� ����ϴ� �ڵ��� ���յ��� �������� ���̴�.