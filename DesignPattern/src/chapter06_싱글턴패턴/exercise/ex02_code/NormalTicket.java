package chapter06_ΩÃ±€≈œ∆–≈œ.exercise.ex02_code;

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
