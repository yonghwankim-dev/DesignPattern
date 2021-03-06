package chapter03_SOLID원칙.practice.p02_OCP_OpenClosedPrinciple.fuel.before;

//Question
//로켓의 연료 탱크를 검사해 특정 조건에 맞지 않으면 관리자에게 경고 신호를 보내주는 기능이 있다.
//연료 탱크를 검사하는 방식과 경고를 보내는 방식이 변경될 가능성이 큰 경우에 대비해 다음 코드를 수정하라.
public class FuelTankMonitoring {
	
	// 연료 탱크 검사 후 경고 발생
	public void checkAndWarn() {
		if(checkFuelTank()){
			giveWarningSignal();
		}
	}
	
	// 연료 탱크 체크
	private boolean checkFuelTank()
	{
		return false;
	}
	// 경고신호
	private void giveWarningSignal()
	{
		
	}

}

// 변경점 파악
// 1. checkFuelTank 메서드와 giveWarningSignal 메서드의 구체적 행위 방식이 변경된다.
// 2. 새로운 행위 방식을 기존의 코드에 영향을 주지 않고 추가하려면 이 두 메서드를 개별 클래스에서 정의하도록 해야 한다.
// 3. checkFuelTank 메서드와 giveWarningSignal 메서드를 protected라는 접근 제어자를 사용해 변경하고
// 상속 관계를 이용해 자식 클래스의 새로운 방식의 메서드를 정의한다.