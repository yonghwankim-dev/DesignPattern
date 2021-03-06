package chapter03_SOLID??Ģ.exercise.ex07.before;

import java.util.ArrayList;
import java.util.Iterator;

public class PayrollManager {
	private ArrayList<Employee> employees = new ArrayList<Employee>();
	
	public void writeEmployeePay() {
		Iterator<Employee> iter = employees.iterator();
		
		while(iter.hasNext()) {
			Employee curEmp = iter.next();
			System.out.println(curEmp.calculatePay());
		}
	}
	
	public void addEmployee(Employee employee) {
		employees.add(employee);
	}
}
