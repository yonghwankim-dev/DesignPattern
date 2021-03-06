package chapter03_SOLID원칙.exercise.ex07.before;

// Question
// 1. PayrollManager 클래스의 writeEmployeePay 메서드는 Employee 클래스의
// calculatePay 메서드에서 계산한 임금을 특정 출력 장치(여기에서는 콘솔)에 출력하는 일을 담당한다.
// 2. 현재 설계를 콘솔뿐만 아니라 다른 출력 장치로도 출력할 수 있도록 설계를 개선하라.
// 3. 단, 개선된 설계는 반드시 OCP 원칙을 만족해야 한다.

public class Main {

	public static void main(String[] args) {
		PayrollManager pm = new PayrollManager();
		
		Employee e1 = new Employee("gildongHong", "홍길동", 40, 10);
		Employee e2 = new Employee("yonghwanKim", "김용환", 60, 20);
		
		e1.setPayManager(new PayLogic1());
		e2.setPayManager(new PayLogic2());
		
		pm.addEmployee(e1);
		pm.addEmployee(e2);
		
		pm.writeEmployeePay();
	}

}

// 문제점
// 1. PayrollManager 클래스의 writeEmployeePay() 메서드는 OCP를 위반한다.
// 2. 이유는 현재 콘솔을 통해서만 직원의 계산된 임금을 출력하고 있다.
// 3. 만약 다른 출력장치로 출력하고 싶을때 writeEmployeePay 메소드의 내용을 변경해야하는 문제가 발생한다.
// 따라서 OCP 위반이 발생한다.

// 개선방안
// 1. OCP를 만족하려면 출력 매체가 변경되거나 추가되더라도 writeEmployeePay 메서드가 영향을 받지 않도록 해야 한다.
// 2. 따라서 PayrollManager 클래스에 자식 클래스들이 오버라이드하여 자기만의 출력을 할 수 있도록 writePayment()
// 와 같은 추상 메소드를 선언하고 자식 클래스들은 writePayment() 메소드를 오버라이드하여 콘솔 또는 파일 출력과 같이 구현한다.