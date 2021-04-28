package chapter10_데커레이터패턴.ch10_04;

public class ExternalEmailContent extends BasicEmailContent{

	public ExternalEmailContent(String content) {
		super(content);
	}
	
	public String getContent()
	{
		String content = super.getContent();
		String externalContent = addDisclaimer(content);
		return externalContent;
	}
	
	private String addDisclaimer(String content)
	{
		return content + " Company Disclaimer";
	}
	
}
