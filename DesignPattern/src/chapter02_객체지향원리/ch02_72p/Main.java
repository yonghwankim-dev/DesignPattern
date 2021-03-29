package chapter02_객체지향원리.ch02_72p;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStack<String> st = new MyStack<String>();
		
		st.push("insang1");
		st.push("insang2");
		st.set(0, "insang3");	//허용되어서는 안됨
		
		/**
		 * st 스택 상황
		 * [insang1,insang2] -> [insang3, insang2]
		 * 
		 * output
		 * insang2
		 * insang3
		 */
		System.out.println(st.pop());
		System.out.println(st.pop());
		
	}

}
