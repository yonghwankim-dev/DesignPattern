package chapter06_�̱�������.exercise.ex05_code;

public class ServerFactory implements ServerProvider {
	private static ServerProvider serverProvider = new ServerProvider() {
		
		@Override
		public Server getServer() {
			// TODO Auto-generated method stub
			return new ServerProxy();
		}
	};
	
	public synchronized static ServerProvider getInstance()
	{
		return serverProvider;
	}

	@Override
	public Server getServer() {
		// TODO Auto-generated method stub
		return serverProvider.getServer();
	}
	
	public static void setServer(ServerProvider sp)
	{
		serverProvider = sp;
	}
}
