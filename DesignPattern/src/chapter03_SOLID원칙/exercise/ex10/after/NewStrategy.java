package chapter03_SOLID¿øÄ¢.exercise.ex10.after;

public class NewStrategy implements PayCalculationStrategy{

	@Override
	public int getPay(int workHours, int overtimeHours) {
		return 20*workHours + 30*overtimeHours;
	}


}
