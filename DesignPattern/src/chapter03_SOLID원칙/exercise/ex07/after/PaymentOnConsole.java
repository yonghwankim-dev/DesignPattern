package chapter03_SOLID??Ģ.exercise.ex07.after;

public class PaymentOnConsole extends PayrollManager{

	@Override
	protected void writePayment(int amount) {
		System.out.println(amount);
	}

}
