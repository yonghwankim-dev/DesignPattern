package chapter05_스트래티지패턴.ch05_07;

import java.util.ArrayList;
import java.util.Iterator;

import chapter05_스트래티지패턴.ch05_07.strategy.ReceiptPrinter;

public class Sale {
	private ArrayList<Item> items = new ArrayList<Item>();
	private ReceiptPrinter printer;
	// strategy printer interface
	
	public void setReceiptPrinter(ReceiptPrinter printer)
	{
		this.printer = printer;
	}
	
	public void printReceipt()
	{
		Iterator<Item> itr = items.iterator();
		StringBuffer buf = new StringBuffer();
		while(itr.hasNext())
		{
			Item item = itr.next();
			buf.append(item.getName());
			buf.append(item.getPrice());
		}
		printer.print(buf.toString());
	}
	
	public void add(Item item)
	{
		items.add(item);
	}
}
