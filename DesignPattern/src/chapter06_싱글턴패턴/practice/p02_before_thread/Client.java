package chapter06_�̱�������.practice.p02_before_thread;

public class Client {
	private static final int THREAD_NUM =5;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UserThead[] user = new UserThead[THREAD_NUM];
		for(int i=0;i<THREAD_NUM;i++)
		{
			user[i] = new UserThead((i+1)+"-thread");
			user[i].start();
		}
	}

}
