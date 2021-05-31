### **7.1 스테이트 패턴이란?**

실세계의 많은 개체는 잣니이 처한 상태에 따라 일을 다르게 수행한다. 비가 오거나 눈이 오거나 사람이 많이 붐비는 장소에 있거나에 따라 걷는 방식과 말하는 방식이 달라지는 것과 마찬가지 이치다. 이를 표현하는 가장 직접적이고 직관적인 방법은 일을 수행할 때의 상태에 따라 상태 하나하나가 어떤 상태인지 검사해 일을 다르게 수행하게끔 하는 것이다. 이는 분명 복잡한 조건식이 있는 코드를 산출할 것이고, 결과적으로 코드를 이해하거나 수정하기 어렵게 만든다.

이러한 방식과 달리 스테이트 패턴(State Pattern)은 어떤 행위를 수행할 때 상태에 행위를 수행하도록 위임한다.

이를 위해 스테이트 패턴에서는 시스템의 각 상태를 클래스로 분리해 표현하고, 각 클래스에서 수행하는 행위들을 메서드로 구현한다. 그리고 이러한 상태들을 외부로부터 캡슐화하기 위해 인터페이스를 생성하여 시스템의 각 상태를 나타내는 클래스로 하여금 실체화하게 한다.

**스테이트 패턴의 컬레보레이션**

