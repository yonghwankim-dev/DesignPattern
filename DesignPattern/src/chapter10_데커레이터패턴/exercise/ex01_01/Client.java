package chapter10_��Ŀ����������.exercise.ex01_01;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BasicEmailContent simple = new BasicEmailContent("Hello");
		System.out.println(simple.getContent());
		
		ExternalEmailContent external = new ExternalEmailContent("Hello");
		System.out.println(external.getContent());
		
		SecureEmailContent secure = new SecureEmailContent("Hello");
		System.out.println(secure.getContent());
	}

}
