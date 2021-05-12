package chapter01_객체지향모델링.exercise.ex03;

/**
 * 이 코드는 집 전화와 사무실 전화 각각에 참조가 이루어지므로 setter와 getter 메서드로
 * 상황에 맞게 해당 전화기를 사용할 수 있다.
 * @author 김용환
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
