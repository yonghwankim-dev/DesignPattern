package chapter06_ΩÃ±€≈œ∆–≈œ.ch06_08;

public class NormalTicket implements Ticket{
	private int serial_num;
	
	public NormalTicket(int num)
	{
		this.serial_num = num;
	}
	@Override
	public int getTicketNum() {
		// TODO Auto-generated method stub
		return serial_num;
	}
	
}
