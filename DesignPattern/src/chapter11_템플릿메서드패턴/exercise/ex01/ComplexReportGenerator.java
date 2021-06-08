package chapter11_템플릿메서드패턴.exercise.ex01;

import java.util.List;

public class ComplexReportGenerator extends ReportGenerator{

	@Override
	protected boolean customerReportCondition(Customer customer) {
		// TODO Auto-generated method stub
		return customer.getPoint()>=100;
	}

	@Override
	protected String getReportHeader(List<Customer> customers) {
		// TODO Auto-generated method stub
		return String.format("고객 수: %d명입니다.\n", customers.size());
	}

	@Override
	protected String customerReportForCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return String.format("%d: %s\n", customer.getPoint(), customer.getName());
	}

	@Override
	protected String getReportFooter(List<Customer> customers) {
		// TODO Auto-generated method stub
		int sum=0;
		for(Customer c : customers)
		{
			sum += c.getPoint();
		}
		return String.format("점수 합계: %d\n", sum);

	}

}
