package chapter12_팩토리메서드패턴.exercise.ex03;

public class LimpState extends CarState {
	public static final int LIMP_MODE_MAX_SPEED = 60;
	private static CarState state;	// 싱글턴 패턴 적용
	private LimpState(Car car)		// 싱글턴 패턴 적용
	{
		super(car);
	}
	
	@Override
	public void speedUp(int targetSpeed) {
		System.out.print("Speed:" + car.getSpeed());
		if(targetSpeed > car.getSpeed() && targetSpeed < LIMP_MODE_MAX_SPEED)
		{
			car.setSpeed(targetSpeed);
		}
		
		System.out.println(" ==> " + car.getSpeed());
	}

	@Override
	public void engineFailedDetected() {
		// TODO Auto-generated method stub
		System.out.print("Speed:" + car.getSpeed());
		car.setSpeed(LimpState.LIMP_MODE_MAX_SPEED);
		System.out.println(" ==> " + car.getSpeed());
		car.setState(car.getLimpMode());
	}

	@Override
	public void engineRepaired() {
		// TODO Auto-generated method stub
		car.setState(car.getNormalMode());
	}

	public static CarState getInstance(Car car) {
		// TODO Auto-generated method stub
		if(state==null)
		{
			state = new LimpState(car);
		}
		return state;
	}
	
}
