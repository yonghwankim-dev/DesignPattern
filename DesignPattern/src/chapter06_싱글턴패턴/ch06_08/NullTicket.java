package chapter06_싱글턴패턴.ch06_08;

// NullTicket 클래스: 발행할 수 있는 티켓보다 더 많은 티켓을 요구할때 발행되는 무효 티켓
public class NullTicket implements Ticket {

	@Override
	public int getTicketNum() {
		// TODO Auto-generated method stub
		return 0;
	}

}
