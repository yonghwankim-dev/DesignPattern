package chapter09_옵서버패턴.exercise.ex01_02;

public class LowBatteryWarning implements Observer{
	private static final int LOW_BATTERY = 30;
	private Battery battery;

	public LowBatteryWarning(Battery battery) {		
		this.battery = battery;
	}


	@Override
	public void update() {
		// TODO Auto-generated method stub
		int level = battery.getLevel();
		if(level<LOW_BATTERY)
		{
			System.out.println("<Warning> Low Battery: " + level + " Compared with " + LOW_BATTERY);
		}
	}
	
}
