package chapter03_SOLID¿øÄ¢.exercise.ex05;

public class NewPayLogic implements PayManager{

	@Override
	public int calculatePay(Employee employee) {
		// TODO Auto-generated method stub
		return 40000*employee.getWorkHours() + 45000*employee.getOverTimeHours();
	}
	

}
