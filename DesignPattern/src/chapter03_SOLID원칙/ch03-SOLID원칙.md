**3\. Solide 원칙**

-   단일 책임 원칙(SRP, Single Responsibility Principle)
-   개방-폐쇄 원칙(OCP, Open-Closed Principle)
-   리스코프 치환 원칙(LSP, Liskov Substituion Principle)
-   의존 역전 원칙(DIP, Dependency Inversion Principle)
-   인터페이스 분리 원칙(ISP, Interface Segregation Principle)

**3.1 단일 책임 원칙**

**3.1.1 책임의 의미**

**단일 책임 원칙(SRP, Single Responsibility Principle)이란?**

단일 책임 원칙이란 하나의 객체는 단 하나의 책임만을 가져야 한다는 의미

**책임의 기본 단위는 무엇인가?**

단일 책임 원칙에서 말하는 책임의 기본 단위는 객체를 의미

**책임이란 무엇인가?**

책임은 객체가 다른 객체보다 해야 하는 것을 잘 할 수 있는 것을 의미한다.

**책임의 예시**

예를 들어 Student 클래스의 책임이 다음과 같다고 가정한다.

```java
// 학생 클래스는 현재 너무나 많은 책임을 가지고 있다.
public class Student {
	
	// 학생 클래스가 잘 할 수 있는것
	public void getCourses() {
		
	}
	// 학생 클래스가 잘 할 수 있는것
	public void addCourse(Course c) {
		
	}
	// 다른 클래스가 잘 할 수 있는 것
	public void save() {
		
	}
	// 다른 클래스가 잘 할 수 있는 것
	public Student load() {
		return null;
	}
	// 다른 클래스가 잘 할 수 있는 것
	public void printOnReportCard() {
		
	}
	// 다른 클래스가 잘 할 수 있는 것
	public void printOnAttendanceBook() {
		
	}
}
```

위와 같이 Student 클래스는 너무나 많은 책임을  수행하고 있다.

**현재 Student 클래스에 할당된 책임 중에서 가장 잘할 수 있는 것은 수강 과목을 추가하고 조회하는 일이다.**

데이터베이스에 학생 정보를 저장하고 데이터베이스로부터 읽는 일이나 성적표와 출석부에 출력하는 일은 Student 클래스가 아닌 다른 클래스가 더 잘할 수 있는 여지가 많다.

**즉, Student 클래스에는 수강과목을 추가하고 조회하는 책임만 수행하도록 하는 것이 SRP(Single Responsibility Principle)을 따르는 설계이다.**

**3.1.2 변경**

단일 책임 원칙(SRP)와 같이 설계 원칙을 학습하는 이유는 예측하지 못한 변경사항이 발생하더라도 유연하고 확장성이 있도록 시스템 구조를 설계하기 위해서이다.

좋은 설계란 기본적으로 시스템에 새로운 요구사항이나 변경이 있을 때 가능한 한 영향 받는 부분을 줄여야 한다.

가령 어떤 클래스가 잘 설계되었는 지를 판단하려면 언제 변경되어야 하는지를 물어보는 것이 좋다.

예를 들어 "Student 클래스는 언제 변경되어야 하는가?"에 대한 질문으로 Student 클래스의 변경 이유를 찾아보는 것이 좋다. 이유는 다음과 같다.

-   데이터베이스의 스키가마 변경되면 Student 클래스도 변경되어야 하는가?
-   학생이 지도 교수를 찾는 기능이 추가되어야 한다면 Student 클래스는 영향을 받는가?
-   학생 정보를 성적표와 출석부 이외의 형식으로 출력해야 한다면 어떻게 해야 하는가?

위와 같이 책임을 많이 질수록 클래스 내부에서 서로 다른 역할을 수행하는 코드끼리 강하게 결합될 가능성이 높아진다.

