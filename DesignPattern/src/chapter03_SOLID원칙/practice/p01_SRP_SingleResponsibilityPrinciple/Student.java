package chapter03_SOLID��Ģ.practice.p01_SRP_SingleResponsibilityPrinciple;

// �л� Ŭ������ ���� �ʹ��� ���� å���� ������ �ִ�.
public class Student {
	
	// �л� Ŭ������ �� �� �� �ִ°�
	public void getCourses() {
		
	}
	// �л� Ŭ������ �� �� �� �ִ°�
	public void addCourse(Course c) {
		
	}
	// �ٸ� Ŭ������ �� �� �� �ִ� ��
	public void save() {
		
	}
	// �ٸ� Ŭ������ �� �� �� �ִ� ��
	public Student load() {
		return null;
	}
	// �ٸ� Ŭ������ �� �� �� �ִ� ��
	public void printOnReportCard() {
		
	}
	// �ٸ� Ŭ������ �� �� �� �ִ� ��
	public void printOnAttendanceBook() {
		
	}
}

// �������
// 1. ���� Student Ŭ������ �ʹ��� ���� �۾��� �����ؾ� �Ѵ�.
// 2. ���� Student Ŭ������ �Ҵ�� å�� �߿��� ���� ���� �� �ִ� ���� ���������� �߰��ϰ� ��ȸ�ϴ� ���̴�.
// 3. �����ͺ��̽��� �л� ������ �����ϰ� DB�κ��� �д� ���̳� ����ǥ�� �⼮�ο� ����ϴ� ���� Student Ŭ������ �ƴ�
// �ٸ� Ŭ������ �� ���� �� �ִ� ������ ����.
// 4. ���� Student Ŭ�������� ���� ������ �߰��ϰ� ��ȸ�ϴ� å�Ӹ� �����ϵ��� �ϴ� ���� SRP(Single Responsibility Principle)
// �� ������ �����̴�.