package chapter02_��ü�������.exercise.ex04.before;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Song s1 = new Song();
		s1.setMode("NonDiscounted");
		
		Song s2 = new Song();
		s2.setMode("NonDiscounted");
		
		Song s3 = new Song();
		s3.setMode("OnSale");
		
		Song s4 = new Song();
		s4.setMode("TodayEvent");
		
		CartForSongs c = new CartForSongs();
		
		c.add(s1);
		c.add(s2);
		c.add(s3);
		c.add(s4);
		
		System.out.println(c.calculateTotalPrice());
	}

}

// ���� ������
// 1. ���� ���α׷� ������ ���ο� �䱸����(���ο� ���� ���)�� ���������� �Ź� �����Ǿ�� �Ѵ�.
// ���� ���
// 1. �Ϲ�ȭ ���踦 ���� ������ ��带 �ܺο� ����(ĸ��ȭ)�� �ʿ䰡 �ִ�.
// 2. �������� ���� ���ε��� ���� ������ �������� ����ǵ��� �ؾ� �Ѵ�.