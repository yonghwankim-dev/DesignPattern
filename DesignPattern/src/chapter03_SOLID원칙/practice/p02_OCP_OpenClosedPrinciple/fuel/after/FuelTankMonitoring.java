package chapter03_SOLID��Ģ.practice.p02_OCP_OpenClosedPrinciple.fuel.after;


public class FuelTankMonitoring {
	
	// ���� ��ũ �˻� �� ��� �߻�
	public void checkAndWarn() {
		if(checkFuelTank()){
			giveWarningSignal();
		}
	}
	
	// ���� ����� ����Ǵ� �޼����� ���� �����ڸ� protected ���� �����ڷ� ����
	
	// ���� ��ũ üũ
	protected boolean checkFuelTank()
	{
		return false;
	}
	// ����ȣ
	protected void giveWarningSignal()
	{
		
	}

}
