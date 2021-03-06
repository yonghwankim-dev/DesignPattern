package chapter10_데커레이터패턴.exercise.ex01_02;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EMailContent simple = new BasicEmailContent("hello");	// 기본 메일
		System.out.println(simple.getContent());
		
		EMailContent external = new ExternalDecorator(simple);	// 외부메일
		System.out.println(external.getContent());
		
		EMailContent secure = new SecureDecorator(simple);	// 암호 메일
		System.out.println(secure.getContent());
		
		// 외부 메일 후에 암호 메일
		EMailContent secureAfterExternal = new SecureDecorator(external);
		System.out.println(secureAfterExternal.getContent());
	}

}