![](https://github.com/yonghwankim-dev/DesignPattern/blob/master/DesignPattern/src/chapter03_SOLID%EC%9B%90%EC%B9%99/diagram/01_side-effect.png)

**3.1.3 책임 분리**

위의 예제에서 Student 클래스는 여러 책임을 수행하므로 Student 클래스의 도움을 필요로 하는 코드도 많을 수 밖에 없다.

Student 클래스를 사용하는 다른 클래스

-   수강 과목
-   신입생 정보 기록
-   성적표 및 출석표 출력

위와 같이 다른 클래스 때문에 Student 클래스에 변경사항이 생기면 Student 클래스를 사용하는 코드와 전혀 관계가 없더라도 직접 또는 간접적으로 사용하는 모든 코드를 다시 테스트 해야 한다. 위와 같은 상황으로 인해서 **회귀 테스트**가 발생한다.

**회귀 테스트(Regression Test)란 무엇인가?**

-   회귀 테스트란 시스템에 변경이 발생 시 기존의 기능에 영향을 주는지를 평가하는 테스트이다.

**회귀 테스트 해결 방법**

-   회귀 테스트 비용을 줄이는 방법 중 하나는 시스템에 변경사항이 발생 시 영향을 받는 부분을 적게 하는 것이다.
-   즉, **책임 분리**를 수행하면 해결된다.

**책임 분리란 무엇인가?**

모든 코드를 테스트하는 문제를 해결하려면 하나의 클래스에 너무 많은 책임을 부여 하지 말고 단 하나의 책임만 수행하도록 하여 변경 사유가 될 수 있는 것을 하나로 만들어야 한다는 의미이다.

**Student 클래스의 개선된 디자인**

Student 클래스의 변경 사유가 될 수 있는 것

-   학생의 고유 정보
-   데이터베이스 스키마
-   출력 형식의 변화

1\. Student 클래스는 학생 고유의 역할을 수행하게끔 변경한다.

2\. Student 클래스의 인스턴스는 데이터베이스를 저장하거나 읽어들이는 역할을 담당하는 학생 DAO(Data Access Object) 클래스로 분리한다.

3\. 출석부와 성적표의 출력을 담당하는 기능은 출석부 클래스와 성적표 클래스로 분리한다.

위와 같이 클래스들이 책임을 적절하게 분담하도록 변경하면 어떤 변화가 발생 시 영향을 최소화 할 수 있다.

예를 들어 데이터베이스 스키마가 변화되면 학생 DAO 클래스나 이를 사용하는 클래스만이 영향을 받는다.

![](https://github.com/yonghwankim-dev/DesignPattern/blob/master/DesignPattern/src/chapter03_SOLID%EC%9B%90%EC%B9%99/diagram/02_studentDAO.png)

3.1.4 산탄총 수술

**산탄총 수술이란 무엇인가?**

-   하나의 책임이 여러 개의 클래스들로 분산되어 있는 경우를 의미한다.
-   따라서 여러 개의 클래스를 전부 수정하지 않으면 에러가 발생한다.
-   대표적인 예로 로깅, 보안, 트랜잭션과 같은 횡단 관심(Cross-Cutting Concern)이 존재한다.

**횡단 관심이란 무엇인가?**

-   시스템의 핵심 기능(하나의 책임) 안에 포함되는 부가 기능(여러 개의 클래스로 분리)이다.
-   부가 기능에 변경 사항이 발생하면 부가 기능을 실행하는 모든 핵심 기능에도 변경 사항이 적용되어야 한다는 의미이다.

![](https://github.com/yonghwankim-dev/DesignPattern/blob/master/DesignPattern/src/chapter03_SOLID%EC%9B%90%EC%B9%99/diagram/03_CrossCuttingConcern.png)

**3.1.5 관심지향 프로그래밍과 횡단 관심 문제**

횡단 관심 문제(Cross-Cutting Concern)를 해결하는 방법으로 **관심 지향 프로그래밍(AOP, Aspect-Oriented Programming)** 기법이 존재한다.

**관심지향 프로그래밍(AOP, Aspect-Oriented Programming)이란 무엇인가?**

-   관심지향 프로그래밍은 횡단 관심을 수행하는 코드를 애스펙트(Aspect)라는 특별한 객체로 모듈화하고 위빙(Weaving)이라는 작업을 통해 모듈화한 코드를 핵심 기능에 끼워 넣을 수 있다.
-   애스펙트(Aspect)와 위빙(Weaving) 작업을 통해 기존의 코드를 전혀 변경하지 않고도 시스템 핵심 기능에서 필요한 부가 기능을 효과적으로 이용 가능하다.
-   횡단 관심에 변경이 생기면 해당 애스펙트만 수정하면 된다.

**3.2 개방-폐쇄 원칙(Open-Closed Principle)**

-   기존 코드를 변경하지 않으면서 기능을 추가할 수 있도록 설계하는 학습 설계 원칙

아래의 그림은 성적표나 출석부에 학생의 성적이나 출석 기록을 출력하는 기능에 대한 설계도이다.

![](https://github.com/yonghwankim-dev/DesignPattern/blob/master/DesignPattern/src/chapter03_SOLID%EC%9B%90%EC%B9%99/diagram/04_OpenClosedPrinciple.png)

위와 같은 설계에서 도서관 대여 명부와 같은 새로운 매체에 학생의 대여 기록을 출력하는 경우라면 어떻게 처리해야 하는가?

-   간단한 방식으로 도서관 대여 명부 클래스를 생성 후 SomeClient 클래스가 이 기능을 사용하도록 할 수 있다. 그러나 이와 같은 방식은 OCP(Open-Closed Principle)을 위반한다. 왜냐하면 새로운 기능을 추가하려고 SomeClient 클래스를 수정해야 하기 때문이다.

위와 같은 추가적인 기능은 다음과 같이 대여 기록을 출력하는 매체(도서관 대여 명부 클래스)가 아래와 같이 변경되어야 한다.

![](https://github.com/yonghwankim-dev/DesignPattern/blob/master/DesignPattern/src/chapter03_SOLID%EC%9B%90%EC%B9%99/diagram/05_OpenClosedPrinciple2.png)

위의 그림과 같이 새로운 출력 매체를 표현하는 인터페이스(printSutdnet)를 추가하게 하고 변경이 있더라도 SomeClient 클래스가 개별적인 클래스(성적표, 도서관 대여 명부, 출석표)를 처리하도록 하지 않고 위의 그림처럼 인터페이스에서 구체적인 출력 매체를 캡슐화해 처리하도록 한다.

**개방-폐쇄 원칙(OCP, Open-Closed Principle)의 핵심 구조**

![](https://github.com/yonghwankim-dev/DesignPattern/blob/master/DesignPattern/src/chapter03_SOLID%EC%9B%90%EC%B9%99/diagram/06_OpenClosedPrinciple3.png)

**3.3 리스코프 치환 원칙(LSP, Liskov Substituion Principle)**

**리스코프 치환 원칙이란 무엇인가?**

리스코프 치환 원칙이란 일반화 관계에 대한 이야기며 자식 클래스는 최소한 자신의 부모 클래스에게 가능한 행위 수행할 수 있어야 한다는 의미이다.

**리스코프 치환 원칙의 예시**

아래의 Bag 클래스는 가격을 설정하고 조회하는 성능을 가진다. 

```java
public class Bag {
	private int price;

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}

```

여기서 가격은 설정된 가격 그대로 조회된다. 이를 좀 더 형식으로 작성하면 다음과 같다.

\[객체.메서드(인자리스트)\]는 메서드가 실행된 후의 b객체를 나타낸다.

```java
// 모든 Bag 객체 b의 모든 정수 값 p에 대해서
[b.setPrice(p)].getPrice() == p
```

그런데 Bag 클래스의 행위(getPrice, setPrice)를 손상하지 않고 일관성 있게 실행하는 클래스를 만들려면 어떻게 해야 하는가?

-   가장 직접적이고 직관적인 방법은 **슈퍼 클래스에서 상속 받은 메서드들이 서브 클래스에 오버라이드 되지 않아 재정의 되지 않도록 하는 것이다.**

아래 코드는 Bag 클래스를 상속받아 가방 가격을 할인 받을 수 있게 하는 DiscountBag 클래스이다.

```java
public class DiscountBag extends Bag{
	private double discountedBag = 0;

	public void setDiscountedBag(double discountedBag) {
		this.discountedBag = discountedBag;
	}
	
	public void applyDiscount(int price){
		super.setPrice(price - (int)(discountedBag*price));
	}
}

```

DiscountBag 클래스는 할인율을 설정해서 할인된 가격을 계산하는 기능이 추가되었다.

**기존의 Bag 클래스에 있떤 가격을 설정하고 조회하는 기능은 변경 없이 그대로 상속받았음을 알 수 있다.**

**이는 현재의 DiscountBag 클래스와 Bag 클래스의 상속관계가 리스코프 치환 원칙(LSP)를 위반하지 않았음을 알 수 있다.  
**

**리스코프 치환 원칙의 핵심**

-   서브 클래스가 슈퍼 클래스의 책임을 무시하거나 재정의하지 않고 확장만을 수행하는 것
-   **즉, 슈퍼 클래스의 메서드를 오버라이드 하지 않는다.**

**3.4 의존 역전 원칙(DIP, Dependency Inversion Principle)**

**의존 역전 원칙이란 무엇인가?**

의존 관계를 맺을때 변화하기 쉬운 것 또는 자주 변화하는 것보다는 변화하기 어려운 것 또는 거의 변화가 없는 것에 의존하라는 학습 설계 원칙이다.

**변화가 없는 것이란 무엇인가?**

-   정책, 전략과 같은 어떤 큰 흐름이나 개념같은 추상적인 것은 변화가 없다.
-   구체적인 방식, 사물 등과 같은 것은 변화하기 쉬운것이다.
-   예를 들어 자바에서는 인터페이스 또는 추상 클래스가 변화가 없는 것에 해당된다.

**변화가 없는 것의 예시**

아이가 장난감을 가지고 논다고 가정한다. 그 아이는 어떤 경우에는 로봇 장난감을 가지고 놀고 어떤 경우에는 레고 장난감을 가지고 놀것이다.

위와 같은 가정으로 인하여 로봇, 모형 자동차, 레고와 같은 구체적인 장난감은 변하기 쉬운 것이고, 아이가 장난감을 가지고 노는 사실은 변하기 어려운 것에 해당될 수 있다.

![](https://github.com/yonghwankim-dev/DesignPattern/blob/master/DesignPattern/src/chapter03_SOLID%EC%9B%90%EC%B9%99/diagram/07_DIP.png)

따라서 추상 클래스 및 인터페이스는 변화가 없는것이고 일반 클래스는 변화가 쉬운 것임을 알 수 있다.

**위와 같은 예를 통하여 의존 역전 원칙(DIP)을 만족하면 의존성 주입(Dependency Injection)이라는 기술로 변화를 쉽게 수용할 수 있는 코드를 작성할 수 있다.**

**의존성 주입(DI, Dependency Injection)이란 무엇인가?**

의존성 주입이란 클래스 외부에서 의존되는 것을 대상 객체의 인스턴스 변수에 주입하는 기술이다.

**의존성 주입의 예시**

**의존성 주입 BEFORE**

```java
public class Kid {
	private Robot toy;
	
	public void setToy(Robot toy)
	{
		this.toy = toy;
	}
	
	public void play()
	{
		System.out.println(toy.toString());
	}
}

```

Kid 클래스는 play() 메서드를 통해서 장난감을 가지고 논다. 이때 주목할 점은 Kid 클래스의 필드멤버로 Robot 클래스를 갖는다는 점이다.

문제점은 Kid 클래스가 Lego를 가지고 싶을 경우 Kid 클래스의 내용을 수정해야 하는 문제점을 갖고 있다.

**의존성 주입 AFTER**

```java
public abstract class Toy {
	public abstract String toString();
}

```

```java
public class Lego extends Toy{

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Lego";
	}

}

```

```java
public class Kid {
	private Toy toy;
	
	public void setToy(Toy toy)
	{
		this.toy = toy;
	}
	
	public void play()
	{
		System.out.println(toy.toString());
	}
}

```

위와 같이 Toy라는 추상 클래스를 정의하고 자식 클래스로 Lego 클래스와 Robot 클래스(Lego 클래스와 구조 동일)를 정의한다. 따라서 Kid 클래스가 setToy 메소드를 통해서 Lego 인스턴스 또는 Robot 인스턴스를 인자로 받아도 의존성 주입을 통해서 toy 필드 멤버에 저장이 가능하고 play() 메서드를 통해서 출력문을 수행할 수 있다.

정리하면 의존 역전 원칙을 만족하면 의존성 주입 기술을 통하여 추가적인 기능이 발생하여도 코드의 내용을 변경하지 않아도 된다.

**3.5 인터페이스 분리 원칙(ISP, Interface Segregation Principle)**

**인터페이스 분리 원칙이란 무엇인가?**

객체 지향 설계 원칙에서는 클라이언트 자신이 이용하지 않는 기능에는 영향을 받지 않아야 한다.

즉, 인터페이스 분리 원칙은 인터페이스를 클라이언트에 특화되도록 분리시키는 원칙이다.

**인터페이스 분리 원칙의 예시**

아래와 같이 프린터, 팩스, 복사기 기능이 모두 포함된 복합기 클래스가 있다고 가정한다.

그리고 복합기 클래스를 필드멤버로 갖고 기능을 수행하는 클라이언 클래스(프린터, 복사, 팩스 클라이언트)가 존재한다고 가정한다.

![](https://github.com/yonghwankim-dev/DesignPattern/blob/master/DesignPattern/src/chapter03_SOLID%EC%9B%90%EC%B9%99/diagram/08_ISP.png)

위의 그림과 같은 복합기 클래스는 매우 비대해질 가능성이 크다. 왜냐하면 복합기라는 클래스 하나에 수 많은 기능이 추가될 수 있기 때문이다. 하지만 복합기 클래스는 모든 기능을 클라이언트가 동시에 사용하는 경우는 거의 없다. **즉, 프린터 클라이언트는 팩스 클라이언트의 변경으로 인해 영향을 받지 않아야 한다.**

위의 문제를 해결하기 위해서는 범용의 인터페이스보다는 클라이언트에 특화된 인터페이스를 사용해야 한다.

따라서 인터페이스 분리 원칙은 인터페이스를 클라이언트에 특화되도록 분리시키는 설계 원칙이다.

**복합기 클래스에 인터페이스 분리 원칙 적용 결과**

![](https://github.com/yonghwankim-dev/DesignPattern/blob/master/DesignPattern/src/chapter03_SOLID%EC%9B%90%EC%B9%99/diagram/08_ISP2.png)

위와 같이 설계하면 인터페이스가 일종의 방화벽 역할을 수행하여 클라이언트는 자신이 사용하지 않는 메서드에 생긴 변화로 인한 영향을 받지 않는다.

**단일 책임 원칙(SRP, Single Responsibility Principle)과 인터페이스 분리 원칙(ISP, Interface Segregation Principle)간의 관계**

비대한 클래스를 단일 책임 원칙에 따라 단일 책임을 갖는 여러 클래스들로 분할하고 각자의 인터페이스를 제공한다면 인터페이스 분리 원칙(ISP)도 만족할 수 있다.

하지만 단일 책임 원칙(SRP)을 만족하더라도 인터페이스 분리 원칙(ISP)을 만족하지 못할 수 있다.

예를 들어 게시판 클래스가 존재하고 메소드는 게시글의 글쓰기, 읽기, 수정, 삭제와 같은 메서드가 제공된다고 가정한다.

하지만 일반 사용자는 게시판 삭제 기능이 없지만 관리자는 게시글 삭제가 가능하다. 이와 같은 경우 게시판 클래스는 게시판에 관련된 책임을 수행하므로 단일 책임 원칙(SRP)를 만족한다. 그러나 이 클래스에 모든 메서드가 들어 있는 인터페이스가 클라이언트에 상관없이 사용된다면 인터페이스 분리 원칙(ISP)에 위배된다.
