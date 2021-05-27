package chapter06_�̱�������.exercise.ex05_code;

public class UseServer {
	private Server server;
	
	public Server getServer()
	{
		return server;
	}
	
	public void doSomeThing()
	{
		ServerProvider factory = ServerFactory.getInstance();
		server = factory.getServer();
		server.doSomeThing();
	}
}
