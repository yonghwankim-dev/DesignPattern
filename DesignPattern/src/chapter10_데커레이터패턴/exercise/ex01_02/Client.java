package chapter10_��Ŀ����������.exercise.ex01_02;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EMailContent simple = new BasicEmailContent("hello");	// �⺻ ����
		System.out.println(simple.getContent());
		
		EMailContent external = new ExternalDecorator(simple);	// �ܺθ���
		System.out.println(external.getContent());
		
		EMailContent secure = new SecureDecorator(simple);	// ��ȣ ����
		System.out.println(secure.getContent());
		
		// �ܺ� ���� �Ŀ� ��ȣ ����
		EMailContent secureAfterExternal = new SecureDecorator(external);
		System.out.println(secureAfterExternal.getContent());
	}

}
