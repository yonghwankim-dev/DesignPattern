package chapter10_데커레이터패턴.exercise.ex01_02;

public class SecureDecorator extends ContentDecorator{

	public SecureDecorator(EMailContent decoratedContent) {
		super(decoratedContent);
	}

	public String getContent()
	{
		String content = super.getContent();
		return encrypt(content);
	}
	
	private String encrypt(String content)
	{
		return content + " encrpyt";
	}
}
