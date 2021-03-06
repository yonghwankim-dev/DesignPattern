package chapter03_SOLID??Ģ.exercise.ex07.after;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class PayrollManager {
	private ArrayList<Employee> employees = new ArrayList<Employee>();
	protected abstract void writePayment(int amount);
	
	public void writeEmployeePay() {
		Iterator<Employee> iter = employees.iterator();
		
		while(iter.hasNext()) {
			Employee curEmp = iter.next();
			int amount = curEmp.calculatePay();
			writePayment(amount);
		}
	}

	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}
	
	
}
