package chapter03_SOLID원칙.ch03_114p;

public class FuelTankMonitoring {
	public void checkAndWarn() {
		//...
		
	
	}
	protected boolean checkFuelTank()	// default 방식
	{
		// ...
		return false;
	}
	protected void giveWarningSignal()	// default 방식
	{
		//...
	}

}

class FuelTankMonitoringWith extends FuelTankMonitoring{

	@Override
	protected boolean checkFuelTank() {
		// TODO Auto-generated method stub
		// ... X방식
		return false;
	}

	@Override
	protected void giveWarningSignal() {
		// TODO Auto-generated method stub
		// return ... X방식
	}
	
}
