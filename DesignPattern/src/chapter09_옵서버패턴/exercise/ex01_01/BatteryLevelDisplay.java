package chapter09_�ɼ�������.exercise.ex01_01;

public class BatteryLevelDisplay {
	private Battery battery;
	
	public BatteryLevelDisplay(Battery battery) {
		this.battery = battery;
	}

	public void update() {
		// TODO Auto-generated method stub
		int level = battery.getLevel();
		System.out.println("Level: " + level);
	}
}
