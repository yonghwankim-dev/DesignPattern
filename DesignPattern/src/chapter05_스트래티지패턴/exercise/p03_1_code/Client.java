package chapter05_��Ʈ��Ƽ������.exercise.p03_1_code;

/**
 * ��Ʈ��Ƽ�� ������ ����� ���� �䱸������ �����ϴ� �ڵ带 �ۼ��϶�.
	- ȸ���� �̸��� ���� �뿩 �ݾ��� ���´�.
	- å�� ����, ���ĳ⵵, ������ ���´�.(���� ���Ѵ��� ����)
	- ȸ���� �ϳ��� å�� 1�� �̻� �� �� �ִ�.
	- ���� ��å�� ���� å ���� ���εǸ� �ٸ� ���� ��å�� �߰��� �� �ִ�.
	- 10�� �̻�� å�� å ��ü ����, ���� �뿩 �ݾ��� ���� �̻��̸� ȸ�� ����, �� ���� ��쿡�� ������ ���� �ʴ´�.

 * @author qkdlf
 *
 */
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Member member1 = new Member("member1");
		Member member2 = new Member("member2");
		
		Book book1 = new Book("book1", 2005, 1000);
		Book book2 = new Book("book2", 2004, 1200);
		Book book3 = new Book("book3", 2001, 4300);
		
		Rental rental1 = new Rental(member1, book2, new OrdinaryPricePolicy(),2);
		Rental rental2 = new Rental(member2, book1, new OrdinaryPricePolicy(), 3);
		Rental rental3 = new Rental(member2, book3, new BookDiscountPricePolicy(),4);
		Rental rental4 = new Rental(member1, book2, new MemberDiscountPricePolicy(),3);
		
		System.out.println(rental1.getPrice());
		System.out.println(rental2.getPrice());
		System.out.println(rental3.getPrice());
		System.out.println(rental4.getPrice());
	}

}
