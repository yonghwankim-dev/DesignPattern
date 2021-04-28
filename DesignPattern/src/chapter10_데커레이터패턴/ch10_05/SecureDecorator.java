package chapter10_��Ŀ����������.ch10_05;

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
