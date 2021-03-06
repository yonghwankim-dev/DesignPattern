package chapter06_싱글턴패턴.exercise.ex02_code;
/**
 * title : 티켓 발행 프로그램 코드
 * 요구사항
 * 1. 사용자는 티켓 발행기를 이용해 티켓을 발행받을 수 있다.
 * 2. 티켓 발행기는 단 하나만 존재한다.
 * 3. 발행된 티켓은 고유의 시리얼 번호가 있다.
 * 4. 티켓의 시리얼 번호는 0보다 커야 하며, 0인 시리얼 번호는 유효하지 못한 티켓을 의미한다.
 * 5. 발행될 수 있는 티켓 개수는 한정되어 있다.
 * @author 김용환
 *
 */
public class Client {
	private static final int THREAD_NUM = 15;
	public static void main(String args[])
	{
		TicketManager mgr = TicketManager.getTicketManager();
		mgr.setTicketLimits(5);
		UserThread[] user = new UserThread[THREAD_NUM];	// 15개의 티켓을 요구하는 사용자 스레드
		
		for(int i=0;i<THREAD_NUM;i++)
		{
			user[i] = new UserThread((i+1)+"-thread");
			user[i].start();
		}
		
		for(int i=0;i<THREAD_NUM;i++)
		{
			try {
				user[i].join();
			}catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		
		for(int i=0;i<THREAD_NUM;i++)
		{
			if(user[i].getMyTicket().getTicketNum() != 0)
			{
				System.out.println("User" + i + "-th Thread get ticket" + user[i].getMyTicket().getTicketNum());
			}
		}
	}
}
