package chapter05_��Ʈ��Ƽ������.exercise.p06_1_code;


public class Client {
	public static void main(String args[])
	{
		Item item1 = new Item("Shampoo",3000);
		Item item2 = new Item("Cookie",1000);
		
		Sale sale = new Sale();
		String expected = "Shampoo3000Cookie1000";
		
		sale.add(item1);
		sale.add(item2);
		
		FakePrinter printer = new FakePrinter();
		sale.setReceiptPrinter(printer);
		sale.printReceipt();
		if(expected.contentEquals(printer.getReceiptContents()))
		{
			System.out.println("pass!");
		}
		else 
		{
			System.out.println("fail!");
		}
		
	}
}
