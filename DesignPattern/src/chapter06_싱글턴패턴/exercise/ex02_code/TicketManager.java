package chapter06_싱글턴패턴.exercise.ex02_code;

public class TicketManager {
	private static TicketManager mgr;
	private int limits;	// 발행할 수 있는 티켓의 수
	private int count;	// 현재 발행된 티켓의 수
	
	public TicketManager()
	{
		count = 0;
	}
	
	// 오직 하나의 티켓 발행기를 생성함
	public synchronized static TicketManager getTicketManager() {
		// TODO Auto-generated method stub
		if(mgr==null)
		{
			mgr = new TicketManager();
		}
		return mgr;
	}
	
	public synchronized void setTicketLimits(int limits)
	{
		this.limits = limits;
	}
	
	public synchronized Ticket getTicket()
	{
		if(this.count < this.limits)
		{
			return new NormalTicket(++this.count);
		}
		return new NullTicket();
	}
}
