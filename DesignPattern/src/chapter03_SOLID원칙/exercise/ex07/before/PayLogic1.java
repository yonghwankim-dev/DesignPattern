package chapter03_SOLID¿øÄ¢.exercise.ex07.before;

public class PayLogic1 implements PayManager{

	@Override
	public int calculatePay(Employee employee) {
		// TODO Auto-generated method stub
		return 10000*employee.getWorkHours() + 15000*employee.getOverTimeHours();
	}
	

}
