package chapter05_��Ʈ��Ƽ������.exercise.p03_1_code;

public class Book {
	// å�� ����, ���ǳ⵵, ������ ����
	private String name;		// ����
	private int publishYear;	// ���ĳ⵵
	private int price;			// ����
	
	public Book(String name, int publishYear, int price) {
		this.name = name;
		this.publishYear = publishYear;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public int getPublishYear() {
		return publishYear;
	}

	public int getPrice() {
		return price;
	}
}
