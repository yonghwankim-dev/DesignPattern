package chapter03_SOLID��Ģ.exercise.ex07.after;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		// ������ �ν��Ͻ� ����
		Employee e1 = new Employee("gildongHong", "ȫ�浿", 40, 10);
		Employee e2 = new Employee("yonghwanKim", "���ȯ", 60, 20);
		
		// ������ payLogic ����
		e1.setPayManager(new PayLogic1());
		e2.setPayManager(new PayLogic2());
		
		// ����Ʈ�� ���� �߰�
		ArrayList<Employee> employees = new ArrayList<Employee>();
		employees.add(e1);
		employees.add(e2);
		
		// ���� ���� �� �ӱ� ����� �ַܼ� ���
		PayrollManager paymentOnConsole = new PaymentOnConsole();
		paymentOnConsole.setEmployees(employees);
		paymentOnConsole.writeEmployeePay();
	
	}

}