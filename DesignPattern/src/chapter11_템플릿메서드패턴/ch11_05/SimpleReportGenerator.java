package chapter11_���ø��޼�������.ch11_05;

import java.util.Collections;
import java.util.List;

public class SimpleReportGenerator extends ReportGenerator{

	@Override
	protected boolean customerReportCondition(Customer customer) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected String getReportHeader(List<Customer> customers) {
		// TODO Auto-generated method stub
		return String.format("���� ��: %d\n", customers.size());
	}

	@Override
	protected String customerReportForCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return String.format("%s: %d\n", customer.getName(), customer.getPoint());
	}

	@Override
	protected String getReportFooter(List<Customer> customers) {
		// TODO Auto-generated method stub
		return "";
	}

}
