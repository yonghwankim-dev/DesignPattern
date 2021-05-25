### 5.1 전략 패턴

-   전략 패턴(Strategy Pattern)이란 전략을 쉽게 바꿀 수 있도록 해주는 디자인 패턴이다.
-   전략이란 어떤 목적을 달성하기 위해 일을 수행하는 방식, 비즈니스 규칙, 문제를 해결하는 알고리즘 등으로 이해할 수 있다.
-   프로그램에서 전략을 실행할 때는 쉽게 전략을 바꿔야 할 필요가 있는 경우가 많이 발생한다.
-   특히 게임 프로그래밍에서 게임 캐릭터가 자신이 처한 상황에 따라 공격이나 행동하는 방식을 바꾸고 싶을 때 스트래티지 패턴은 매우 유용하다.

> 스트래티지 패턴은 같은 문제를 해결하는 여러 알고리즘(방식)이 클래스별로 캡슐화되어 있고 이들이 필요할 때 교체할 수 있도록 함으로써 동일한 문제를 다른 알고리즘으로 해결할 수 있게 하는 디자인 패턴이다.

**스트래티지 패턴 컬레보레이션**

![스트래티지 패턴 컬레보레이션](https://github.com/yonghwankim-dev/DesignPattern/blob/master/DesignPattern/src/chapter05_%EC%8A%A4%ED%8A%B8%EB%9E%98%ED%8B%B0%EC%A7%80%ED%8C%A8%ED%84%B4/diagrams/strategy-pattern-collaboration.png)

스트래티지 패턴에서 나타나는 역할이 수행하는 작업은 다음과 같다.

-   **Strategy** : 인터페이스나 추상 클래스로 외부에서 동일한 방식으로 알고리즘을 호출하는 방법을 명시한다.
-   **ConcreteStrategy1, ConcreteStrategy2, ConcreteStrategy**3 : 스트래티지 패턴에서 명시한 알고리즘을 실제로 구현한 클래스다.
-   **Context** : 스트래티지 패턴을 이용하는 역할을 수행한다. 필요에 따라 동적으로 구체적인 전략을 바꿀 수 있도록 setter 메서드를 제공한다.

**스트래티지 패턴의 순차 **다이어그램****

![스트래티지 패턴의 순차 다이어그램](https://github.com/yonghwankim-dev/DesignPattern/blob/master/DesignPattern/src/chapter05_%EC%8A%A4%ED%8A%B8%EB%9E%98%ED%8B%B0%EC%A7%80%ED%8C%A8%ED%84%B4/diagrams/strategy-patterns-sequence.png)

클라이언트가 원하는 스트래티지 객체를 생성하고 이를 Context 객체에 바인딩하면 Context 객체는 바인딩된 스트래티지 객체의 타입에 따라 적절한 행위를 실행한다.

### **5.2 로봇 만들기**

**5.2.1 로봇 설계**

![로봇 설계](https://github.com/yonghwankim-dev/DesignPattern/blob/master/DesignPattern/src/chapter05_%EC%8A%A4%ED%8A%B8%EB%9E%98%ED%8B%B0%EC%A7%80%ED%8C%A8%ED%84%B4/diagrams/robot-design.png)

클래스 다이어그램에서 Atom 클래스(아톰)와 TaekwonV 클래스(태권V)는 Robot이라는 추상 클래스의 자식 클래스로 설정하였다.

위와 같이 설계한 이유는 아톰과 태권V는 둘 다 공격(attack 메서드)과 이동(move 메서드) 기능이 있는 로봇의 한 종류이기 때문이다.

아톰과 태권V의 이동 기능과 공격 기능이 서로 다르기 때문에 Robot 클래스에서 attack과 move 메서드를 추상 메서드로 설정하여 자식 클래스에서 각각 정의하도록 하였다.

아래의 코드는 로봇 설계 클래스 다이어그램을 기반으로 작성한 것이다.

```
public abstract class Robot {
	private String name;

	public Robot(String name) 
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public abstract void attack();
	public abstract void move();
}

```

```
public class TaekwonV extends Robot{
	public TaekwonV(String name) 
	{
		super(name);
	}
	
	@Override
	public void attack()
	{
		System.out.println("I have Missile and can attack with it.");
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("I can only walk");
	}
	
	
}
```

```
public class Atom extends Robot{

	public Atom(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println("I have strong punch and can attack with it.");
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("I can fly");
	}

}
```

```
public class Client {
	public static void main(String args[])
	{
		Robot taekwonV = new TaekwonV("TaekwonV");
		Robot atom = new Atom("Atom");
		
		System.out.println("My name is " + taekwonV.getName());
		taekwonV.move();
		taekwonV.attack();
		
		System.out.println();
		
		System.out.println("My name is " + atom.getName());
		atom.move();
		atom.attack();
	}
}
```

> output  
> My name is TaekwonV  
> I can only walk  
> I have Missile and can attack with it.  
>   
> My name is Atom  
> I can fly  
> I have strong punch and can attack with it.

### **5.3 문제점**

5.2.1 로봇 설계의 문제점은 다음과 같다.

-   기존 로봇의 공격 또는 이동 방법을 수정하려면 어떤 변경 작업을 해야 하는가? 예를 들어 아톰이 날 수는 없고 오직 걷게만 만들고 싶다면? 또는 태권V를 날게 하려면?
-   새로운 로봇을 만들어 기존의 공격 또는 이동 방법을 추가하거나 수정하려면? 예를 들어 새로운 로봇으로 지구의 용사 선가드(Sungard 클래스)를 만들어 태권V의 미사일 공격 기능을 추가하려면?

### **5.3.1 기존 로봇의 공격과 이동 방법을 수정하는 경우**

```
// 태권브이 클래스 공격과 이동 방법 수정
public class TaekwonV extends Robot {

    public TeakwonV(String name) {
        super(name);
    }
    
    // 태권브이 공격을 수정
    @Override
    public void attack() {
        System.out.println("I have strong punch and can attack with it.");
    }

    @Override
    public void move() {
        System.out.println("I can only walk.");
    }

}
```

```
// 아톰 클래스 이동 방법 수정
public class Atom extends Robot {

    public Atom(String name) {
        super(name);
    }

    @Override
    public void attack() {
        System.out.println("I have strong punch and can attack with it.");
    }
    
    // 아톰 이동 변경
    @Override
    public void move() {
        System.out.println("I can only walk.");
    }

}
```

```
public class Client {
	public static void main(String args[])
	{
		Robot taekwonV = new TaekwonV("TaekwonV");
		Robot atom = new Atom("Atom");
		
		System.out.println("My name is " + taekwonV.getName());
		taekwonV.move();
		taekwonV.attack();
		
		System.out.println();
		
		System.out.println("My name is " + atom.getName());
		atom.move();
		atom.attack();
	}
}

```

위와 같이 태권V 클래스의 공격방법을(attack 메서드 내용) 수정하고 아톰 클래스의 이동방법을(move 메서드 내용) 수정하였다. 하지만 **새로운 기능으로 변경하려고 기존 코드의 내용을 수정해야 하므로 OCP(Open-Closed Principle)에 위배된다.** 또한 Atom 클래스의 move 메서드와 TaekwonV 클래스의 move 메서드가 동일한 기능을 실행하므로 기능이 중복되는 상황이 발생한다. 이와 같은 중복 상황은 많은 문제를 야기하는 원인이 된다. 만약 걷는 방식에 문제가 있거나 새로운 방식으로 수정하려면 모든 중복된 코드를 일관성 있게 변경해야만 한다. 여기에서는 로봇의 종류가 2가지뿐이지만 로봇의 종류가 많아질수록 중복 코드를 일관성 있게 유지 관리하는 일은 매우 힘들고 대단한 집중력을 요구한다.

### **5.3.2 새로운 로봇에 공격/이동 방법을 추가/수정하는 경우**

#### **새로운 로봇의 추**가****

![새로운 로봇의 추가](https://github.com/yonghwankim-dev/DesignPattern/blob/master/DesignPattern/src/chapter05_%EC%8A%A4%ED%8A%B8%EB%9E%98%ED%8B%B0%EC%A7%80%ED%8C%A8%ED%84%B4/diagrams/robot-add.png)

현재 시스템의 캡슐화 단위에 따라 새로운 로봇을 추가하기는 매우 쉽다. 그러나 새로운 로봇에 기존의 공격 또는 이동 방법을 추가하거나 변경하려고 하면 문제가 발생한다. 가령 **선가드(Sungard 클래스)에 태권V의 미사일 공격 기능을 사용하려고 하면 TaekwonV 클래스와 Sungard 클래스의 attack 메서드가 중복해서 사용된다. 이러한 중복 코드는 나중에 심각한 문제를 발생시킨다.**

### **5.4 해결책**

로봇 설계에서의 문제를 해결하기 위해서는 무엇이 변화되었는지 찾아야 한다.

변화된 것을 찾은 후에는 이를 클래스로 캡슐화를 수행해야 한다.

-   변화하는 것 : 로봇의 이동방식, 로봇의 공격 방식

로봇의 이동방식과 로봇의 공격방식을 캡슐화하려면 외부에서 구체적인 이동 방식과 공격 방식을 담은 구체적인 클래스들을 은닉해야 한다. 이를 위해 공격과 이동을 위한 인터페이스를 각각 만들고 이들을 실제 실현한 클래스를 생성해야 한다.

#### **공격과 이동 전략 인터페이스**

![공격과 이동 전략 인터페이스](https://github.com/yonghwankim-dev/DesignPattern/blob/master/DesignPattern/src/chapter05_%EC%8A%A4%ED%8A%B8%EB%9E%98%ED%8B%B0%EC%A7%80%ED%8C%A8%ED%84%B4/diagrams/robot-design-attack-move-strategy-interface.png)

클라이언트에서는 연관 관계를 이용해 이동 기능과 공격 기능의 변화를 포함시킨다.

위 예에서는 Robot 클래스가 이동 기능과 공격 기능을 이용하는 클라이언트 역할을 수행한다.

이 클래스는 변화를 처리하기 위해 MovingStrategy와 AttackStrategy 인터페이스를 포함해야 한다.

#### **개선된 인터페이스**

![개선된 인터페이스](https://github.com/yonghwankim-dev/DesignPattern/blob/master/DesignPattern/src/chapter05_%EC%8A%A4%ED%8A%B8%EB%9E%98%ED%8B%B0%EC%A7%80%ED%8C%A8%ED%84%B4/diagrams/robot-design-enhanced.png)

-   Robot : 로봇 클래스, 이동과 공격을 실행하는 메서드를 소유하고 있으며 이를 상속받아 구체적인 로봇을 생성 가능함
-   Atom, TaekwonV : 로봇 클래스의 구체적인 클래스
-   AttackStrategy, MovingStrategy : 각각의 로봇이 취할수 있는 공격방식과 이동방식에 대한 인터페이스
-   PunchStrategy, MissileStrategy : 공격방식 인터페이스에 대한 구체적인 클래스
-   WalkingStrategy, FlyingStrategy : 이동방식 인터페이스에 대한 구체적인 클래스

Robot 클래스의 입장에서 보면 구체적인 이동 방식과 공격 방식이 MovingStrategy와 AttackStrategy 인터페이스에 의해 캡슐화되어 있다.

따라서 이들 기능을 이용하는 로봇 객체와는 상관없이 향후 등장할 이동 방식과 공격 방식의 변화뿐만 아니라 현재 변화도 융통성있게 처리할 수 있게 된다.

예를 들어 새로운 공격 방식이 개발되어 현재 로봇에 제공하더라도 AttackStrategy 인터페이스가 변화에 대한 일종의 방화벽 역할을 수행해 Robot 클래스의 변경을 차단해준다.

즉, 새로운 기능의 추가(새로운 공격 기능)까 기존의 코드에 영향을 미치지 못하게 하므로 OCP를 만족하는 설계가 된다.

이렇게 변경된 새로운 구조에서는 외부에서 로봇 객체의 이동 방식과 공격 방식을 임의대로 바꾸도록 해주는 메서드가 필요하다.

이를 위해 Robot 클래스에 setMovingStrategy와 setAttackStrategy 메서드를 정의해 로봇의 이동 방식과 공격 방식이 필요할 때 바꿀 수 있도록 했다. 이러한 변경이 가능한 이유는 상속 대신 집약 관계를 이용했기 때문이다.

```
public abstract class Robot {
	private String name;
	private MovingStrategy movingStrategy;
	private AttackStrategy attackStrategy;
	public Robot(String name) 
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void move()
	{
		movingStrategy.move();
	}
	
	public void attack()
	{
		attackStrategy.attack();
	}
	
	public void setMovingStrategy(MovingStrategy movingStrategy)
	{
		this.movingStrategy = movingStrategy;
	}
	
	public void setAttackStrategy(AttackStrategy attackStrategy)
	{
		this.attackStrategy = attackStrategy;
	}
}

```

```
public class Atom extends Robot{

	public Atom(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
}

```

```
public class TaekwonV extends Robot{
	public TaekwonV(String name) 
	{
		super(name);
	}	
}

```

```
public interface MovingStrategy {
	public void move();
}

```

```
public class FlyingStrategy implements MovingStrategy{

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("I can fly.");
	}
	
}

```

```
public class WalkingStrategy implements MovingStrategy{

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("I can only walk");
	}
	
}

```

```
public interface AttackStrategy {
	public void attack();
}

```

```
public class PunchStrategy implements AttackStrategy{

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println("I have strong punch and can attack with it.");
		
	}

}

```

```
public class MissileStrategy implements AttackStrategy{

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println("I have Missile and can attack with it.");
	}

}

```

```
public class Client {
	public static void main(String args[])
	{
		Robot taekwonV = new TaekwonV("TaekwonV");
		Robot atom = new Atom("Atom");
		
		taekwonV.setMovingStrategy(new WalkingStrategy());
		taekwonV.setAttackStrategy(new MissileStrategy());
		
		atom.setMovingStrategy(new FlyingStrategy());
		atom.setAttackStrategy(new PunchStrategy());
		
		System.out.println("My name is " + taekwonV.getName());
		taekwonV.move();
		taekwonV.attack();
		
		System.out.println("My name is " + atom.getName());
		atom.move();
		atom.attack();
		
	}
}

```

### **References**

> JAVA 객체지향 디자인 패턴  
> https://github.com/walbatrossw/java-design-patterns/blob/master/ch05-strategy-pattern/ch05-strategy-pattern.md
