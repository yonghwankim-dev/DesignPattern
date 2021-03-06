package chapter12_팩토리메서드패턴.exercise.ex02;

public class LimpState extends CarState {
	public static final int LIMP_MODE_MAX_SPEED = 60;
	
	public LimpState(Car car)
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
	
}
