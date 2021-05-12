package chapter03_SOLID원칙.practice.p02_OCP_OpenClosedPrinciple.fuel.after;


public class FuelTankMonitoring {
	
	// 연료 탱크 검사 후 경고 발생
	public void checkAndWarn() {
		if(checkFuelTank()){
			giveWarningSignal();
		}
	}
	
	// 행위 방식이 변경되는 메서드의 접근 제어자를 protected 접근 제어자로 변경
	
	// 연료 탱크 체크
	protected boolean checkFuelTank()
	{
		return false;
	}
	// 경고신호
	protected void giveWarningSignal()
	{
		
	}

}
