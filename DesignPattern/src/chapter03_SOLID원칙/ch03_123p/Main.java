package chapter03_SOLID원칙.ch03_123p;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * 아래와 같은 문제점은 Kid 클래스가 Lego 클래스를 가지고 놀고 싶은데
		 * Kid 클래스는 Robot 객체를 필드로 가지고 있기 때문에 수정이 불가피하다.
		 * 이는 의존 역전 원칙(DIP)의 위반이 개방폐쇠원칙(OCP)의 위반을 초래한다.
		 */
		Robot t = new Robot();
		Kid k = new Kid();
		k.setToy(t);
		k.play();
	}

}
