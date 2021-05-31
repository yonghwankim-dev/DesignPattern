### **8.1 커맨드 패턴이란?**

**커맨드 패턴은 이벤트가 발생했을 때 실행될 기능이 다양하면서도 변경이 필요한 경우에 이벤트를 발생시키는 클래스를 변경하지 않고 재사용하고자 할 때 유용하다.**

예를 들어 'FileOpen'이라는 메뉴 항목이 선택되었을 때 실행될 기능과 'FileClose'라는 메뉴 항목이 선택되었을 때 실행되는 기능은 다를 것이다. 이런 경우 MenuItem 클래스에서 직접 구체적인 기능을 구현한다면 'FileOpen' 메뉴 항목을 위한 MenuItem 클래스와 'FileClose' 메뉴 항목을 위한 MenuItem 클래스를 각각 구현해야 한다. MenuItem 클래스는 하나이므로 'FileOpen'과 'FileClose' 메뉴 항목을 재사용하기 어려울 수 있기 때문이다.

커맨드 패턴은 실행될 기능을 캡슐화함으로써 기능의 실행을 요구하는 호출자(Invoker) 클래스와 실제 기능을 실행하는 수신자(Receiver) 클래스 사이의 의존성을 제거한다. 따라서 실행될 기능의 변경에도 호출자 클래스를 수정 없이 그대로 사용할 수 있도록 해준다.

**커맨드 패턴의 컬레보레이션**

