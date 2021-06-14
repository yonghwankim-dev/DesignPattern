### **14.1 컴퍼지트 패턴**

컴퍼지트 패턴은 부분-전체(Part-Whole)의 관계를 갖는 객체들을 정의할 때 유용하다. 예를 들어 Computer가 존재하면 그에 따른 Monitor, Body 등의 부품이 존재하고 Computer는 전체, Monitor, Body와 같은 부품들은 부분이 된다. 이러한 경우 부분 객체의 추가나 삭제 등이 있어도 전체 객체의 클래스 코드를 변경하지 않으면 컴퍼지트 패턴은 유용하다.

> 컴퍼지트 패턴은 전체-부분의 관게를 갖는 객체들 사이의 관계를 정의할 때 유용하다. 그리고 클라이언트는 전체와 부분을 구분하지 않고 동일한 인터페이스를 사용할 수 있다.

**컴퍼지트 패턴의 컬레보레이션**

[##_Image|kage@mLMDO/btq67N1A0zP/r9AkZm6dNPULiWg2uosQPK/img.png|alignCenter|data-origin-width="1252" data-origin-height="489" data-ke-mobilestyle="widthOrigin"|컴퍼지트 패턴의 컬레보레이션||_##]

-   Component : 구체적인 부분, 즉 Leaf 클래스와 전체에 해당하는 Composite 클래스에 공통 인터페이스를 정의한다.
-   Leaf : 구체적인 부분 클래스로 Composite 객체의 부품으로 설정한다.
-   Composite : 전체 클래스로 복수 개의 Component를 갖도록 정의한다. 그러므로 복수 개의 Leaf, 심지어 복수 개의 Composite 객체를 부분으로 가질 수 있다.

**컴퍼지트 패턴의 순차 다이어그램**

[##_Image|kage@qivIo/btq69WDUzMC/wRiMjKAL2CE8tUpqF9RHCK/img.png|alignCenter|data-origin-width="560" data-origin-height="399" data-ke-mobilestyle="widthOrigin"|컴퍼지트 패턴의 순차 다이어그램||_##]

1.  Client는 Composite 객체에 operation 메서드를 호출한다.
    -   예를 들면 Computer 클래스의 getPrice 메서드에 해당된다.
2.  Composite 객체는 안에 포함되어 있는 각 Leaf 객체에 동일한 operation 메서드를 호출하고 이 결과를 조합한다.
    -   예를 들면 Computer 클래스의 getPrice 메서드는 자신의 부품인 Keyboard, Body, Monitor 등의 객체에 getPrice 메서드를 호출하고 이 결과를 합해서 컴퓨터의 가격을 구한다.

### **14.2 컴퓨터에 추가 장치 지원하기**

컴퓨터(Computer 클래스)는 데이터를 입력받는 키보드(Keyboard 클래스), 이를 처리하는 본체(Body 클래스), 처리 결과를 보여주는 모니터(Monitor 클래스)가 존재한다. 컴퓨터(Computer) 클래스는 이들 구성 장치(키보드, 본체, 모니터)를 포함하는 것으로 구현할 수 있다.

클래스 다이어그램에서는 Computer 클래스와 구성 장치 사이의 관계를 합성(Composition) 관계로 표현할 수 있다.

**Computer 클래스의 클래스 다이어그램**

[##_Image|kage@djLl0M/btq66uuQGjU/yr0FxxYdLioMYi3jDODk10/img.png|alignCenter|data-origin-width="744" data-origin-height="606" data-ke-mobilestyle="widthOrigin"|Computer 클래스의 클래스 다이어그램||_##]

**Computer 클래스의 클래스 다이어그램 기반 구현**

```
public class Keyboard {
	private int price;
	private int power;
	
	public Keyboard(int price, int power) {
		this.price = price;
		this.power = power;
	}

	public int getPrice() {
		return price;
	}

	public int getPower() {
		return power;
	}
}
```

```
public class Body {
	private int price;
	private int power;
	
	public Body(int price, int power) {
		this.price = price;
		this.power = power;
	}

	public int getPrice() {
		return price;
	}

	public int getPower() {
		return power;
	}	
}
```

```
public class Monitor {
	private int price;
	private int power;
	
	public Monitor(int price, int power) {
		this.price = price;
		this.power = power;
	}

	public int getPrice() {
		return price;
	}

	public int getPower() {
		return power;
	}
	
}
```

```
public class Computer {
	private Body body;
	private Keyboard keyboard;
	private Monitor monitor;
	
	public void addBody(Body body)
	{
		this.body = body;
	}
	
	public void addKeyboard(Keyboard keyboard)
	{
		this.keyboard = keyboard;
	}
	
	public void addMonitor(Monitor monitor)
	{
		this.monitor = monitor;
	}
	
	public int getPrice()
	{
		int bodyPrice = body.getPrice();
		int keyboardPrice = keyboard.getPrice();
		int monitorPrice = monitor.getPrice();
		
		return bodyPrice + keyboardPrice + monitorPrice;
	}
	
	public int getPower()
	{
		int bodyPower = body.getPower();
		int keyboardPower = keyboard.getPower();
		int monitorPower = monitor.getPower();
		
		return bodyPower + keyboardPower + monitorPower;
	}
}

```

```
public class Client {

	public static void main(String[] args) {
		// 컴퓨터의 부품으로 Body, Keyboard, Monitor 객체를 생성함
		Body body = new Body(100, 70);
		Keyboard keyboard = new Keyboard(5, 2);
		Monitor monitor = new Monitor(20, 30);
		
		// Computer 객체를 생성하고 부품 객체들을 설정함
		Computer computer = new Computer();
		computer.addBody(body);
		computer.addKeyboard(keyboard);
		computer.addMonitor(monitor);
		
		// 컴퓨터의 가격과 전력 소비량을 구함
		int computerPrice = computer.getPrice();
		int computerPower = computer.getPower();
		System.out.println("Computer Price : " + computerPrice + "W");	//125W
		System.out.println("Computer Power : " + computerPower + "만 원");//102만원
		
	}
}
```

addBody, addKeyboard, addMonitor 메서드는 각각 Computer 클래스의 부품으로 Body 객체, Keyboard 객체, Monitor 객체를 설정한다. getPrice 메서드는 각각의 객체에 대한 가격을 반환한다.

### **14.3 문제점**

-   현재 Computer 클래스는 Body, Keyboard, Monitor 객체로 구성되어 있다. 만약 Computer 클래스의 부품으로 Speaker 클래스를 추가한다면? 또는 Mouse 클래스를 추가한다면?

현재 Computer 클래스의 문제점은 부품이 추가될때마다 Computer 클래스를 수정해야 하는 문제점이 발생한다.

**Speaker 클래스의 추가**

[##_Image|kage@b4WbwZ/btq66t3PO4W/QGIjy3EJF2tgWnrIuCTHy0/img.png|alignCenter|data-origin-width="386" data-origin-height="386" data-ke-mobilestyle="widthOrigin"|Speaker 클래스의 추가||_##]

**Speaker 클래스의 코드**

```
public class Speaker {
	private int price;
	private int power;
	
	public Speaker(int price, int power) {
		this.price = price;
		this.power = power;
	}

	public int getPrice() {
		return price;
	}

	public int getPower() {
		return power;
	}
	
}
```

**수정된 Computer 클래스 코드**

```
public class Computer {
	private Body body;
	private Keyboard keyboard;
	private Monitor monitor;
	private Speaker speaker;
	
	public void addBody(Body body)
	{
		this.body = body;
	}
	
	public void addKeyboard(Keyboard keyboard)
	{
		this.keyboard = keyboard;
	}
	
	public void addMonitor(Monitor monitor)
	{
		this.monitor = monitor;
	}
	
	public void addSpeaker(Speaker speaker)
	{
		this.speaker = speaker;
	}
	
	public int getPrice()
	{
		int bodyPrice = body.getPrice();
		int keyboardPrice = keyboard.getPrice();
		int monitorPrice = monitor.getPrice();
		int speakerPrice = speaker.getPrice();
		
		return bodyPrice + keyboardPrice + monitorPrice + speakerPrice;
	}
	
	public int getPower()
	{
		int bodyPower = body.getPower();
		int keyboardPower = keyboard.getPower();
		int monitorPower = monitor.getPower();
		int speakerPower = speaker.getPower();
		return bodyPower + keyboardPower + monitorPower + speakerPower;
	}
}

```

Speaker 클래스가 추가로 인하여 Computer 클래스의 필드 및 메소드를 수정해야 한다.

**새로운 부품의 추가에 따른 문제점**

-   새로운 부품에 대한 참조를 필드로 추가해야한다.
-   새로운 부품 객체를 설정하는 setter 메서드로 addDevice와 같은 메서드를 추가해야한다.
-   getPrice, getPower 등과 같이 컴퓨터의 부품을 이용하는 모든 메서드에서는 새롭게 추가된 부품 객체를 이용할 수 있도록 수정해야 한다.

위와 같이 새로운 부품의 추가에 따라서 Computer 클래스를 수정하게 되면 이는 OCP(Open-Closed Principle)에 위반된다. 즉, Computer 클래스에 부품을 추가(확장)할 때 Computer 클래스의 코드가 변경되지 않아야 하지만 현재 설계나 구현에서는 Computer 클래스의 코드를 변경할 수밖에 없다.

### **14.4 해결책**

위와 같은 문제점을 해결하기 위해서는 **구체적인 부품들을 일반화한 클래스를 정의하고 이를 Computer 클래스가 가리키게 하는 것이 올바른 설계이다.**

**일반화된 부품을 갖도록 개선한 Computer 클래스 설계**

[##_Image|kage@5OrmF/btq651zHdZg/xtRxWWtkQ6j8KfMgCE0gD0/img.png|alignCenter|data-origin-width="1182" data-origin-height="468" data-ke-mobilestyle="widthOrigin"|일반화된 부품을 갖도록 개선한 Computer 클래스 설계||_##]

**클래스 다이어그램의 주요 개선점**

-   Computer가 가질 수 있는 부품들을 일반화해 ComputerDevice라는 클래스를 정의했다. ComputerDevice 클래스는 Keyboard, Body, Monitor 등 구체적인 부품 클래스의 공통 기능만 가지며 실제로 존재하는 구체적인 부품이 될 수는 없다. 즉, ComputerDevice 객체를 실제로 생성할 수는 없다. 그러므로 ComputerDevice 클래스는 추상 클래스가 된다.
-   Keyboard, Body, Monitor 클래스는 ComputerDevice 클래스의 자식 클래스로 정의된다.
-   Computer 클래스는 복수 개(0..\*)의 ComputerDevice 객체를 갖는 것으로 표현한다.
-   Computer 클래스도 ComputerDevice 클래스의 하위 클래스로 정의한다. 즉, Computer 클래스도 ComputerDevice 클래스의 일종이라고 볼 수 있다. 그러므로 ComputerDevice 클래스를 이용하면 클라이언트 프로그램은 Body, Keyboard 등과 동일한 방식으로 COmputer 클래스를 사용할 수 있게 된다.

**일반화된 부품을 갖도록 개선한 Computer 클래스 설계 구현 코드**

```
public abstract class ComputerDevice {
	public abstract int getPrice();
	public abstract int getPower();
}
```

```
public class Keyboard extends ComputerDevice {
	private int price;
	private int power;
	
	public Keyboard(int price, int power) {
		this.price = price;
		this.power = power;
	}

	public int getPrice() {
		return price;
	}

	public int getPower() {
		return power;
	}
		
}
```

```
public class Monitor extends ComputerDevice{
	private int price;
	private int power;
	
	public Monitor(int price, int power) {
		this.price = price;
		this.power = power;
	}

	public int getPrice() {
		return price;
	}

	public int getPower() {
		return power;
	}
	
}
```

```
public class Body extends ComputerDevice {
	private int price;
	private int power;
	
	public Body(int price, int power) {
		this.price = price;
		this.power = power;
	}

	public int getPrice() {
		return price;
	}

	public int getPower() {
		return power;
	}
	
}
```

```
public class Computer {
	// 복수개의 ComputerDevice 객체를 가리킴
	private List<ComputerDevice> components = new ArrayList<ComputerDevice>();
	
	// ComputerDevice 객체를 Computer 클래스에 추가함
	public void addComponent(ComputerDevice component)
	{
		components.add(component);
	}
	
	// CompouterDevice 객체를 Computer 클래스에서 제거함
	public void removeComponent(ComputerDevice component)
	{
		components.remove(component);
	}
	
	// 전체 가격을 포함하는 각 부품의 가격을 합산함
	public int getPrice()
	{
		int price = 0;
		for(ComputerDevice c : components)
		{
			price += c.getPrice();
		}
		
		return price;
	}
	
	// 전체 전력을 포함하는 각 부품의 전력을 합산함.
	public int getPower()
	{
		int power = 0;
		for(ComputerDevice c : components)
		{
			power += c.getPower();
		}
		
		return power;
	}
}

```

-   List<ComputerDevice> components 필드 : 복수 개의 ComputerDevice를 가리키려고 정의했다. addComponent 메서드를 통해 ComputerDevice의 구체적인 부품인 Keyboard, Body, Monitor 객체 등을 Computer 클래스의 부품으로 설정할 수 있다.

```
public class Client {

	public static void main(String[] args) {
		// 컴퓨터의 부품으로 Body, Keyboard, Monitor 객체를 생성함
		Body body = new Body(100, 70);
		Keyboard keyboard = new Keyboard(5, 2);
		Monitor monitor = new Monitor(20, 30);
		
		// Computer 객체를 생성하고 부품 객체들을 설정함
		Computer computer = new Computer();
		computer.addComponent(body);
		computer.addComponent(keyboard);
		computer.addComponent(monitor);
		
		// 컴퓨터의 가격과 전력 소비량을 구함
		int computerPrice = computer.getPrice();
		int computerPower = computer.getPower();
		System.out.println("Computer Price : " + computerPrice + "W");		// 125W
		System.out.println("Computer Power : " + computerPower + "만 원");	// 102만원
		
	}

}
```

Computer 클래스는 OCP를 준수하게 되었다. 즉, Computer 클래스에 새로운 부품 객체를 추가해 Computer 클래스를 확장하려고 할 때 Computer 클래스의 코드는 변경할 필요가 없다. 이는 Computer 클래스의 코드에서 Body, Monitor 등과 같은 구체적인 부품을 뜻하는 클래스를 이용하는 대신 일반화된 부품을 의미하는 ComputerDevice 클래스만 이용하기 때문이다.

ComputerDevice 클래스를 상속받는 클래스를 부품으로 사용한다면 Computer 클래스는 임의의 코드를 변경하지 않아도 된다.

### **References**

> JAVA 객체 지향 디자인 패턴