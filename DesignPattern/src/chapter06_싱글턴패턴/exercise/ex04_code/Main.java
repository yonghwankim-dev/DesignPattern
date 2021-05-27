package chapter06_ΩÃ±€≈œ∆–≈œ.exercise.ex04_code;

public class Main {
	private static final int THREAD_NUM = 10;
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
