package chapter10_데커레이터패턴.ch10_05;

public class BasicEmailContent extends EMailContent{
	private String content;
	
	public BasicEmailContent(String content) {
		this.content = content;
	}

	@Override
	public String getContent() {
		// TODO Auto-generated method stub
		return content;
	}
	
}
