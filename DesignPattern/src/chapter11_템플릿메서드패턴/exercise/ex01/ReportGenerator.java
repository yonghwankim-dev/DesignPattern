package chapter11_템플릿메서드패턴.exercise.ex01;

import java.util.ArrayList;
import java.util.List;

public abstract class ReportGenerator {
	public String generate(List<Customer> customers)
	{
		List<Customer> selectedCustomers = select(customers);
		String header = getReportHeader(selectedCustomers);
		
		String reportCustomers = "";
		for(Customer c : selectedCustomers)
		{
			reportCustomers += customerReportForCustomer(c);
		}
		String footer = getReportFooter(selectedCustomers);
		
		return header + reportCustomers + footer;
	}
	
	protected List<Customer> select(List<Customer> customers) {
		List<Customer> selectedCustomers = new ArrayList<Customer>();
		
		for(Customer c : customers)
		{
			if(customerReportCondition(c))
			{
				selectedCustomers.add(c);
			}
		}
		return selectedCustomers;
	}
	
	protected abstract boolean customerReportCondition(Customer customer);
	
	protected abstract String getReportHeader(List<Customer> customers);
	protected abstract String customerReportForCustomer(Customer customer);
	protected abstract String getReportFooter(List<Customer> customers);
	
}
