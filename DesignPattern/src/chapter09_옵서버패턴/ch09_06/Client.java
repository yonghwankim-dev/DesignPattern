package chapter09_옵서버패턴.ch09_06;

public class Client {

	public static void main(String[] args) {
		Battery battery = new Battery();
		BatteryLevelDisplay batteryDisplay = new BatteryLevelDisplay(battery);
		LowBatteryWarning lowBatteryWarning = new LowBatteryWarning(battery);
		
		battery.attach(batteryDisplay);
		battery.attach(lowBatteryWarning);

		battery.consume(30);
		battery.consume(30);
		battery.consume(30);
	}

}
