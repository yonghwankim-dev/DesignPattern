package chapter09_옵서버패턴.exercise.ex01_01;

public class Client {

	public static void main(String[] args) {
		Battery battery = new Battery();
		BatteryLevelDisplay batteryDisplay = new BatteryLevelDisplay(battery);
		LowBatteryWarning lowBatteryWarning = new LowBatteryWarning(battery);
		
		battery.setDisplay(batteryDisplay);
		battery.setWarning(lowBatteryWarning);

		battery.consume(30);
		battery.consume(30);
		battery.consume(30);
	}

}
