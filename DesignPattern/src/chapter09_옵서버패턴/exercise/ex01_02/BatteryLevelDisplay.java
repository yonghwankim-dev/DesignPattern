package chapter09_옵서버패턴.exercise.ex01_02;

public class BatteryLevelDisplay implements Observer{
	private Battery battery;
	
	public BatteryLevelDisplay(Battery battery) {
		this.battery = battery;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		int level = battery.getLevel();
		System.out.println("Level: " + level);
	}

}
