### **11.1 템플릿 메서드 패턴**

템플릿 메서드 패턴은 전체적으로는 동일하면서 부분적으로는 다른 구문으로 구성된 메서드의 코드 중복을 최소화할때 유용하다. 다른 관점에서 보면 동일한 기능을 상위 클래스에서 정의하면서 확장/변화가 필요한 부분만 서브 클래스에서 구현할 수 있도록 한다.

> 템플릿 메서드 패턴의 전체적인 알고리즘은 상위 클래스에서 구현하면서 다른 부분은 하위 클래스에서 구현할 수 있도록 하는 디자인 패턴이다. 전체적인 알고리즘 코드를 재사용하는데 유용하다.

**템플릿 메서드 패턴의 컬레보레이션**

![템플릿 메서드 패턴의 컬레보레이션](https://github.com/yonghwankim-dev/DesignPattern/blob/master/DesignPattern/src/chapter11_%ED%85%9C%ED%94%8C%EB%A6%BF%EB%A9%94%EC%84%9C%EB%93%9C%ED%8C%A8%ED%84%B4/diagram/template-method-pattern_collaboration.png)

-   **AbstractClass** : 템플릿 메서드를 정의하는 클래스. 하위 클래스에 공통 알고리즘을 정의하고 하위 클래스에서 구현될 기능을 primitive 메서드 또는 hook 메서드로 정의하는 클래스다.
-   **ConcreteClass **: 물려받은 primitive 메서드나 hook 메서드를 구현하는 클래스. 상위 클래스에 구현된 템플릿 메서드의 일반적인 알고리즘에서 하위 클래스에 적합하게 primitive 메서드나 hook 메서드를 오버라이드하는 클래스다.

**템플릿 메서드 패턴의 순차 다이어그램**

![템플릿 메서드 패턴의 순차 다이어그램](https://github.com/yonghwankim-dev/DesignPattern/blob/master/DesignPattern/src/chapter11_%ED%85%9C%ED%94%8C%EB%A6%BF%EB%A9%94%EC%84%9C%EB%93%9C%ED%8C%A8%ED%84%B4/diagram/template-method-pattern_seq.png)

1.  Client는 ConcreteClass 객체의 templateMethod 메서드 호출
2.  templateMethod 메서드는 AbstractClass에 정의되었지만 ConcreteClass는 AbstractClass의 하위 클래스이므로 Client가 호출할 수 있다.
3.  AbstractClass::templateMethod 메서드에서는 primitiveOperation1과 primitiveOperation2를 호출한다. 이 2개의 메서드는 ConcreteClass에서 오버라이드된 것이다.

### **11.2 여러 회사의 모터 지원하기**

엘리베이터 제어 시스템에서 모터를 구동시키는 기능을 생각해보자. 예를 들어 현태 모터를 이용하는 제어 시스템이라면 HyundaiMotor 클래스에 move 메서드를 정의할 수 있다.

**현대 모터를 구동시키는 HyundaiMotor 클래스 설계**

![현대 모터를 구동시키는 HyudaiMotor 클래스 설계](https://github.com/yonghwankim-dev/DesignPattern/blob/master/DesignPattern/src/chapter11_%ED%85%9C%ED%94%8C%EB%A6%BF%EB%A9%94%EC%84%9C%EB%93%9C%ED%8C%A8%ED%84%B4/diagram/hyundai-motor.png)

-   HyudaniMotor 클래스는 move 메서드를 실행할 때 안전을 위해 문(Door 클래스)이 닫혀 있는지 조사할 필요가 있다.
-   엘리베이터가 이미 이동 중이면 모터를 구동시킬 필요가 없다.
-   모터의 상태는 정지, 이동 상태가 존재한다.
-   문의 상태는 닫혀 있는 상태, 열려 있는 상태가 존재한다.
-   이동 방향은 위로, 아래로가 존재한다.

**Enumeration 인터페이스인 MotorStatus, DoorStatus, Direction의 설계**

![Enumeration 인터페이스인 MotorStatus, DoorStatus, Direction의 설계](https://github.com/yonghwankim-dev/DesignPattern/blob/master/DesignPattern/src/chapter11_%ED%85%9C%ED%94%8C%EB%A6%BF%EB%A9%94%EC%84%9C%EB%93%9C%ED%8C%A8%ED%84%B4/diagram/motor-door-direction_status.png)

**HyundaiMotor 클래스의 move 메서드 관계**

![HyundaiMotor 클래스의 move 메서드 관계](https://github.com/yonghwankim-dev/DesignPattern/blob/master/DesignPattern/src/chapter11_%ED%85%9C%ED%94%8C%EB%A6%BF%EB%A9%94%EC%84%9C%EB%93%9C%ED%8C%A8%ED%84%B4/diagram/hyundai-motor-move_method.png)

1.  HyundaiMotor 클래스의 move 메서드는 우선 getMotorStatus 메서드를 호출해 모터의 상태를 조회한다.
2.  모터가 이미 동작중이면 move 메서드의 실행을 종료한다.
3.  그리고 Door 클래스의 getDoorStatus 메서드를 호출해 문의 상태를 조회한다.
4.  문이 열려 있는 상태면 Door 클래스의 close 메서드를 호출해 문을 닫는다.
5.  그리고 moveHyundaiMotor 메서드를 호출해 모터를 구동시킨다.
6.  마지막으로 setMotorStatus를 호출해 모터의 상태를 MOVING으로 설정한다.

**현대 모터를 구동시키는 HyundaiMotor 클래스 설계 기반 코드**

```java
public enum DoorStatus {
	CLOSED, OPENED
}

public enum MotorStatus {
	MOVING, STOPPED
}
```

```java
public class Door {
	private DoorStatus doorStatus;

	public Door() {
		this.doorStatus = DoorStatus.CLOSED;
	}

	public DoorStatus getDoorStatus() {
		return doorStatus;
	}
	
	public void close()
	{
		doorStatus = DoorStatus.CLOSED;
	}
	
	public void open()
	{
		doorStatus = DoorStatus.OPENED;
	}
}

```

```java
public class HyundaiMotor {
	private Door door;
	private MotorStatus motorStatus;
	
	public HyundaiMotor(Door door) {
		this.door = door;
		motorStatus = MotorStatus.STOPPED;
	}
	
	private void moveHyundaiMotor(Direction direction)
	{
		// Hyundai Motor를 구동시킴
	}

	public MotorStatus getMotorStatus() {
		return motorStatus;
	}

	public void setMotorStatus(MotorStatus motorStatus) {
		this.motorStatus = motorStatus;
	}
	
	public void move(Direction direction)
	{
		MotorStatus motorStatus = getMotorStatus();
		if(motorStatus==MotorStatus.MOVING)	// 이미 이동 중이면 아무 작업을 하지 않음.
		{
			return;
		}
		
		DoorStatus doorStatus = door.getDoorStatus();
		if(doorStatus==DoorStatus.OPENED)	// 만약 문이 열려 있으면 우선 문을 닫음
		{
			door.close();
		}
		
		moveHyundaiMotor(direction);	// 모터를 주어진 방향으로 이동시킴
		setMotorStatus(MotorStatus.MOVING);
		
	}	
}
```

```java
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Door door = new Door();
		HyundaiMotor hyundaiMotor = new HyundaiMotor(door);
		hyundaiMotor.move(Direction.UP);
	}

}
```

### **11.3 문제점**

-   HyundaiMotor 클래스는 현대 모터를 구동시킨다. 만약 다른 회사의 모터를 제어해야 한다면? 예를 들어 LG 모터를 구동시키려면 어떻게 해야 할까?

**LGMotor 클래스의 구현**

```java
public class LGMotor {
	private Door door;
	private MotorStatus motorStatus;
	
	public LGMotor(Door door) {
		this.door = door;
		motorStatus = MotorStatus.STOPPED;
	}
	
	private void moveLGMotor(Direction direction)
	{
		// LG Motor를 구동시킴
	}

	public MotorStatus getMotorStatus() {
		return motorStatus;
	}

	public void setMotorStatus(MotorStatus motorStatus) {
		this.motorStatus = motorStatus;
	}
	
	public void move(Direction direction)
	{
		MotorStatus motorStatus = getMotorStatus();
		if(motorStatus==MotorStatus.MOVING)	// 이미 이동 중이면 아무 작업을 하지 않음.
		{
			return;
		}
		
		DoorStatus doorStatus = door.getDoorStatus();
		if(doorStatus==DoorStatus.OPENED)	// 만약 문이 열려 있으면 우선 문을 닫음
		{
			door.close();
		}
		
		moveLGMotor(direction); // move 메서드는 이 문장을 제외하면 HyundaiMotor와 동일함
		setMotorStatus(MotorStatus.MOVING);
		
	}
	
}
```

LGMotor 클래스의 HyudaiMotor 클래스를 비교해보면 여러 개의 메서드가 동일하게 구현되어 있음을 알 수 있다. 즉, 2개의 클래스는 많은 중복 코드를 가진다. 일반적으로 코드 중복은 유지보수성을 악화시키므로 바람직하지 않다.

2개 이상의 클래스가 유사한 기능을 제공하면서 중복된 코드가 있는 경우에는 상속을 이용해서 코드 중복 문제를 피할 수 있다.

**HyundaiMotor와 LGMotor 클래스의 상위 클래스인 Motor의 정의**

![HyundaiMotor와 LGMotor 클래스의 상위 클래스인 Motor의 정의](https://github.com/yonghwankim-dev/DesignPattern/blob/master/DesignPattern/src/chapter11_%ED%85%9C%ED%94%8C%EB%A6%BF%EB%A9%94%EC%84%9C%EB%93%9C%ED%8C%A8%ED%84%B4/diagram/motor_solution_classDiagram.png)

**HyundaiMotor와 LGMotor 클래스의 상위 클래스인 Motor의 정의 기반 구현**

```java
public abstract class Motor {	// HyundaiMotor와 LGMotor에 공통적인 기능을 구현하는 클래스
	protected Door door;
	private MotorStatus motorStatus;
	
	public Motor(Door door) {
		this.door = door;
		this.motorStatus = MotorStatus.STOPPED;
	}

	public MotorStatus getMotorStatus() {
		return motorStatus;
	}

	public void setMotorStatus(MotorStatus motorStatus) {
		this.motorStatus = motorStatus;
	}

}
```

```java
public class HyundaiMotor extends Motor{
	
	
	public HyundaiMotor(Door door) {
		super(door);
	}
	
	private void moveHyundaiMotor(Direction direction)
	{
		// Hyundai Motor를 구동시킴
	}
	
	// move 메서드는 LGMotor와 상이하므로 여기서 구현함
	public void move(Direction direction)
	{
		MotorStatus motorStatus = getMotorStatus();
		if(motorStatus==MotorStatus.MOVING)	// 이미 이동 중이면 아무 작업을 하지 않음.
		{
			return;
		}
		
		DoorStatus doorStatus = door.getDoorStatus();
		if(doorStatus==DoorStatus.OPENED)	// 만약 문이 열려 있으면 우선 문을 닫음
		{
			door.close();
		}
		
		moveHyundaiMotor(direction);	// 모터를 주어진 방향으로 이동시킴
		setMotorStatus(MotorStatus.MOVING);
	}
	
}
```

```java
public class LGMotor extends Motor{
	
	
	public LGMotor(Door door) {
		super(door);
	}
	
	private void moveLGMotor(Direction direction)
	{
		// LG Motor를 구동시킴
	}

	// move 메서드는 HyundaiMotor와 상이하므로 여기서 구현함
	public void move(Direction direction)
	{
		MotorStatus motorStatus = getMotorStatus();
		if(motorStatus==MotorStatus.MOVING)	// 이미 이동 중이면 아무 작업을 하지 않음.
		{
			return;
		}
		
		DoorStatus doorStatus = door.getDoorStatus();
		if(doorStatus==DoorStatus.OPENED)	// 만약 문이 열려 있으면 우선 문을 닫음
		{
			door.close();
		}
		
		moveLGMotor(direction); // move 메서드는 이 문장을 제외하면 HyundaiMotor와 동일함
		setMotorStatus(MotorStatus.MOVING);
		
	}
	
}
```

Motor 클래스를 HyundaiMotor 클래스와 LGMotor 클래스의 상위 클래스로 정의함으로써 기존 2개의 클래스에 있었던 Door 클래스와의 연관 관계, motorStatus 필드, getMotorStatus와 setMotorStatus 메서드의 중복을 피할 수 있다.

LGMotor 클래스의 move 메서드와 HyundaiMotor 클래스의 move 메서드를 비교해보면 대부분이 비슷하다는 것을 알 수 있다. 즉, HyundaiMotor 클래스와 LGMotor 클래스의 move 메서드는 여전히 코드 중복 문제가 존재한다.

**HyundaiMotor 클래스와 LGMotor 클래스와 move 메서드 중복 코드**

**1\. HyundaiMotor 클래스**

```java
public void move(Direction direction)
{
	MotorStatus motorStatus = getMotorStatus();
	if(motorStatus==MotorStatus.MOVING)	// 이미 이동 중이면 아무 작업을 하지 않음.
	{
		return;
	}
		
	DoorStatus doorStatus = door.getDoorStatus();
	if(doorStatus==DoorStatus.OPENED)	// 만약 문이 열려 있으면 우선 문을 닫음
	{
		door.close();
	}
		
	moveHyundaiMotor(direction);	// 모터를 주어진 방향으로 이동시킴
	setMotorStatus(MotorStatus.MOVING);
}
```

**2\. LGMotor 클래스**

```java
public void move(Direction direction)
{
	MotorStatus motorStatus = getMotorStatus();
	if(motorStatus==MotorStatus.MOVING)	// 이미 이동 중이면 아무 작업을 하지 않음.
	{
		return;
	}
		
	DoorStatus doorStatus = door.getDoorStatus();
	if(doorStatus==DoorStatus.OPENED)	// 만약 문이 열려 있으면 우선 문을 닫음
	{
		door.close();
	}
		
	moveLGMotor(direction); // move 메서드는 이 문장을 제외하면 HyundaiMotor와 동일함
	setMotorStatus(MotorStatus.MOVING);
		
}
```

### **11.4 해결책**

HyundaiMotor 클래스와 LGMotor 클래스의 move 메서드처럼 완전히 중복되지는 않지만 부분적으로 중복되는 경우에도 상속을 활용해 코드 중복을 피할 수 있다. 즉, **move 메서드에서 moveHyundaiMotor와 moveLGMotor 메서드를 호출하는 구문을 제외하면 두 클래스의 move 메서드는 동일하다.** 그리고 moveHyundaiMotor 메서드와 moveLGMotor 메서드는 모터의 제조사에 따라 구현 방법은 다르지만 모터 구동을 실제로 구현한다는 기능 면에서는 동일하다.

이러한 경우에 move 메서드를 상위 Motor 클래스로 이동시키고 다른 구문, 즉 moveHyundaiMotor와 moveLGMotor 메서드의 호출 부분을 하위 클래스에서 오버라이드하는 방식으로 move 메서드의 중복을 최소화 할 수 있다.

**move 메서드의 중복 코드를 최소화한 설계**

![move 메서드의 중복 코드를 최소화한 설계](https://github.com/yonghwankim-dev/DesignPattern/blob/master/DesignPattern/src/chapter11_%ED%85%9C%ED%94%8C%EB%A6%BF%EB%A9%94%EC%84%9C%EB%93%9C%ED%8C%A8%ED%84%B4/diagram/motor_solution_classDiagram2.png)

두 클래스(HyundaiMotor와 LGMotor)의 move 메서드에서 다른 부분은 moveMotor 메서드 호출로 대체하였다. moveMotor 메서드의 구현이 HyundaiMotor와 LGMotor에 따라 달라야 하므로 moveMotor 메서드는 Motor 클래스에서 추상(Abstract) 메서드로 정의한 후 각 하위 클래스에서 적절하게 오버라이드되도록 한다. **즉, HyundaiMotor 클래스는 moveMotor 메서드를 오버라이드하면서 현대 모터를 구동하는 코드를 작성하고 LGMotor 클래스의 moveMotor 메서드는 LG 모터를 구동하는 코드를 작성한다.**

**move 메서드의 중복 코드를 최소화한 설계 기반 코드**

```java
public abstract class Motor {	// HyundaiMotor와 LGMotor에 공통적인 기능을 구현하는 클래스
	protected Door door;
	private MotorStatus motorStatus;
	
	public Motor(Door door) {
		this.door = door;
		this.motorStatus = MotorStatus.STOPPED;
	}

	public MotorStatus getMotorStatus() {
		return motorStatus;
	}

	public void setMotorStatus(MotorStatus motorStatus) {
		this.motorStatus = motorStatus;
	}
	
	public void move(Direction direction)
	{
		MotorStatus motorStatus = getMotorStatus();
		if(motorStatus==MotorStatus.MOVING)	// 이미 이동 중이면 아무 작업을 하지 않음.
		{
			return;
		}
		
		DoorStatus doorStatus = door.getDoorStatus();
		if(doorStatus==DoorStatus.OPENED)	// 만약 문이 열려 있으면 우선 문을 닫음
		{
			door.close();
		}
		
		moveMotor(direction);
		setMotorStatus(MotorStatus.MOVING);
	}
	
	protected abstract void moveMotor(Direction direction);

}
```

```java
public class HyundaiMotor extends Motor{
	
	
	public HyundaiMotor(Door door) {
		super(door);
	}

	@Override
	protected void moveMotor(Direction direction) {
		// TODO Auto-generated method stub
		// HyundaiMotor를 구동시킴
	}	
}
```

```java
public class LGMotor extends Motor{
	
	
	public LGMotor(Door door) {
		super(door);
	}

	@Override
	protected void moveMotor(Direction direction) {
		// TODO Auto-generated method stub
		// LGMotor를 구동시킴
	}
}
```

HyundaiMotor 클래스와 LGMotor 클래스에서 대부분의 구문이 중복되었던 move 메서드를 Motor 클래스로 이동했음을 확인 할 수 있다. 즉, 다른 부분(moveMotor 메서드)만을 HyundaiMotor 클래스와 LGMotor 클래스에서 구현했음을 확인할 수 있다.

### **References**

> JAVA 객체지향 디자인 패턴
