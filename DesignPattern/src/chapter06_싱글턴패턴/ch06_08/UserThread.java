package chapter06_�̱�������.ch06_08;

public class UserThread extends Thread{
	private Ticket myTicket;
	
	public UserThread(String name)
	{
		super(name);
	}
	
	public void run()
	{
		TicketManager mgr = TicketManager.getTicketManager();
		myTicket = mgr.getTicket();	// Ƽ�� ���� ���
	}
	
	public Ticket getMyTicket()
	{
		return myTicket;
	}
}
