package chapter10_데커레이터패턴.ch10_05;

public class ExternalDecorator extends ContentDecorator{

	public ExternalDecorator(EMailContent decoratedContent) {
		super(decoratedContent);
	}

	public String getContent()
	{
		String content = super.getContent();
		return addDisclaimer(content);
	}
	
	private String addDisclaimer(String content)
	{
		return content + " Company Disclaimer";
	}
}
