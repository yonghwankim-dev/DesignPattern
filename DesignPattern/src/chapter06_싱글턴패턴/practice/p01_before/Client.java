package chapter06_ΩÃ±€≈œ∆–≈œ.practice.p01_before;

public class Client {
	private static final int User_NUM =5;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		User[] user = new User[User_NUM];
		for(int i=0;i<User_NUM;i++)
		{
			user[i] = new User((i+1)+"=user");
			user[i].print();
		}
	}

}
