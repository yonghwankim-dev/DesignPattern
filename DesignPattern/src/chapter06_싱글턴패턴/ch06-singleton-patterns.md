### **6.1 싱글턴 패턴(Singleton Pattern)**

싱글턴 패턴은 인스턴스가 오직 하나만 생성되는 것을 보장하고 어디에서든 이 인스턴스에 접근할 수 있도록 하는 디자인 패턴이다.

**싱글턴 패턴 컬레보레이션**

![싱글턴 패턴 컬레보레이션](https://github.com/yonghwankim-dev/DesignPattern/blob/master/DesignPattern/src/chapter06_%EC%8B%B1%EA%B8%80%ED%84%B4%ED%8C%A8%ED%84%B4/diagrams/singleton-pattern_collaboration.png)

-   Singleton : 하나의 인스턴스만을 생성하는 책임이 존재하며 getInstance 메서드를 통해 모든 클라이언트에게 동일한 인스턴스를 반환하는 작업을 수행한다.

**싱글턴 패턴의 순차 다이어그램**

![싱글턴 패턴의 순차 다이어그램](https://github.com/yonghwankim-dev/DesignPattern/blob/master/DesignPattern/src/chapter06_%EC%8B%B1%EA%B8%80%ED%84%B4%ED%8C%A8%ED%84%B4/diagrams/singleton-pattern_sequence.png)

클라이언트가 싱글턴 클래스에 getInstance 메서드를 통해 객체 생성을 요청하면 이미 객체가 생성된 경우에는 객체를 반환하고, 처음으로 생성하는 경우에는 생성자를 호출해 객체를 생성한다.

### **6.2 프린터 관리자 만들기**

10명의 직원들이 프린터 하나만 공유해서 사용해야 하는 실정이다. 프린터를 관리하는 프로그램을 만들어본다.

**step1 Printer Class 생성**

```java
public class Printer {
    public Printer()
    {
		
    }
    
    public void print(Resource r){
    	// ...
    }
}
```

Printer 클래스를 사용하여 프린터를 이용하려면 클라이언트 프로그램에서 new Printer()가 반드시 한 번만 호출되도록(프린터는 하나뿐이므로) 프로그래머가 상당한 주의를 기울여야 한다.

new Printer()가 한번만 호출되도록 할 수 있는 직관적인 방법은 생성자를 외부에서 호출할 수 없게 하는 것이다. 그 방법은 Printer 클래스의 생성자의 접근제어자를 private으로 선언하면 된다.

```java
public class Printer{
    private Printer()	// 접근제어자를 public -> private 변경
    {
    
    }
    public void print(Resource r)
    {
    	// ...
    }
}
```

위와 같이 변경하면 외부에서는 new Printer()를 더  사용할 수 없게 된다. 그러나 일단 Printer 인스턴스는 하나 생성해야 하는 상황이므로 아래와 같이 인스턴스를 만들어 외부에 제공해줄 메서드가 필요하다.

```java
public class Printer {
	private static Printer printer = null;
	private Printer()
	{
		
	}
	
	public static Printer getPrinter()
	{
		if(printer==null)
		{
			printer = new Printer();	// Printer 인스턴스 생성	
		}
		return printer;
	}
	
	public void print(String str)
	{
		System.out.println(str);
	}
}

```

getPrinter 메서드는 Printer 인스턴스가 이미 생성되어 있는지를 검사한다. 만약 처음 호출 시 아직 인스턴스가 생성되지 않은 상황이라면 생성자를 호출해 인스턴스를 생성한다. 위와 같이 생성된 인스턴스는 정적 변수 printer에 의해 참조가 된다. 만약 이미 인스턴스가 생성되었다면 printer 변수에 참조하는 인스턴스를 반환한다.

위 코드에서 주의 깊에 살펴봐야 할 점은 **getPrinter 메서드와 printer 변수가 static 타입으로 선언되었다는 점이다.**

이와 같이 static으로 선언된 메서드나 변수를 각각 정적 메서드, 정적 변수라 한다.

**정적 메소드, 정적 변수**

-   구체적인 인스턴스에 속하는 영역이 아닌 클래스 자체에 속하는 의미
-   클래스의 인스턴스를 통하지 않고서도 메서드를 실행 가능하고 변수를 참조 할 수 있다.
-   클래스명을 통해서 호출하거나 참조가 가능하다.

목적은 단 하나의 객체만 생성해 이를 어디에서든지 참조할 수 있게 하는 것이므로 처음에 객체를 만들려면 getPrinter 메서드가 정적 메서드로 선언되어 있어야 한다.

위의 코드를 사용하여 5명의 사용자가 프린터를 이용하는 상황으로 코드를 작성한다.

```java
public class User {
	private String name;
	
	public User(String name)
	{
		this.name = name;
	}
	
	public void print()
	{
		Printer printer = Printer.getPrinter();
		printer.print(this.name + " print user " + printer.toString() + ".");
	}
}

```

```java
public class Printer {
	private static Printer printer = null;
	private Printer()
	{
		
	}
	
	public static Printer getPrinter()
	{
		if(printer==null)
		{
			printer = new Printer();	// Printer 인스턴스 생성	
		}
		return printer;
	}
	
	public void print(String str)
	{
		System.out.println(str);
	}
}

```

```java
public class Client {
	private static final int User_NUM =5;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		User[] user = new User[User_NUM];
		for(int i=0;i<User_NUM;i++)
		{
			user[i] = new User((i+1)+"=user");
			user[i].print();
		}
	}

}

```

```java
1=user print user chapter06_싱글턴패턴.practice.p01_before.Printer@5caf905d.
2=user print user chapter06_싱글턴패턴.practice.p01_before.Printer@5caf905d.
3=user print user chapter06_싱글턴패턴.practice.p01_before.Printer@5caf905d.
4=user print user chapter06_싱글턴패턴.practice.p01_before.Printer@5caf905d.
5=user print user chapter06_싱글턴패턴.practice.p01_before.Printer@5caf905d.
```

위와 같은 결과로 하나의 인스턴스(프린터)만을 사용한 것을 알 수 있다.

### **6.3 문제점**

6.2 프린터 관리자 만들기에서 성공적으로 프린터 인스턴스를 하나만 만들고 여러 곳에서 동일한 프린터를 이용하게끔 코드를 작성하였다. 지금까지는 아무런 문제가 없어 보인다. 그러나 다중 스레드에서 Printer 클래스를 이용할 때 인스턴스가 1개 이상 생성되는 경우가 발생할 수 있다.

인스턴스가 2개 이상 생성되는 시나리오

1.  Printer 인스턴스가 아직 생성되지 않았을 때 스레드 1이 getPrinter 메서드의 if문을 실행해 이미 인스턴스가 생성되었는지 확인한다. 현재 printer 변수는 null인 상태다.
2.  만약 스레드 1이 생성자를 호출해 인스턴스를 만들기 전 스레드 2가 if문을 실행해 printer 변수가 null인지 확인한다. 현재 null이므로 인스턴스를 생성하는 코드, 즉 생성자를 호출하는 코드를 실행하게 된다.
3.  스레드 1도 스레드 2와 마찬가지로 인스턴스를 생성하는 코드를 실행하게 되면 결과적으로 Printer 클래ㅡㅅ의 인스턴스가 2개 생성된다.

더보기

위 시나리오는 경합 조건(race condition)을 발생시킨다. 경합 조건이란 메모리와 같은 동일한 자원을 2개 이상의 스레드가 이용하려고 경합하는 현상을 말한다.

위의 시나리오를 발생시키기 위해 Thread.sleep(1)을 이ㅛㅇ해 스레드 실행을 고의적으로 1ms 동안 정지하도록 한다.

```java
public class UserThead extends Thread {
	public UserThead(String name)
	{
		super(name);
	}
	
	public void run()
	{
		Printer printer = Printer.getPrinter();
		printer.print(Thread.currentThread().getName() +
						" print using " + printer.toString() + ".");
		
	}
}

```

```java
public class Printer {
	private static Printer printer = null;

	private Printer()
	{
		
	}
	
	public static Printer getPrinter()
	{
		if(printer==null)
		{
			try 
			{
				Thread.sleep(1);
			}catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			printer = new Printer();	// Printer 인스턴스 생성	
		}
		return printer;
	}
	
	public void print(String str)
	{
		System.out.println(str);
	}
}
```

```java
public class Client {
	private static final int THREAD_NUM =5;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UserThead[] user = new UserThead[THREAD_NUM];
		for(int i=0;i<THREAD_NUM;i++)
		{
			user[i] = new UserThead((i+1)+"-thread");
			user[i].start();
		}
	}

}

```

```java
3-thread print using chapter06_싱글턴패턴.practice.p02_before_thread.Printer@488cc17
2-thread print using chapter06_싱글턴패턴.practice.p02_before_thread.Printer@c7b723d
4-thread print using chapter06_싱글턴패턴.practice.p02_before_thread.Printer@3f59682d
1-thread print using chapter06_싱글턴패턴.practice.p02_before_thread.Printer@c7b723d
5-thread print using chapter06_싱글턴패턴.practice.p02_before_thread.Printer@39f75240

```

위의 실행 결과에서 볼 수 있듯이 각 스레드마다 각기 다른 Printer 인스턴스를 사용해 출력한다. 그런데 이 경우 Printer 인스턴스가 1개 이상 생긴다 하더라도 이렇다 할 문제가 발생하지 않는다. 그러나 Printer 클래스가 상태를 유지해야 하는 경우에는 문제가 발생한다. 위와 같이 보여준 **Printer 클래스와 같이 counter 변수와 같은 값을 인스턴스가 유지해야 한다.**

```java
public class Printer {
	private static Printer printer = null;
	private int counter = 0;
	
	private Printer()
	{
		
	}
	
	public static Printer getPrinter()
	{
		if(printer==null)
		{
			try 
			{
				Thread.sleep(1);
			}catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			printer = new Printer();	// Printer 인스턴스 생성	
		}
		return printer;
	}
	
	public void print(String str)
	{
		counter++;
		System.out.println(str+counter);
	}
}

```

```java
3-thread print using chapter06_싱글턴패턴.practice.p02_before_thread.Printer@488cc17.1
2-thread print using chapter06_싱글턴패턴.practice.p02_before_thread.Printer@c7b723d.2
4-thread print using chapter06_싱글턴패턴.practice.p02_before_thread.Printer@3f59682d.1
1-thread print using chapter06_싱글턴패턴.practice.p02_before_thread.Printer@c7b723d.2
5-thread print using chapter06_싱글턴패턴.practice.p02_before_thread.Printer@39f75240.1
```

위의 결과와 같이 각각의 인스턴스마다 counter 변수를 각각 만들어 유지하기 때문에 문제가 발생한다.

### **6.3 해결책**

**다중 스레드 애플리케이션에서 발생하는 문제를 해결하는 방법**

-   정적 변수에 인스턴스를 만들어 바로 초기화하는 방법
-   인스턴스를 만드는 메서드에 동기화하는 방법

**정적 변수에 인스턴스를 만들어 바로 초기화하는 방법**

```java
public class Printer {
	private static Printer printer = new Printer();
	private int counter = 0;
	
	private Printer()
	{
		
	}
	
	public static Printer getPrinter()
	{
		return printer;
	}
	
	public void print(String str)
	{
		counter++;
		System.out.println(str+counter);
	}
}

```

정적 변수는 객체가 생성되기 전 클래스가 메모리에 로딩될 때 만들어져 초기화가 한 번만 실행된다.

또한 정적 변수는 프로그램이 시작될 때부터 종료될 때까지 없어지지 않고 메모리에 계속 상주하며 클래스에서 생성된 모든 객체에서 참조할 수 있다.

private static Printer printer = new Printer(); 구분이 실행되면 정적 변수 printer에 Printer 클래스 인스턴스가 바인딩되며 getPrinter라는 정적 메서드를 통해 참조되는 인스턴스를 얻어올 수 있다.

이 방법은 다중 스레드 환경에서 문제를 일으켰던 if(printer==null)이라는 조건 검사 구문을 원칙적으로 제거하기 위한 방법이다.

아래는 위의 코드를 실행한 결과이다. 아래 결과와 같이 오직 객체 하나만을 생성됨을 확인 할 수 있다.

```java
4-thread print using chapter06_싱글턴패턴.practice.p03_after_static_variable_init_instance.Printer@3f59682d
1-thread print using chapter06_싱글턴패턴.practice.p03_after_static_variable_init_instance.Printer@3f59682d
3-thread print using chapter06_싱글턴패턴.practice.p03_after_static_variable_init_instance.Printer@3f59682d
5-thread print using chapter06_싱글턴패턴.practice.p03_after_static_variable_init_instance.Printer@3f59682d
2-thread print using chapter06_싱글턴패턴.practice.p03_after_static_variable_init_instance.Printer@3f59682d
```

**인스턴스를 만드는 메서드에 동기화하는 방법**

```java
public class Printer {
	private static Printer printer = null;
	private int counter = 0;
	
	private Printer()
	{
		
	}
	
	// synchronized 키워드는 다중 스레드 환경에서 여러 스레드가 
	// getPrinter 메서드를 소유하는 객체에 접근하는 것을 방지한다.
	public synchronized static Printer getPrinter()
	{
		if(printer==null)
		{
			printer = new Printer();
		}
		return printer;
	}
	
	public void print(String str)
	{
		synchronized (this) {	// 오직 하나의 스레드만 접근을 허용함
			counter++;
			System.out.println(str+counter);
		}
	}
}

```

위의 코드는 다중 스레드 환경에서 동시에 여러 스레드가 getPrinter 메서드를 소유하는 객체에 접근하는 것을 방지한다.

아래 결과를 통해서 Printer 클래스의 인스턴스가 오직 하나의 인스턴스만 생성하는 것을 확인할 수 있다.

```java
1-thread print using chapter06_싱글턴패턴.practice.p04_after_synchronized_method.Printer@48eeb158
2-thread print using chapter06_싱글턴패턴.practice.p04_after_synchronized_method.Printer@48eeb158
3-thread print using chapter06_싱글턴패턴.practice.p04_after_synchronized_method.Printer@48eeb158
4-thread print using chapter06_싱글턴패턴.practice.p04_after_synchronized_method.Printer@48eeb158
5-thread print using chapter06_싱글턴패턴.practice.p04_after_synchronized_method.Printer@48eeb158

```

**counter 변수의 경합 조건(race condition) 문제**

```java
public class Printer {
	private static Printer printer = null;
	private int counter = 0;
	
	private Printer()
	{
		
	}
	
	// synchronized 키워드는 다중 스레드 환경에서 여러 스레드가 
	// getPrinter 메서드를 소유하는 객체에 접근하는 것을 방지한다.
	public synchronized static Printer getPrinter()
	{
		if(printer==null)
		{
			printer = new Printer();
		}
		return printer;
	}
	
	public void print(String str)
	{
		counter++;
		System.out.println(str+counter);
	}
}
```

```java
2-thread print using chapter06_싱글턴패턴.practice.p03_after_static_variable_init_instance.Printer@3f59682d.3
1-thread print using chapter06_싱글턴패턴.practice.p03_after_static_variable_init_instance.Printer@3f59682d.5
5-thread print using chapter06_싱글턴패턴.practice.p03_after_static_variable_init_instance.Printer@3f59682d.3
4-thread print using chapter06_싱글턴패턴.practice.p03_after_static_variable_init_instance.Printer@3f59682d.4
3-thread print using chapter06_싱글턴패턴.practice.p03_after_static_variable_init_instance.Printer@3f59682d.4
```

Printer 객체가 하나만 생성되었음에도 여전히 counter 변수의 값이 이상하게 출력된다. 이는 여러 개의 스레드가 하나뿐인 counter 변수 값에 동시에 접근해 갱신하기 때문이다.

따라서 이 문제를 해결하려면 print 메서드의 counter 변수를 변경하는 부분도 동기화할 필요가 있다.

```java
public class Printer {
	private static Printer printer = null;
	private int counter = 0;
	
	private Printer()
	{
		
	}
	
	// synchronized 키워드는 다중 스레드 환경에서 여러 스레드가 
	// getPrinter 메서드를 소유하는 객체에 접근하는 것을 방지한다.
	public synchronized static Printer getPrinter()
	{
		if(printer==null)
		{
			printer = new Printer();
		}
		return printer;
	}
	
	public void print(String str)
	{
		synchronized (this) {	// 오직 하나의 스레드만 접근을 허용함
			counter++;
			System.out.println(str+counter);
		}
	}
}

```

위와 같이 counter 변수를 증가시키는 부분에 synchronized를 설정하면 다중 스레드가 counter 변수의 값을 동시에 갱신하지 않게 된다.

```java
2-thread print using chapter06_싱글턴패턴.practice.p04_after_synchronized_method.Printer@c7b723d.1
1-thread print using chapter06_싱글턴패턴.practice.p04_after_synchronized_method.Printer@c7b723d.2
3-thread print using chapter06_싱글턴패턴.practice.p04_after_synchronized_method.Printer@c7b723d.3
4-thread print using chapter06_싱글턴패턴.practice.p04_after_synchronized_method.Printer@c7b723d.4
5-thread print using chapter06_싱글턴패턴.practice.p04_after_synchronized_method.Printer@c7b723d.5
```

### **6.4 싱글턴 패턴과 정적 클래스**

실제로 굳이 싱글턴 패턴을 사용하지 않고 정적 메서드로만 이루어진 정적 클래스(static class)를 사용해도 동일한 효과를 얻을 수 있다.

아래 코드는 Printer 클래스를 싱글턴 패턴으로 구현하지 않고 정적 클래스로 구현한 예이다.

```java
public class Printer {
	private static int counter = 0;
	
	private Printer()
	{
		
	}
	
	public synchronized static void print(String str)
	{
			counter++;
			System.out.println(str+counter);
	}
}

```

```java
public class UserThead extends Thread {
	public UserThead(String name)
	{
		super(name);
	}
	
	public void run()
	{
		Printer.print(Thread.currentThread().getName() + " print using " + ".");
		
	}
}

```

```java
public class Main {
	private static final int THREAD_NUM =5;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UserThead[] user = new UserThead[THREAD_NUM];
		for(int i=0;i<THREAD_NUM;i++)
		{
			user[i] = new UserThead((i+1)+"-thread");
			user[i].start();
		}
	}

}

```

```java
1-thread print using .1
3-thread print using .2
2-thread print using .3
5-thread print using .4
4-thread print using .5
```

**정적 클래스를 이용하는 방법이 싱글턴 패턴을 이용한 방법과 차이가 있는것은 무엇인가?**

-   객체를 전혀 생성하지 않고 메서드를 사용한다는 점
-   정적 메서드를 사용하므로 일반적으로 실행할 때 바인딩 되는(컴파일 타임에 바인딩되는) 인스턴스 메서드를 사용하는 것보다 성능 면에서 우수하다.

**정적 클래스를 사용할 수 없는 경우**

-   인터페이스를 구현해야 하는 경우

이유는 정적 메서드는 인터페이스에서 사용할 수 없다. 아래와 같은 코드는 혀용되지 않는다.

```java
public interface Printer{
	public static void print(String str);	// 허용되지 않음
}

public class RealPrinter315 implements Printer{
	public synchronized static void print(String str){
    	// 실제 프린터 하드웨어를 조작하는 코드
    }
}
```

인터페이스를 사용하는 주된 이유는 대체 구현이 필요한 경우이다. 이는 특히 모의 객체를 사용해 단위 테스트를 수행할 때 매우 중요하다.

아래 코드는 UsePrinter 클래스를 테스트하는 경우이다.

```java
public class UsePrinter {
	public void doSomething(Printer printer) 
	{
		String str;
        
        // ...
        
        str = "dosomething";
        
        RealPrinter315.print(str);
		
	}
}

```

```java
public class RealPrinter315{
	public synchronized static void print(String str){
    	// 실제 프린터 하드웨어를 조작하는 코드
    }
}
```

가령 실제로 출력을 해야 하는 프린터가 아직 준비가 되어 있찌 않거나 준비가 되었떠라도 테스트할 때 결과가 올바른지를 확인하려고 매번 프린트 출력물을 검사하는 것은 매우 번거로운 일이다.

또한 프린터에 따라 테스트 실행 시간에 병목 현상이 나타날 수도 있다. 단위 테스트가 갖추어야 하는 가장 중요한 특성은 빠르게 실행되어야 한다는 점을 상기하라.

이 경우 UsePrinter 클래스의 단위 테스트를 실행 시 실제 프린터를 테스트용 가짜 프린터 객체로 대체하는 것이 좋다.

**Printer 인터페이스를 참조하는 UsePrinter 클래스**

![Printer 인터페이스를 참조하는 UsePrinter 클래스](https://github.com/yonghwankim-dev/DesignPattern/blob/master/DesignPattern/src/chapter06_%EC%8B%B1%EA%B8%80%ED%84%B4%ED%8C%A8%ED%84%B4/diagrams/UsePrinter_using-Printer.png)

위와 같이 설계를 변경 시 UsePrinter 클래스는 필요에 따라 실제의 프린터 하드우에어를 구동하는 RealPrinter315나 FakePrint 클래스를 사용할 수 있게 한다.

**Printer 인터페이스를 구현하는 RealPrinter315 클래스**

```java
public class RealPrinter315 implements Printer{	// 싱글턴 패턴을 사용
	private static Printer printer = null;
	private RealPrinter315() 
	{
		
	}
	
	public synchronized static Printer getPrinter() 
	{
		if(printer==null)
		{
			printer = new RealPrinter315();
		}
		return printer;
	}

	@Override
	public void print(String str) {
		// 실제 프린터 하드웨어드를 조작하는 코드
	}
}
```

```java
public class UsePrinter {
	public void doSomething(Printer printer) 
	{
		String str;
		
		str = "doSomething";
		
		printer.print(str);
		
	}
}
```

```java
public class FakePrinter implements Printer { // 테스트용 가짜 데이터
	private String str;

	@Override
	public void print(String str) 
	{
		this.str = str;
	}
	
	public String get() 
	{
		return str; 
	}
	
	
}

```

```java
public class UsePrinterTest extends TestCase{
	public void testdoSomething()
	{
		FakePrinter fake = new FakePrinter();
		UsePrinter u = new UsePrinter();
		u.doSomething(fake);
		assertEquals("this is a test", fake.get());
	}
}

```

FakePrinter 클래스는 실제 출력을 실행하지 않고 doSomething 메서드를 실행할 때 프린터로 올바른 값이 전달되었는지 확인해야 한다. 따라서 전달된 문자열을 str 문자열 변수에 저장하고 나중에 테스트 케이스에서 get 메서드를 사용해 확인하게 한다.

### **References**

> JAVA 객체지향 디자인 패턴  
> https://github.com/walbatrossw/java-design-patterns/blob/master/ch06-singleton-patterns/ch06-singleton-patterns.md
