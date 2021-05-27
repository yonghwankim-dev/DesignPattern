package chapter06_ΩÃ±€≈œ∆–≈œ.practice.p06_static_class_fake_printer;

import junit.framework.TestCase;

public class UsePrinterTest extends TestCase{
	public void testdoSomething()
	{
		FakePrinter fake = new FakePrinter();
		UsePrinter u = new UsePrinter();
		u.doSomething(fake);
		assertEquals("this is a test", fake.get());
	}
}
