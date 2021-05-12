package chapter03_SOLID¿øÄ¢.exercise.ex05;

public class PayLogic3 implements PayManager{

	@Override
	public int calculatePay(Employee employee) {
		// TODO Auto-generated method stub
		return 30000*employee.getWorkHours() + 35000*employee.getOverTimeHours();
	}
	

}
