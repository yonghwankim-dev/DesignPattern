package chapter03_SOLID원칙.exercise.ex07.after;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		// 종업원 인스턴스 생성
		Employee e1 = new Employee("gildongHong", "홍길동", 40, 10);
		Employee e2 = new Employee("yonghwanKim", "김용환", 60, 20);
		
		// 종업원 payLogic 설정
		e1.setPayManager(new PayLogic1());
		e2.setPayManager(new PayLogic2());
		
		// 리스트에 직원 추가
		ArrayList<Employee> employees = new ArrayList<Employee>();
		employees.add(e1);
		employees.add(e2);
		
		// 직원 설정 및 임금 계산을 콘솔로 출력
		PayrollManager paymentOnConsole = new PaymentOnConsole();
		paymentOnConsole.setEmployees(employees);
		paymentOnConsole.writeEmployeePay();
	
	}

}