package chapter03_SOLID¿øÄ¢.exercise.ex07.before;

public class PayLogic2 implements PayManager{

	@Override
	public int calculatePay(Employee employee) {
		// TODO Auto-generated method stub
		return 20000*employee.getWorkHours() + 25000*employee.getOverTimeHours();
	}
	

}
