package chapter12_팩토리메서드패턴.exercise.ex03;

public class CarStateFactory {
	public static CarState getState(CarStateID stateID, Car car)
	{
		CarState state = null;
		switch(stateID)
		{
		case NORMAL:
			state = NormalState.getInstance(car);
			break;
		case LIMP_MODE:
			state = LimpState.getInstance(car);
			break;
		}
		return state;
		
	}
}
