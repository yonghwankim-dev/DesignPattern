package chapter03_SOLID원칙.exercise.ex05;

public class Main {

	public static void main(String[] args) {
		// 종업원 인스턴스 생성
		Employee e1 = new Employee("gildongHong","홍길동", 40	, 10);
		
		e1.setPayManager(new PayLogic1());
		System.out.println(e1.calculatePay());
		
		e1.setPayManager(new PayLogic2());
		System.out.println(e1.calculatePay());
		
		e1.setPayManager(new PayLogic3());
		System.out.println(e1.calculatePay());
		
		e1.setPayManager(new NewPayLogic());
		System.out.println(e1.calculatePay());
	}

}
