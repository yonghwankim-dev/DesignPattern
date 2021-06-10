### **13.1 추상 팩토리 패턴**

추상 팩토리 패턴은 관련성 있는 여러 종류의 객체를 일관된 방식으로 생성하는 경우에 유용하다. 밑에서 설명할 엘리베이터 예제에서 볼 수 있듯이 LG 부품을 위한 코드는 LG의 모터와 문을 이용할 것이다. 만약 현대 부품을 지원하도록 코드를 수정해야 한다면 모터와 문이 일관성 있게 LG에서 현대로 변경되어야 한다.

바로 이러한 경우에 부품별로 Factory를 정의하는 대신 관련 객체들을 일관성 있게 생성할 수 있도록 Factory 클래스를 정의하는 것이 효과적이다.

예를 들어 Motor 클래스를 위한 MotorFactory 클래스와 Door 클래스를 위한 DoorFactory 클래스를 정의하는 대신 LG 부품들을 위한 LGFactory 클래스와 현대 부품들을 위한 HyundaiFactory 클래스를 정의하는 것이 바람직하다.

> 추상 팩토리 패턴은 관련성 있는 여러 종류의 객체를 일관성 있는 방식으로 생성할 때 유용하다.

**추상 팩토리 패턴의 컬레보레이션**

![추상 팩토리 패턴의 컬레보레이션](https://github.com/yonghwankim-dev/DesignPattern/blob/master/DesignPattern/src/chapter13_%EC%B6%94%EC%83%81%ED%8C%A9%ED%86%A0%EB%A6%AC%ED%8C%A8%ED%84%B4/diagram/07_abstract-factory-pattern_collaboration.png)

-   **AbstractFactory** : 실제 팩토리 클래스의 공통 인터페이스, 각 제품의 부품을 생성하는 기능을 추상 메서드로 정의한다.
-   **ConcreteFactory** : 구체적인 팩토리 클래스로 AbstractFactory 클래스의 추상 메서드를 오버라이드함으로써 구체적인 제품을 생성한다.
-   **AbstractProduct** : 제품의 공통 인터페이스
-   **ConcreteProduct** : 구체적인 팩토리 클래스에서 생성되는 구체적인 제품

**추상 팩토리 패턴의 순차 다이어그램**

![추상 팩토리 패턴의 순차 다이어그램](https://github.com/yonghwankim-dev/DesignPattern/blob/master/DesignPattern/src/chapter13_%EC%B6%94%EC%83%81%ED%8C%A9%ED%86%A0%EB%A6%AC%ED%8C%A8%ED%84%B4/diagram/08_abstract-factory-pattern_seq.png)

1.  ConcreteFactory1 객체를 이용하여 createProductA 메소드 호출
2.  ConcreteProductA1 객체(a1) 생성
3.  ConcreteFactory1 객체를 이용하여 createProductB 메소드 호출
4.  ConcreateProductB1 객체(b1) 생성

Clinet 클래스는 ConcreteFactory1 클래스의 createProductA 메소드를 호출함으로써 ConcreteProductA1 객체 a1을 생성한다.

그러나 createProductA 메서드의 타입이 AbstractProductA이므로 Client 클래스는 AbstractProductA 클래스를 통해야만 ConcreteProductA1 객체에 접근 할 수 있다. 이렇게 하면 ConcreteFactory1 클래스가 아니라 ConcreteFactory2 클래스에 의해서 ConcreteProductA2 객체가 생성되어도 Client 클래스는 여전히 AbstractProductA 클래스를 통해 생성된 객체에 접근이 가능하다. 즉, **Client 클래스는 ConcreteFactory의 변화에 의해 영향을 받지 않을 수 있다.**

**추상 팩토리 패턴을 엘리베이터 부품 업체 에제에 적용한 경우**

![추상 팩토리 패턴을 엘리베이터 부품 업체 예제에 적용한 경우](https://github.com/yonghwankim-dev/DesignPattern/blob/master/DesignPattern/src/chapter13_%EC%B6%94%EC%83%81%ED%8C%A9%ED%86%A0%EB%A6%AC%ED%8C%A8%ED%84%B4/diagram/09_apply_abstract-factory-pattern_elevator.png)

-   ElevatorFactory 클래스 : AbstractFactory 역할
-   LGElevatorFactory, HyundaiElevatorFactory 클래스 : ConcreteFactory 역할
-   Door 클래스 : AbstractProductA 역할
-   LGDoor, HyundaiDoor 클래스 : ConcreteProductA 역할
-   Motor 클래스 : AbstractProductB 역할
-   LGMotor, HyundaiMotor 클래스 : ConcreteProductB 역할

### **13.2 엘리베이터 부품 업체 변경하기**

엘리베이터를 구성하는 많은 부품 중에서 모터와 문이 존재한다. 엘리베이터 제조 업체가 여러 군데라면 각 제조 업체별로 부품을 개발할 것이다. 예를 들어 LG는 LG모터와 LG문을 제공하고 현대는 현대 모터와 현대 문을 제공할 것이다.

엘리베이터만 생각하면 여러 제조 업체의 부품을 사용하더라도 같은 동작을 지원하게 하는 것이 바람직하다. 예를 들어 건물 A에서는 LG의 부품이 사용되고, 건물 B에서는 현대의 부품이 사용되더라도 엘리베이터 프로그램의 변경을 최소화할 필요가 있다.

우선 LG의 모터와 현대 모터는 구체적인 제어 방식은 다르지만 엘리베이터 입장에서는 모터를 구동해 엘리베이터를 이동시킨다는 면에서는 동일하다. 그러므로 추상 클래스로 Motor 클래스를 정의하고 LGMotor와 HyundaiMotor를 하위 클래스로 정의할 수 있다. 마찬가지로 LGDoor와 HyundaiDoor를 Door 상위 클래스의 하위 클래스로 정의할 수 있다.

**LG와 현대의 모터와 문**

![LG와 현대의 모터와 문](https://github.com/yonghwankim-dev/DesignPattern/blob/master/DesignPattern/src/chapter13_%EC%B6%94%EC%83%81%ED%8C%A9%ED%86%A0%EB%A6%AC%ED%8C%A8%ED%84%B4/diagram/01_LG-Hyundai_Motor.png)

**Motor의 핵심 기능 move 기능**

```java
public void move(Direction direction){
    // 1) 이미 이동 중이면 무시한다.
    // 2) 만약 문이 열려 있으면 문을 닫는다.
    // 3) 모터를 구동해서 이동시킨다.
    // 4) 모터의 상태를 이동 중으로 설정한다.
}
```

위의 4단계는 LGMotor와 HyundaiMotor 클래스에서 모두 동일한다. 하지만 '3) 모터를 구동해서 이동시킨다.' 부분만 LGMotor와 HyundaiMotor에서 달라진다. 이와 같이 **일반적인 흐름에서는 동일하지만 특정 부분만 다른 동작을 하는 경우에는 일반적인 기능을 상위 클래스에 템플릿 메서드로서 설계할 수 있다.**

**Door의 핵심 기능 open 기능**

```java
public void open(){
    // 1) 이미 문이 열려 있으면 무시한다.
    // 2) 문을 닫는다.
    // 3) 문의 상태를 '닫힘'으로 설정한다.
}
```

Door 클래스의 경우에도 open과 close 메서드 각각에 템플릿 메서드 패턴을 적용할 수 있다. open 메소드에서 다른 부분은 '2) 문을 닫는다.' 부분이다.

**템플릿 메서드 패턴을 적용한 Door, LGDoor, HyundaiDoor 클래스의 코드 구현**

```java
public enum DoorStatus {
	OPENED,CLOSED
}

public abstract class Door {
	private DoorStatus doorStatus;
	
	public Door()
	{
		doorStatus = DoorStatus.CLOSED;
	}
	
	public DoorStatus getDoorStatus()
	{
		return doorStatus;
	}
	
	public void close()	// 템플릿 메서드 
	{	
		if(doorStatus==DoorStatus.CLOSED)	// 이미 문이 닫혀 있으면 아무런 동작을 하지 않음.
		{
			return;
		}
		
		doClose();	// 실제 문을 닫는 동작을 수행함, 하위 클래스에서 오바리드 될 것임
		doorStatus = DoorStatus.CLOSED;	// 문의 상태를 닫힘으로 기록함.
	}
	
	protected abstract void doClose();	// primitive 또는 hook 메서드

	public void open()
	{
		if(doorStatus==DoorStatus.OPENED)	// 이미 문이 열려 있으면 아무 동작을 하지 않음.
		{
			return;
		}
		
		doOpen();	// 실제 문을 여는 동작을 수행함. 하위 클래스에서 오버라이드 될 것임
		doorStatus = DoorStatus.OPENED;	// 문의 상태를 열림으로 기록함
	}

	protected abstract void doOpen();	// primitive 또는 hook 메서드
}

```

```java
public class LGDoor extends Door{

	@Override
	protected void doClose() {
		// TODO Auto-generated method stub
		System.out.println("close LG Door");
	}

	@Override
	protected void doOpen() {
		// TODO Auto-generated method stub
		System.out.println("open LG Door");
	}
	
}
```

```java
public class HyundaiDoor extends Door{

	@Override
	protected void doClose() {
		// TODO Auto-generated method stub
		System.out.println("close Hyundai Door");
	}

	@Override
	protected void doOpen() {
		// TODO Auto-generated method stub
		System.out.println("open Hyudani Door");
	}
	
}

```

또한 엘리베이터 입장에서는 특정 제조 업체의 모터와 문을 제정하는 클래스가 필요하다. 에를 들면 LGMotor 객체와 LGDoor 객체가 필요하다. 이러한 경우 팩토리 메서드 패턴을 적용할 수 있다. 즉, MotorFactory 클래스를 정의해 LGMotor와 HyundaiMotor 중에서 특정 제조 업체에 따라 해당 Motor 객체를 생성할 수 있다.

**모터 객체 생성을 위한 MotorFactory 클래스**

![모터 객체 생성을 위한 MotorFactory 클래스](https://github.com/yonghwankim-dev/DesignPattern/blob/master/DesignPattern/src/chapter13_%EC%B6%94%EC%83%81%ED%8C%A9%ED%86%A0%EB%A6%AC%ED%8C%A8%ED%84%B4/diagram/02_motorFactory.png)

MotorFactory 클래스의 createMotor 메소드는 VendorID 인자값에 따라 LGMotor 객체 또는 HyundaiMotor 객체를 생성한다.

**모터 객체 생성을 위한 MotorFactory 클래스 구현**

```java
public enum VendorID {
	LG, HYUNDAI
}

public class MotorFactory {
	// vendorID에 따라 LGMotor 또는 HyundaiMotor 객체를 생성함
	public static Motor createMotor(VendorID vendorID)
	{
		Motor motor = null;
		switch(vendorID)
		{
		case LG:
			motor = new LGMotor();
			break;
		case HYUNDAI:
			motor = new HyundaiMotor();
			break;
		}
		return motor;
		
	}
}
```

```java
public class DoorFactory {
	// vendorID에 따라 LGMotor 또는 HyundaiMotor 객체를 생성함
	public static Door createMotor(VendorID vendorID)
	{
		Door door = null;
		switch(vendorID)
		{
		case LG:
			door = new LGDoor();
			break;
		case HYUNDAI:
			door = new HyundaiDoor();
			break;
		}
		
		return door;
		
	}
}
```

```java
public class Client {
	public static void main(String args[])
	{
		Door lgDoor = DoorFactory.createMotor(VendorID.LG);
		Motor lgMotor = MotorFactory.createMotor(VendorID.LG);
		
		lgMotor.setDoor(lgDoor);
		lgDoor.open();
		lgMotor.move(Direction.UP);
	}
}
```

```java
open LG Door
close LG Door
move LG Motor UP
```

### **13.3 문제점**

-   현재 코드는 LG의 부품(LGMotor와 LGDoor 클래스)을 사용한다. 만약 다른 제조 업체의 부품을 사용해야 한다면? 에를 들어 LG의 부품 대신 현대의 부품(HyundaiMotor와 HyundaiDoor 클래스)을 사용해야 한다면?
-   게다가 새로운 제조 업체의 부품을 지원해야 한다면? 예를 들어 삼성에서 엘리베이터 부품을 생산하기 시작해 삼성의 부품(SamsungMotor와 SamsungDoor 클래스)을 지원해야 한다면?

**13.3.1 다른 제조 업체의 부품을 사용해야 하는 경우**

엘리베이터 프로그램에서 현대의 부품, 즉, HyundaiMotor와 HyundaiDoor 객체를 사용하려면 MotorFactory와 DoorFactory 클래스를 이용하여 이미 정의된 HyundaiMotor 객체와 HyundaiDoor 객체를 생성하도록 프로그램을 수정한다.

```java
public class Client {
	public static void main(String args[])
	{
		Door hyundaiDoor = DoorFactory.createMotor(VendorID.HYUNDAI);
		Motor hyundaiMotor = MotorFactory.createMotor(VendorID.HYUNDAI);
		
		hyundaiMotor.setDoor(hyundaiDoor);
		hyundaiDoor.open();
		hyundaiMotor.move(Direction.UP);
	}
}
```

위와 같이 다른 제조 업체의 부품을 사용해야 하는 경우 코드를 수정해야 하는 문제점이 존재한다. 부품의 종류가 많아지면 많아질수록 각각의 Factory 클래스를 구현해야하고 이들의 Factory 객체를 각각 생성해야 한다.

**13.3.2 새로운 제조 업체의 부품을 지원해야 하는 경우ㅇ**

```java
public class DoorFactory {
	// vendorID에 따라 LGMotor 또는 HyundaiMotor 객체를 생성함
	public static Door createMotor(VendorID vendorID)
	{
		Door door = null;
		switch(vendorID)
		{
		case LG:
			door = new LGDoor();
			break;
		case HYUNDAI:
			door = new HyundaiDoor();
			break;
		case SAMSUNG:
			door = new SamsungDoor();
			break;
		}
		
		return door;
		
	}
}

```

결과적으로 기존의 팩토리 메서드 패턴을 이용한 객체 생성은 관련 있는 여러 개의 객체를 일관성 있는 방식으로 생성하는 경우에 많은 코드 변경이 발생하게 되는 문제점을 가지고 있다.

### **13.4 해결책**

위와 같은 문제점을 해결하기 위해서는 여러 종류의 객체를 생성할 대 객체들 사이의 관련성이 있는 경우라면 각 종류별로 별도의 Factory 클래스를 사용하는 대신 관련 객체들을 일관성 있게 생성하는 Factory 클래스를 사용하는 것이 편리할 수 있다.

예를 들어 엘리베이터 프로그램의 경우 MotorFactory, DoorFactory 클래스와 같이 부품별로 Factory 클래스를 만드는 대신 LGElevatorFactory나 HyundaiElevatorFactory 클래스와 같이 제조 업체별로 Factory 클래스를 만들 수도 있다.

-   LGElevatorFactory : LGMotor, LGDoor 객체를 생성하는 팩토리 클래스
-   HyundaiElevatorFactory : HyundaiMotor, HyundaiDoor 객체를 생성하는 팩토리 클래스

**LGElevatorFactory와 HyundaiElevatorFactory 클래스를 이용한 설계**

![LGElevatorFactory와 HyundaiElevatorFactory 클래스를 이용한 설계](https://github.com/yonghwankim-dev/DesignPattern/blob/master/DesignPattern/src/chapter13_%EC%B6%94%EC%83%81%ED%8C%A9%ED%86%A0%EB%A6%AC%ED%8C%A8%ED%84%B4/diagram/03_ElevatorFactory.png)

-   LGElevatorFactory : createMotor, createDoor 메소드를 통하여 LGMotor, LGDoor 객체 생성
-   HyundaiElevatorFactory : createMotor, createDoor 메소드를 통하여 HyundaiMotor, HyundaiDoor 객체 생성

위의 그림과 같이 LGElevatorFactory 클래스와 HyundaiElevatorFactory 클래스는 동일한 이름의 createMotor, createDoor 메소드를 가지고 있다. 따라서 ElevatorFactory 클래스를 일반화한 상위 클래스를 정의할 수 있다.

**LGElevatorFactory와 HyundaiElevatorFactory 클래스의 일반화**

![LGElevatorFactory와 HyundaiElevatorFactory 클래스의 일반화](https://github.com/yonghwankim-dev/DesignPattern/blob/master/DesignPattern/src/chapter13_%EC%B6%94%EC%83%81%ED%8C%A9%ED%86%A0%EB%A6%AC%ED%8C%A8%ED%84%B4/diagram/04_ElevatorFactory_generalization.png)

**LGElevatorFactory와 HyundaiElevatorFactory 클래스의 일반화 구현**

```java
public abstract class ElevatorFactory {	// 추상 부품을 생성하는 추상 팩토리
	public abstract Motor createMotor();
	public abstract Door createDoor();
}
```

```java
public class LGElevatorFactory extends ElevatorFactory{

	@Override
	public Motor createMotor() {
		// TODO Auto-generated method stub
		return new LGMotor();
	}

	@Override
	public Door createDoor() {
		// TODO Auto-generated method stub
		return new LGDoor();
	}

}
```

```java
public class HyundaiElevatorFactory extends ElevatorFactory{

	@Override
	public Motor createMotor() {
		// TODO Auto-generated method stub
		return new HyundaiMotor();
	}

	@Override
	public Door createDoor() {
		// TODO Auto-generated method stub
		return new HyundaiDoor();
	}

}

```

```java
public class Client {
	public static void main(String args[])
	{
		ElevatorFactory factory = null;
		String vendorName = args[0];
		if(vendorName.equalsIgnoreCase("LG"))	// 인자에 따라 LG 또는 현대 팩토리를 생성함
		{
			factory = new LGElevatorFactory();
		}
		else
		{
			factory = new HyundaiElevatorFactory();
		}
		
		Door door = factory.createDoor();
		Motor motor = factory.createMotor();
		motor.setDoor(door);
		
		door.open();
		motor.move(Direction.UP);
	}
}

```

인자로 주어진 업체 이름에 다라 적절한 부품 객체를 생성한다. 즉, LG의 부품을 이용하든 현대의 부품을 이용하든 이제 이 코드는 변경할 필요가 없다.

그리고 몇 가지 살펴봐야 할 부분이 존재한다. Client 클래스는 특정 제조 업체에 따라 적절한 Factory 클래스가 생성된 후에는 이 Factory 클래스를 이용해 구체적인 부품을 생성(createDoor, createMotor)한다. 이때 제조 업체별로 Factory 클래스를 생성하는 부분은 팩토리 메서드 패턴을 적용해 설계한 것이다. 즉, 구체적인 Factory 클래스를 생성하는 팩토리 메서드를 사용함으로써 제조 업체별 Factory 객체를 생성하는 방식을 캡슐화 할 수 있다.

```java
if(vendorName.equalsIgnoreCase("LG"))	// 인자에 따라 LG 또는 현대 팩토리를 생성함
{
	factory = new LGElevatorFactory();
}
else if(vendorName.equalsIgnoreCase("Samsung"))	// 삼성 부품을 생성하는 삼성 팩토리를 이용함
{
	factory = new SamsungElevatorFactory();
}
else
{
	factory = new HyundaiElevatorFactory();
}
```

위의 그림과 같이 제조 업체별 Factory 객체는 각각 1개만 있으면 된다. 즉, LGElevatorFactory, HyundaiElevatorFactory, SamsungElevatorFactory 클래스는 싱글턴 패턴으로 설계할 필요가 있다.

**팩토리 메서드와 싱글턴 패턴을 적용한 제조 업체별 Factory 클래스 다이어그램**

![팩토리 메서드와 싱글턴 패턴을 적용한 제조 업체별 Factory 클래스 다이어그램](https://github.com/yonghwankim-dev/DesignPattern/blob/master/DesignPattern/src/chapter13_%EC%B6%94%EC%83%81%ED%8C%A9%ED%86%A0%EB%A6%AC%ED%8C%A8%ED%84%B4/diagram/06_factory-method_singleton-patterns.png)

ElevatorFactoryFactory 클래스가 getFactory가 팩토리 메서드 역할을 한다. 그리고 각 제조 업체별 Factory 클래스는 싱글턴 패턴으로 설계한다.

**팩토리 메서드와 싱글턴 패턴을 적용한 제조 업체별 Factory 클래스 다이어그램 구현**

```java
public class ElevatorFactoryFactory {	// 팩토리 클래스에 팩토리 메서드 패턴을 적용함
	public static ElevatorFactory getFactory(VendorID vendorID)
	{
		ElevatorFactory factory = null;
		
		switch(vendorID)
		{
		case LG:
			factory = LGElevatorFactory.getInstance();	// LG 팩토리의 생성
			break;
		case HYUNDAI:
			factory = HyundaiElevatorFactory.getInstance();	// 현대 팩토리의 생성
			break;
		case SAMSUNG:
			factory = SamsungElevatorFactory.getInstance();	// 삼성 팩토리의 생성
			break;
		
		}
		return factory;
	}

}
```

```java
public class LGElevatorFactory extends ElevatorFactory{
	private static LGElevatorFactory factory;
	
	private LGElevatorFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static ElevatorFactory getInstance()
	{
		if(factory==null)
		{
			factory = new LGElevatorFactory();
		}
		return factory;
	}
	
	@Override
	public Motor createMotor() {
		// TODO Auto-generated method stub
		return new LGMotor();
	}

	@Override
	public Door createDoor() {
		// TODO Auto-generated method stub
		return new LGDoor();
	}

}
```

```java
public class Client {
	public static void main(String args[])
	{
		ElevatorFactory factory = null;
		String vendorName = args[0];
		VendorID vendorID;
		if(vendorName.equalsIgnoreCase("LG"))	// 인자에 따라 LG 또는 현대 팩토리를 생성함
		{
			vendorID = VendorID.LG;
		}
		else if(vendorName.equalsIgnoreCase("Samsung"))	// 삼성 부품을 생성하는 삼성 팩토리를 이용함
		{
			vendorID = VendorID.SAMSUNG;
		}
		else
		{
			vendorID = VendorID.HYUNDAI;
		}
		
		factory = ElevatorFactoryFactory.getFactory(vendorID);
		
		Door door = factory.createDoor();
		Motor motor = factory.createMotor();
		motor.setDoor(door);
		
		door.open();
		motor.move(Direction.UP);
	}
}
```

제조 업체별 Factory 클래스에 싱글턴 패턴을 적용했으며, vendorID에 주어지는 인자에 따라 제조 업체별 Factory 객체를 생성하는 방식을 캡슐화했다는 점이 다르다.

### **References**

> JAVA 객체 지향 디자인 패턴
