package chapter10_데커레이터패턴.exercise.ex01_01;

public class SecureEmailContent extends BasicEmailContent{

	public SecureEmailContent(String content) {
		super(content);
	}
	
	public String getContent()
	{
		String content = super.getContent();
		String encryptedContent = encrypt(content);
		return encryptedContent;
	}
	
	private String encrypt(String content)
	{
		return content + " Encrypted";
	}
	
}