![스테이트 패턴의 컬레보레이션](https://github.com/yonghwankim-dev/DesignPattern/blob/master/DesignPattern/src/chapter07_%EC%8A%A4%ED%85%8C%EC%9D%B4%ED%8A%B8%ED%8C%A8%ED%84%B4/diagram/state-pattern_collaboration.png)

-   **State** : 시스템의 모든 상태에 공통의 인터페이스를 제공한다. 따라서 이 인터페이스를 실체화한 어떤 상태 클래스도 기존 상태 클래스를 대신해 교체해서 사용할 수 있다.
-   **State1, State2, State3** : Context 객체가 요청한 작업을 자신의 방식으로 실제 실행한다. 대부분의 경우 다음 상태를 결정해 상태 변경을 Context 개체에 요청하는 역할도 수행한다.
-   **Context** : State를 이용하는 역할을 수행한다. 현재 시스템의 상태를 나타내는 상태 변수(State)와 실제 시스템의 상태를 구성하는 여러 가지 변수가 존재한다. 또한 각 상태 클래스에서 상태 변경을 요청해 상태를 바꿀 수 있도록 하는 메서드(setState)가 제고오딘다. Context 요소를 구현한 클래스의 request 메소드는 실제 행위를 실행하는 대신 해당 상태 객체에 행위 실행을 위임한다.

> **스테이트 패턴은 상태에 따라 동일한 작업이 다른 방식으로 실행될 때 해당 상태가 작업을 수행하도록 위임하는 디자인 패턴이다.**

### **7.2 상태 머신 다이어그램**

UML에서 상태와 상태 변화를 모델링하는 도구로 상태 머신 다이어그램(State Machine Diagram)이 존재한다.

아래 그림은 선풍기를 표현하는 상태 다이어그램이다.

![선풍기 상태 머신 다이어그램](https://github.com/yonghwankim-dev/DesignPattern/blob/master/DesignPattern/src/chapter07_%EC%8A%A4%ED%85%8C%EC%9D%B4%ED%8A%B8%ED%8C%A8%ED%84%B4/diagram/state-pattern_fan.png)

위 다이어그램에서 모서리가 둥근 사각형은 상태(State)를 나타내고, 상태 사이에 화살표를 사용해 상태 전이(State Transition)을 나타낸다.

**상태란 무엇인가?**

상태란 객체가 시스템에 존재하는 동안, 즉 객체의 라이프 타임 동안 객체가 가질 수 있는 어떤 조건이나 상황을 표현한다. 예를 들면 객체가 어떤 상태에 있는 동안 어떤 액티비티(Activity) 등을 수행하거나 특정 이벤트(Event)가 발생하기를 기다리는 것이다.

UML 상태 머신 다이어그램 의사 상태(Pseudo State)

-   시작
-   종료
-   히스토리
-   선택
-   교차
-   포크
-   조인
-   진입점
-   진출점

**상태 진입이란 무엇인가?**

상태 진입이란 객체의 한 상태에서 다른 상태로 이동하는 것을 말한다. 보통 상태 진입은 특정 이 벤트가 발생한 후 명세된 조건을 만족한 경우에 이루어진다. '이벤트(인자 리스트)\[조건\]/액션'으로 명세할 수 있으며 '/' 다음에 진입이 이루어지면서 수행되어야 하는 액션을 기술한다.

예를 들어 선풍기 상태 머신 다이어그램에서 OFF 상태에서 ON 상태로 진입된 상황을 생각해보자. 선풍기가 현재 OFF 상태라면 사용자가 전원이 들어온 상황에서 선풍기의 스위치를 켜는 switch\_on 이벤트를 선풍기에 발생시킨다. 그러면 선풍기는 ON 상태로 이동하게 되며, 이때 turnon 액션을 실행하게 된다.

**선풍기 상태 머신 다이어그램 해석**

-   선풍기는 기본적으로 OFF 상태에서 시작한다.
-   OFF 상태에서 사용자가 선풍기 스위치를 켜면 switch\_on 이벤트를 발생시킨다. 이때 전원이 들어온 상태라면(power\_exists 조건) ON 상태로 진입한다. 이때 turnon 액션을 실행하게 된다.
-   OFF 상태에서 사용자가 선풍기 스위치를 켜면 switch\_on 이벤트를 발생시킨다. 이때 전원이 들어오지 않은 상태라면(power\_exists 조건) OFF 상태에 머무른다.
-   사용자가 ON 상태에서 동작 버튼을 누르면 run 이벤트를 발생시키고 WORKING 상태로 진입한다. 이때 operate 액션을 실행하게 된다.
-   사용자가 ON 상태나 WORKING 상태에 머무를 때 사용자가 스위치를 끄면 switch\_off 이벤트가 발생하고 이 이벤트로 인해 OFF 상태로 진입한다.

### **7.3 형광등 만들기**

**형광등 행동 분석**

-   형광등이 꺼져 있을 때 외부에서 On 버튼을 누르면 형광등이 켜진다.
-   형광등이 켜져 있을 때 Off 버튼을 누르면 꺼진다.
-   만약 이미 형광등이 켜져 있는 상태에서 On 버튼을 누르면 형광등 상태는 그대로 켜져 있다.
-   만약 이미 형광등이 꺼져 있는 상태에서 Off 버튼을 누르면 형광등 상태는 그대로 꺼져 있다.
-   형광등은 처음에는 꺼져 있는 상태라고 가정한다.
-   
![형광등의 상태 머신 다이어그램](https://github.com/yonghwankim-dev/DesignPattern/blob/master/DesignPattern/src/chapter07_%EC%8A%A4%ED%85%8C%EC%9D%B4%ED%8A%B8%ED%8C%A8%ED%84%B4/diagram/state-pattern_light-state-diagram.png)

**형광등 상태 머신 다이어그램 코드**

```java
public class Light {
    private static int ON = 0;    // 형광등이 켜진 상태
    private static int OFF = 1;    // 형광등이 꺼진 상태
    private int state;            // 형광등의 현재 상태

    public Light() 
    {
        this.state = OFF;    // 형광등 초기 상태는 꺼저 있는 상태임
    }

    public void on_button_pushed() 
    {
        if(state==ON)
        {
            System.out.println("반응 없음");
        }
        else
        {
            System.out.println("Light On");
            state = ON;
        }
    }

    public void off_button_pushed()
    {
        if(state==OFF)
        {
            System.out.println("반응 없음");
        }
        else    // 형광등이 켜저 있을 때 Off 버튼을 누르면 꺼진 상태로 전환됨
        {
            System.out.println("Light Off");
            state = OFF;
        }
    }
}

```

```java
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Light light = new Light();
		light.off_button_pushed();
		light.on_button_pushed();
		light.off_button_pushed();
	}
}
```

```java
반응 없음
Light On
Light Off
```

### **7.4 문제점**

-   형광등에 새로운 상태를 추가할 때, 가령 형광등에 '취침등' 상태를 추가하려면?

**취침등 상태 분석**

-   형광등이 켜져 있을 때 On 버튼을 누르면 '취침등' 상태(SLEEPING)로 변경된다.
-   취침등 상태에서 On 버튼을 누르면 형광등이 다시 켜진다.
-   형광등이 켜져 있거나 취침등이 켜져 있는 상태에서 Off 버튼을 누르면 형광등이 꺼진다.

**'취침등' 상태를 추가한 상태 머신 다이어그램**

![취침등 상태를 추가한 상태 머신 다이어그램](https://github.com/yonghwankim-dev/DesignPattern/blob/master/DesignPattern/src/chapter07_%EC%8A%A4%ED%85%8C%EC%9D%B4%ED%8A%B8%ED%8C%A8%ED%84%B4/diagram/state-pattern_sleeping-state-diagram.PNG)

**'취침등' 상태를 추가한 상태 머신 다이어그램을 기반 코드**

추가된 취침등 상태 값에서 on\_button\_pushed 상태와 off\_button\_pushed 상태를 어떻게 처리하는가를 코딩해야 한다. 따라서 on\_button\_pushed와 off\_button\_pushed 메서드 안에서 현재 상태 값이 SLEEPING 변수 값과 같은지를 검사하고 값이 같다면 요구사항에 맞게 적절한 행위를 하도록 코딩한다.

```java
public class Light {
	private static int ON = 0;	// 형광등이 켜진 상태
	private static int OFF = 1;	// 형광등이 꺼진 상태
	private static int SLEEPING = 2;	// 취침등 상태
	private int state;			// 형광등의 현재 상태
	
	public Light() 
	{
		this.state = OFF;	// 형광등 초기 상태는 꺼저 있는 상태임
	}
	
	public void on_button_pushed() 
	{
		if(state==ON)	// 형광등이 켜저 있는 상태에서 On 버튼을 누르면 취침등 상태로 전환됨
		{
			System.out.println("취침등 상태");
			state = SLEEPING;
		}
		else if(state==SLEEPING)	// 형광등이 취침등 상태에 있는 경우
		{
			System.out.println("Light On!");
			state = ON;
		}
		else
		{
			System.out.println("Light On");
			state = ON;
		}
	}
	
	public void off_button_pushed()
	{
		if(state==OFF)
		{
			System.out.println("반응 없음");
		}
		else if(state==SLEEPING)	// 형광등이 취침등 상태에 있는 경우
		{
			System.out.println("Light Off!");	// Off 버튼을 누르면 OFF로 전환됨
			state = OFF;
		}
		else	// 형광등이 켜저 있을 때 Off 버튼을 누르면 꺼진 상태로 전환됨
		{
			System.out.println("Light Off");
			state = OFF;
		}
	}
}

```

위와 같이 상태 진입이 복잡한 조건문에 내포된 지금의 코드 구조는 현재 시스템의 상태 변화를 파악하기에 용이하지 않다. 그리고 새로운 상태가 추가되는 경우에 상태 변화를 초래하는 모든 메서드에 이를 반영하기 위해 코드를 수정해야만 한다.

### **7.5 해결책**

위와 같은 문제점을 해결하기 위해서는 변하는 부분을 찾아서 이를 캡슐화하는 것이 중요하다. 목표는 현재 시스템이 어떤 상태에 있는지와 상관없게 구성하고 상태 변화에도 독립적이도록 코드를 수정하는 것이다.

이를 위해서는 상태를 클래스로 분리해 캡슐화하도록 한다. 또한 상태에 의존적인 행위들도 상태 클래스에 같이 두어 특정 상태에 따른 행위를 구현하도록 변경한다. 이렇게 하면 상태에 따른 행위가 각 클래스에 국지화되어 이해하고 수정하기 쉽다.

**스테이트 패턴으로 구현한 형광등 상태 머신 다이어그램**

![스테이트 패턴으로 구현한 형광등 상태 머신 다이어그램](https://github.com/yonghwankim-dev/DesignPattern/blob/master/DesignPattern/src/chapter07_%EC%8A%A4%ED%85%8C%EC%9D%B4%ED%8A%B8%ED%8C%A8%ED%84%B4/diagram/state-pattern_light-state-diagram_Improve.png)

위 클래스 다이어그램은 5장의 스트래티지 패턴과 동일하다. Light 클래스에서 구체적인 상태 클래스가 아닌 추상화된 State 인터페이스만 참조하므로 현재 어떤 상태에 있는지와 무관하게 코드를 작성할 수 있다.

Light 클래스에서는 상태 클래스에 작업을 위임만 하면 된다. 이전에 보았던 복잡한 조건식은 더 필요 없다.

**개선된 형광등 상태 머신 다이어그램 코드**

```java
public interface State {
	public void on_button_pushed(Light light);
	public void off_button_pushed(Light light);
}
```

```java
public class ON implements State{
	private static ON on = new ON();	// ON 클래스의 인스턴스로 초기화
	
	public ON()
	{
		
	}
	
	public static ON getInstance()	// 초기화된 ON 클래스의 인스턴스를 반환함
	{
		return on;
	}
	
	@Override
	public void on_button_pushed(Light light) {
		// TODO Auto-generated method stub
		System.out.println("반응 없음");
	}

	@Override
	public void off_button_pushed(Light light) {
		// TODO Auto-generated method stub
		light.setState(OFF.getInstance());
		System.out.println("Light Off");
		
	}

}

```

```java
public class OFF implements State{
	private static OFF off = new OFF();
	
	public OFF()
	{
		
	}
	
	public static State getInstance() {
		// TODO Auto-generated method stub
		return off;
	}
	
	@Override
	public void on_button_pushed(Light light) {
		// TODO Auto-generated method stub
		light.setState(ON.getInstance());
		System.out.println("Light On");
		
	}

	@Override
	public void off_button_pushed(Light light) {
		// TODO Auto-generated method stub
		System.out.println("반응 없음");
	}

	

}

```

```java
public class Light {
	private State state;			// 형광등의 현재 상태
	
	public Light() 
	{
		state = new OFF();
	}
	
	public void setState(State state)
	{
		this.state = state;
	}
	
	public void on_button_pushed() 
	{
		state.on_button_pushed(this);
	}
	
	public void off_button_pushed()
	{
		state.off_button_pushed(this);
	}
}

```

```java
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Light light = new Light();
		light.off_button_pushed();	// 반응 없음
		light.on_button_pushed();	// Light On
		light.off_button_pushed();	// Light Off
	}
}
```

```java
반응 없음
Light On
Light Off
```

Light 클래스의 state 변수를 통해 현재 시스템의 상태 객체를 참조한다. 상태에 따른 행위를 수정하려면 state 변수가 참조하는 상태 객체에 작업을 위임해야 한다. Light 클래스 코드 어디를 보더라도 구체적인 상태를 나타내는 객체를 참조하지 않는다. 즉, Light 클래스는 시스템이 어떤 상태에 있는지와 무관하다는 의미이다. 따라서 상태가 새로운 상태로 교체되더라도 Light 클래스는 전혀 영향을 받지 않는다.

그러나 이 코드는 개선할 점이 존재한다. 상태 변화가 생길 때마다 새로운 상태 객체를 생성하므로 메모리 낭비와 성능 저하를 가져올 수 있기 때문이다. 대부분 상태 객체는 한 번만 생성해도 충분하다. 객체를 하나만 만들 수 있는 방법인 싱글턴 패턴을 적용하면 객체 하나만 생성할 수 있다. 위의 코드는 싱글턴 패턴을 적용한 코드이다.

### References

> JAVA 객체 지향 디자인 패턴  
> https://github.com/walbatrossw/java-design-patterns/blob/master/ch07-state-patterns/ch07-state-patterns.md
