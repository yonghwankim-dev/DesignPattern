package chapter03_SOLID��Ģ.exercise.ex10.before;

// Question
// 1. ���� �ڵ�� ���� �۾��ð�(workHours �Ӽ�)�� �ܾ� �ð�(overTimeHours �Ӽ�)��
// ������� �ӱ��� ����ϰ� �̸� ����ϴ� ���(calculatePay �޼���)�� �����Ѵ�.
// 2. ���� ������ �������� �����ϰ� ���踦 �����϶�.

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CalculatePayMachine machine = new CalculatePayMachine();
	}

}

// ������
// 1. GUI�� ����Ǵ� ��� CalculatePayMachine Ŭ������ �����ؾ� �Ѵ�.
// 2. ��� ������ �߰��ϰ� ������ calcuatePay �޼��带 �����ؾ� �Ѵ�.
// 3. ���� �ϳ��� Ŭ������ �ϳ��� ���� ������ �̾���� �Ѵٴ� SRP�� �����Ѵ�.

// �������
// 1. SRP�� �������� 2���� ���� ������ ���� �ٸ� Ŭ�������� ����ϵ��� �ؾ� �Ѵ�.
// 2. GUI���� ����ϴ� Ŭ������ �Ա��� ����ϴ� Ŭ������ �и��Ѵ�.
// 3. PayGUI---------->PayCalculator
