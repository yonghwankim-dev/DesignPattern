package chapter01_��ü����𵨸�.exercise.ex03;

/**
 * �� �ڵ�� �� ��ȭ�� �繫�� ��ȭ ������ ������ �̷�����Ƿ� setter�� getter �޼����
 * ��Ȳ�� �°� �ش� ��ȭ�⸦ ����� �� �ִ�.
 * @author ���ȯ
 *
 */
public class Person {
	private Phone homePhones;
	private Phone officePhone;
	
	
	public Phone getHomePhones() {
		return homePhones;
	}
	public void setHomePhones(Phone homePhones) {
		this.homePhones = homePhones;
	}
	public Phone getOfficePhone() {
		return officePhone;
	}
	public void setOfficePhone(Phone officePhone) {
		this.officePhone = officePhone;
	}
}
