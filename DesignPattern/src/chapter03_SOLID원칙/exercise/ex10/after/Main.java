package chapter03_SOLID��Ģ.exercise.ex10.after;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		PayGUI payGUI = new PayGUI(new DefaultStrategy());
		
		PayGUI payGUI = new PayGUI(new NewStrategy());
	}

}
