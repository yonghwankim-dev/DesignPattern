package chapter03_SOLID��Ģ.ch03_114p;

public class FuelTankMonitoring {
	public void checkAndWarn() {
		//...
		
	
	}
	protected boolean checkFuelTank()	// default ���
	{
		// ...
		return false;
	}
	protected void giveWarningSignal()	// default ���
	{
		//...
	}

}

class FuelTankMonitoringWith extends FuelTankMonitoring{

	@Override
	protected boolean checkFuelTank() {
		// TODO Auto-generated method stub
		// ... X���
		return false;
	}

	@Override
	protected void giveWarningSignal() {
		// TODO Auto-generated method stub
		// return ... X���
	}
	
}
