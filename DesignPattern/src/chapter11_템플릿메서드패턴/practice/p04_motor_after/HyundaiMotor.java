package chapter11_템플릿메서드패턴.practice.p04_motor_after;



public class HyundaiMotor extends Motor{
	
	
	public HyundaiMotor(Door door) {
		super(door);
	}

	@Override
	protected void moveMotor(Direction direction) {
		// TODO Auto-generated method stub
		// HyundaiMotor를 구동시킴
	}	
}