![커맨드 패턴의 컬레보레이션](https://github.com/yonghwankim-dev/DesignPattern/blob/master/DesignPattern/src/chapter08_%EC%BB%A4%EB%A7%A8%EB%93%9C%ED%8C%A8%ED%84%B4/diagram/command-pattern_collaboration.png)

-   Command : 실행될 기능에 대한 인터페이스, 실행될 기능을 execute 메서드로 선언함
-   ConcreteCommand : 실제로 실행되는 기능을 구현. 즉, Command라는 인터페이스를 구현함
-   Invoker : 기능의 실행을 요청하는 호출자 클래스
-   Receiver : ConcreteCommand에서 execute 메서드를 구현할 때 필요한 클래스, 즉, ConcreteCommand의 기능을 실행하기 위해 사용하는 수신자 크래스

**커맨드 패턴의 순차 다이어그램**

![커맨드 패턴의 순차 다이어그램](https://github.com/yonghwankim-dev/DesignPattern/blob/master/DesignPattern/src/chapter08_%EC%BB%A4%EB%A7%A8%EB%93%9C%ED%8C%A8%ED%84%B4/diagram/command-pattern_seq.png)

1.  클라이언트가 원하는 커맨드 객체를 생성
2.  커맨드 객체를 Invoker 객체에게 바인딩한다.
3.  나중에 Invoker 객체에서는 바인딩된 커맨드 객체의 execute 메서드를 호출한다.
4.  execute 메서드는 Receiver 객체의 action 메서드를 호출함으로써 원하는 기능을 실행한다.

### **8.2 만능 버튼 만들기**

눌리면 특정 기능을 수행하는 버튼을 생각해보자. 예를 들어 버튼을 눌렀을 때 램프의 불이 커지는 프로그램을 개발하려면 버튼이 눌려졌음을 인식하는 Button 클래스, 불을 켜는 기능을 제공하는 Lamp 클래스가 필요하다. 그리고 버튼이 눌렸을 때(즉, Button 클래스의 pressed 메서드를 호출해 실행될 때) 램프를 켜려면 Button 클래스는 Lamp 객체를 참조해야 한다.

**램프를 켜는 버튼을 설게한 클래스 다이어그램**

![램프를 켜는 버튼을 설계한 클래스 다이어그램](https://github.com/yonghwankim-dev/DesignPattern/blob/master/DesignPattern/src/chapter08_%EC%BB%A4%EB%A7%A8%EB%93%9C%ED%8C%A8%ED%84%B4/diagram/button-lamp_class-diagram.png)

**램프를 켜는 버튼을 설계한 클래스 다이어그램 기반 코드**

```java
public class Lamp {
	public void turnOn()
	{
		System.out.println("Lamp On");
	}
}
```

```java
public class Button {
	private Lamp theLamp;
	
	public Button(Lamp theLamp)
	{
		this.theLamp = theLamp;
	}
	
	public void pressed()
	{
		theLamp.turnOn();
	}
}
```

```java
// 버튼을 눌렀을때 램프를 켜는 프로그램
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lamp lamp = new Lamp();
		Button lampButton = new Button(lamp);
		lampButton.pressed();	// Lamp On
	}

}
```

Button 클래스의 생성자를 이용해 불을 켤 Lamp 객체를 전달한다. 그리고 Button 클래스의 pressed 메서드가 호출되면 생성자를 통해 전달받은 Lamp 객체의 turnOn 메서드를 호출해 불을 켠다.

### **8.3 문제점**

-   누군가 버튼을 눌렀을 때 램프가 켜지는 대신 다른 기능을 실행하게 하려면 어떤 변경 작업을 해야 하는가? 예를 들어 버튼을 눌렀을 때 알람이 시작되게 하려면?
-   버튼을 누르는 동작에 따라 다른 기능을 실행하게 하려면 어떤 변경 작업을 해야 하는가? 예를 들어 버튼을 처음 눌렀을 때는 램프를 켜고, 두 번째 눌렀을 때는 알람을 동작하게 하려면?

**버튼을 눌렀을 때 다른 기능을 실행하는 경우**

램프를 켜는 대신 알람을 시작하게 하려면 Button 클래스의 pressed 메서드를 수정해야 한다. 다음 코드는 버튼을 눌렀을때 알람이 동작하는 프로그램의 코드이다.

```java
public class Alarm {
	public void start()
	{
		System.out.println("Alarming...");
	}
}
```

```java
public class Button {
	private Alarm theAlarm;
	
	public Button(Alarm theAlarm)
	{
		this.theAlarm = theAlarm;
	}
	
	public void pressed()
	{
		theAlarm.start();	// 버튼을 누르면 알람이 울림
	}
}
```

```java
// 버튼을 눌렀을때 다른 기능을 실행하는 경우
// 램프를 켜는 대신 알람을 시작하게 Alarm 클래스를 추가하는 프로그램
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Alarm alarm = new Alarm();
		Button alarmButton = new Button(alarm);
		alarmButton.pressed(); // Alarming...
		
	}
}
```

위와 같이 버튼을 눌렀을 때 알람이 울리게 할 수 있다. 그러나 기능을 변경하려고 기존 Button 클래스의 코드를 수정하는 것은 OCP(OpenClosed-Principle)에 위배된다. **즉, 버튼을 눌렀을 때 지정된 특정 기능(처음에는 램프 켜기)만 고정적으로 수행하도록 만든 처음 디자인은 다른 기능(알람 동작)을 추가할 때 위 사례처럼 pressed 메서드 전체를 변경해야 하므로 OCP를 위배하는 것이다.**

**버튼을 누르는 동작에 따라 다른 기능을 실행하는 경우**

버튼을 누르는 동작에 따라 다른 기능을 실행하게 하려면 기능이 실행되는 시점에 필요한 프로그램(혹은 메서드)을 선택할 수 있어야 한다. 예를 들어 버튼을 처음 눌렀을 때는 램프를 켜고 두 번 눌렀을 때는 알람을 동작하게 할 경우에 Button 클래스는 2가지 기능(램프 켜기와 알람 동작)을 모두 구현할 수 있어야 한다.

아래의 코드는 램프 켜기와 알람을 모두 구현하기 위해 변경한 Button 클래스의 코드이다.

```java
public class Lamp {
	public void turnOn()
	{
		System.out.println("Lamp On");
	}
}
```

```java
public class Alarm {
	public void start()
	{
		System.out.println("Alarming...");
	}
}
```

```java
enum Mode{LAMP, ALARM};

public class Button {
	private Lamp theLamp;
	private Alarm theAlarm;
	private Mode theMode;
	
	public Button(Lamp theLamp, Alarm theAlarm)
	{
		this.theLamp = theLamp;
		this.theAlarm = theAlarm;
	}
	
	public void setMode(Mode mode)	// 램프 또는 알람 모드를 설정함
	{
		this.theMode = mode;
	}
	
	public void pressed()
	{
		switch(theMode)	// 설정된 모드에 따라 램프를 켜거나 알람을 울림
		{
		case LAMP:	// 램프 모드면 램프를 켬
			theLamp.turnOn();
			break;
		case ALARM:	// 알람 모드면 알람을 울리게 됨
			theAlarm.start();
			break;
		}
	}
}
```

```java
// 버튼을 누르는 동작에 따라 다른 기능을 실행하는 경우
// 버튼을 처음 눌렀을대는 램프를 켜고, 두번 눌럿을 때는 알람을 동작하게 한다.
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lamp lamp = new Lamp();
		Alarm alarm = new Alarm();
		Button button = new Button(lamp,alarm);
		
		button.setMode(Mode.LAMP);
		button.pressed();
		
		button.setMode(Mode.ALARM);
		button.pressed();
		
	}

}
```

이 경우 역시 버튼을 눌렀을 때의 기능을 변경하기 위해 다시 Button 클래스의 코드를 수정하였다. 이러한 수정은 버튼을 눌렀을 때 필요한 기능을 새로 추가할 때마다 반복적으로 발생할 것이다. 즉, Button 클래스에 새로 기능을 추가할 때마다 코드를 수정해야 한다면 Button 클래스는 재사용하기 어렵다.

### **8.4 해결책**

버튼을 눌렀을 대 실행될 기능을 Button 클래스 외부에서 제공받아 캡슐화해 pressed 메서드에서 호출하는 방법을 사용할수가 있다. 예를 들어 램프를 켜는 경우에는 theLamp.turnOn 메서드를 호출하고 알람이 동작하는 경우에는 theAlarm.start 메서드를 호출하도록 pressed 메서드를 수정해야 한다.

**개선된 Button 클래스의 다이어그램**

![개선된 Button 클래스의 다이어그램](https://github.com/yonghwankim-dev/DesignPattern/blob/master/DesignPattern/src/chapter08_%EC%BB%A4%EB%A7%A8%EB%93%9C%ED%8C%A8%ED%84%B4/diagram/command-pattern_button.png)

1.  Button 클래스는 램프 켜기 또는 알람 동작 등의 기능을 실행할 때 Lamp 클래스의 turnOn 메서드나 Alarm 클래스의 start 메서드를 직접 호출하지 않는다.
2.  대신 미리 약속된 Command 인터페이스의 execute 메서드를 호출한다.
3.  LampOnCommand 클래스에서는 execute 메서드를 구현해 램프를 켜는 기능을 구현한다. 즉, LampOnCommand 클래스는 execute 메서드에서 Lamp 클래스의 turnOn 메서드를 호출해 램프를 켜는 기능을 구현한다.
4.  AlaramStartCommand 클래스는 알람이 울리게 하려고 Command 인터페이스의 execute 메서드를 구현해 Alarm 클래스의 start 메서드를 호출한다.

**개선된 Button 클래스의 다이어그램 기반 코드**

```java
public interface Command {
	public void execute();
}
```

```java
public class Button {
	private Command theCommand;
	
	public Button(Command theCommand)
	{
		setCommand(theCommand);
	}
	
	public void setCommand(Command newCommand)
	{
		this.theCommand = newCommand;
	}
	
	public void pressed()		// 버튼이 눌리면 주어진 Command의 execute 메서드를 호출함.
	{
		theCommand.execute();
	}
}
```

```java
public class Lamp {
	public void turnOn()
	{
		System.out.println("Lamp On");
	}
}
```

```java
public class LampOnCommand implements Command{
	private Lamp theLamp;
	
	public LampOnCommand(Lamp theLamp)
	{
		this.theLamp = theLamp;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		theLamp.turnOn();
	}
}
```

```java
public class Alarm {
	public void start()
	{
		System.out.println("Alarming...");
	}
}
```

```java
public class AlarmStartCommand implements Command{
	private Alarm theAlarm;
	
	public AlarmStartCommand(Alarm theAlarm) {
		this.theAlarm = theAlarm;
	}
    
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		theAlarm.start();
	}

}

```

```java
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lamp lamp = new Lamp();
		Command lampOnCommand = new LampOnCommand(lamp);
		
		Button button1 = new Button(lampOnCommand);	// 램프를 켜는 커맨드를 설정함
		button1.pressed(); // 버튼이 눌리면 램프 켜는 기능이 실행됨
		
		Alarm alarm = new Alarm();
		Command alarmOnCommand = new AlarmStartCommand(alarm);
		
		Button button2 = new Button(alarmOnCommand);	// 알람을 울리는 커맨드를 설정함
		button2.pressed(); // 이제 버튼이 눌리면 알람을 울리는 기능이 실행됨
		
		button2.setCommand(lampOnCommand);
		button2.pressed();	// 이제는 램프를 켜는 기능이 실행됨	
	}
}
```

Command 인터페이스를 구현하는 LampOnCommand와 AlarmCommand 객체를 Button 객체에 설정한다.

Button 클래스의 pressed 메서드에서 Command 인터페이스의 execute 메서드를 호출할 수 있게 함으로써 LampOnCommand와 AlarmCommand 클래스의 execute 메서드를 실행할 수가 있다.

즉, 버튼을 눌렀을 때 필요한 임의의 기능은 Command 인터페이스를 구현한 클래스의 객체를 Button 객체에 설정해서 실행할 수 있다. 따라서 Button 클래스는 소스 코드를 변경하지 않으면서도 다양한 동작을 구현할 수 있게 된다.

**램프를 켜거나 끄는 기능을 추가한 Button 클래스 다이어그램**

![램프를 켜거나 끄는 기능을 추가한 Button 클래스](https://github.com/yonghwankim-dev/DesignPattern/blob/master/DesignPattern/src/chapter08_%EC%BB%A4%EB%A7%A8%EB%93%9C%ED%8C%A8%ED%84%B4/diagram/command-pattern_button_Improve.png)

램프를 끄는 기능을 구현하기 위해 LampOffCommand 클래스가 Command 인터페이스를 구현하도록 한다. Lamp 클래스에는 기존의 켜는 기능을 위한 turnOn 메서드 분만 아니라 끄기 위한 turnOff 메서드를 구현한다.

**램프를 켜거나 끄는 기능을 추가한 Button 클래스 다이어그램 기반 코드**

```java
public interface Command {
	public void execute();
}
```

```java
public class Button {
	private Command theCommand;
	
	public Button(Command theCommand)
	{
		setCommand(theCommand);
	}
	
	public void setCommand(Command newCommand)
	{
		this.theCommand = newCommand;
	}
	
	public void pressed()		// 버튼이 눌리면 주어진 Command의 execute 메서드를 호출함.
	{
		theCommand.execute();
	}
}

```

```java
public class Lamp {
	public void turnOn()
	{
		System.out.println("Lamp On");
	}
	public void turnOff()
	{
		System.out.println("Lamp Off");
	}
}
```

```java
public class LampOnCommand implements Command{
	private Lamp theLamp;
	
	public LampOnCommand(Lamp theLamp)
	{
		this.theLamp = theLamp;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		theLamp.turnOn();
	}
	
}
```

```java
public class LampOffCommand implements Command{
	private Lamp theLamp;
	
	public LampOffCommand(Lamp theLamp)
	{
		this.theLamp = theLamp;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		theLamp.turnOff();
	}
	
}
```

```java
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lamp lamp = new Lamp();
		Command lampOnCommand = new LampOnCommand(lamp);
		Command lampOffCommand = new LampOffCommand(lamp);
		
		Button button1 = new Button(lampOnCommand);	// 램프를 켜는 커맨드를 설정함
		button1.pressed();	// 버튼을 누르면 램프가 켜짐
		
		button1.setCommand(lampOffCommand);	// 램프를 끄는 커맨드를 설정함
		button1.pressed();	// 이제 버튼을 누르면 램프가 꺼짐
	}

}
```

```java
Lamp On
Lamp Off
```
