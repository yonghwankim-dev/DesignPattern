package chapter12_팩토리메서드패턴.exercise.ex02;

public class NormalState extends CarState {

	public NormalState(Car car) {
		super(car);
	}
	
	@Override
	public void speedUp(int targetSpeed) {
		// TODO Auto-generated method stub
		System.out.print("Speed:" + car.getSpeed());
		if(targetSpeed > car.getSpeed())
		{
			car.setSpeed(targetSpeed);
		}
		
		System.out.println(" ==> " + car.getSpeed());
	}

	@Override
	public void engineFailedDetected() {
		System.out.print("Speed:" + car.getSpeed());
		car.setSpeed(LimpState.LIMP_MODE_MAX_SPEED);
		System.out.println(" ==> " + car.getSpeed());
		car.setState(car.getLimpMode());
	}

	@Override
	public void engineRepaired() {
		// TODO Auto-generated method stub
		System.out.println("Unexpected Event");
	}

}
