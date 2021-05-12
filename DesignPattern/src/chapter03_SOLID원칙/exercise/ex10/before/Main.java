package chapter03_SOLID원칙.exercise.ex10.before;

// Question
// 1. 다음 코드는 정상 작업시간(workHours 속성)과 잔업 시간(overTimeHours 속성)을
// 기반으로 임금을 계산하고 이를 출력하는 기능(calculatePay 메서드)을 제공한다.
// 2. 현재 설계의 문제점을 진단하고 설계를 개선하라.

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CalculatePayMachine machine = new CalculatePayMachine();
	}

}

// 문제점
// 1. GUI가 변경되는 경우 CalculatePayMachine 클래스를 변경해야 한다.
// 2. 계산 로직을 추가하고 싶을때 calcuatePay 메서드를 변경해야 한다.
// 3. 따라서 하나의 클래스는 하나의 변경 사유만 이었어야 한다는 SRP를 위반한다.

// 개선방안
// 1. SRP를 따르려면 2가지 변경 사유를 각기 다른 클래스에서 담당하도록 해야 한다.
// 2. GUI만을 담당하는 클래스와 입금을 계산하는 클래스로 분리한다.
// 3. PayGUI---------->PayCalculator
