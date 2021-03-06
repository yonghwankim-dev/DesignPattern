package chapter01_객체지향모델링.exercise.ex02;

/**
 * 이 코드는 집 전화와 사무실 전화를 배열의 인덱스를 통해 구분해야 하므로
 * 매우 불편하다. 이런 경우는 전화기의 역할을 구분해서 사용하면 해결 가능
 * 하다.
 * @author 김용환
 *
 */
public class Person {
	private Phone[] phones;

	public Person() 
	{
		this.phones = new Phone[2];
	}
	
	public Phone getPhone(int i)
	{
		if(i==0 || i==1)
		{
			return phones[i];	// i=0이면 집 전화, i=1이면 사무실 전화
		}
		return null;
	}
	
}
