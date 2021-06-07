package chapter10_��Ŀ����������.exercise.ex01_02;

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
