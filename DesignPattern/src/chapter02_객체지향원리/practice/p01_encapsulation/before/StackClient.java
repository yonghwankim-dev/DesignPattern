package chapter02_��ü�������.practice.p01_encapsulation.before;


// StackClientŬ������ push �޼��峪 pop �޼��带 ������� �ʰ� ���� �迭�� ���� ������ �� �ִ�.
// �̷� ��� ArrayStack�� StackClient Ŭ������ ���� ������ �߻��Ѵ�.
// ArrayList Ŭ������ ����� ���� ������ ����Ǹ� StackClient Ŭ������ ���� ����Ǿ����
// ������ StackClient Ŭ������ ���е� ������ ���� ����ϱ� ������ ���� ������ ����Ǹ� �ش� ������
// ����� �ʵ� ��� ����Ǿ�� �ϴ� �������� ������ �ִ�.
public class StackClient {

	public static void main(String[] args) {
		ArrayStack st = new ArrayStack(10);
		st.itemArray[++st.top] = 20;
		System.out.println(st.itemArray[st.top]);
		
	}

}
