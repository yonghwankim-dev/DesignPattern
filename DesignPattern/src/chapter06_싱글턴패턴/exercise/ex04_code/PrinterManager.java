package chapter06_�̱�������.exercise.ex04_code;

import java.util.ArrayList;

public class PrinterManager {
	private static PrinterManager mgr = null;
	private ArrayList<Printer> managedPrinters = new ArrayList<Printer>();

	public PrinterManager() {
		managedPrinters.add(new Printer());
		managedPrinters.add(new Printer());
		managedPrinters.add(new Printer());
		
	}

	public synchronized static PrinterManager getPrinterManager() {
		// TODO Auto-generated method stub
		if (mgr == null) {
			mgr = new PrinterManager();
		}
		return mgr;
	}

	public Printer getPrinter() {
		// TODO Auto-generated method stub
		while(true)
		{
			for(Printer printer : managedPrinters)
			{
				if(printer.isAvailable())
				{
					printer.setAvailable(false);
					return printer;
				}
			}
		}
	}
}
