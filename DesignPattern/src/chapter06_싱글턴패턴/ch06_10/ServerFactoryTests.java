package chapter06_ΩÃ±€≈œ∆–≈œ.ch06_10;

import junit.framework.TestCase;

public class ServerFactoryTests extends TestCase{
	public void setUp()
	{
		ServerFactory.setServer(new ServerProvider() {
			
			@Override
			public Server getServer() {
				// TODO Auto-generated method stub
				return new FakeServer();
			}
		});
	}
	
	public void testSomething()
	{
		UseServer use = new UseServer();
		use.doSomeThing();
		FakeServer server = (FakeServer) use.getServer();
		assertEquals("invoked",server.getResult());
	}
}
