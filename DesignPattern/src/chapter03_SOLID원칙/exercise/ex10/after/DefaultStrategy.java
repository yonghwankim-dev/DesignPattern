package chapter03_SOLID��Ģ.exercise.ex10.after;

public class DefaultStrategy implements PayCalculationStrategy{

	@Override
	public int getPay(int workHours, int overtimeHours) {
		return 10*workHours + 15*overtimeHours;
	}


}
