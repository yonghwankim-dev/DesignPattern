package chapter10_데커레이터패턴.ch10_04;

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
