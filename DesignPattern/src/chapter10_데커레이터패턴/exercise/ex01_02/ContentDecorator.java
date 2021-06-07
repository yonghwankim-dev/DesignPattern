package chapter10_데커레이터패턴.exercise.ex01_02;

public class ContentDecorator extends EMailContent{
	private EMailContent decoratedContent; 
		
	public ContentDecorator(EMailContent decoratedContent) {
		this.decoratedContent = decoratedContent;
	}

	@Override
	public String getContent() {
		// TODO Auto-generated method stub
		return decoratedContent.getContent();
	}
}
