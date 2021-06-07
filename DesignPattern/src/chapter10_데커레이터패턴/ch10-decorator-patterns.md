### **10.1 데커레이터 패턴**

데커레이터 패턴은 기본 기능에 추가할 수 있는 기능의 종류가 많은 경우에 각 추가 기능을 Decorator 클래스로 정의한 후 필요한 Decorator 객체를 조합함으로써 추가 기능의 조합을 설게하는 방식이다.

예를 들어 기본 도로 표시 기능에 차선 표시, 교통량 표시, 교차로 표시, 단속 카메라 표시의 4가지 추가 기능이 있을 때 추가 기능의 모든 조합은 15가지가 된다.

데커레이터 패턴을 사용하면 개별 추가 기능에 해당하는 Decorator 클래스 4개만 구현하고 개별 추가 기능을 객체의 형태로 조합함으로써 추가 기능의 조합을 구현할 수 있다.

**데커레이터 패턴의 컬레보레이션**

[##_Image|kage@ccOC3j/btq6Gpf3sZt/U7fkVfqKhnVcE6Ej4HEXw1/img.png|alignCenter|data-origin-width="1198" data-origin-height="592" data-ke-mobilestyle="widthOrigin"|데커레이터 패턴의 컬레보레이션||_##]

-   **Component** : 기본 기능을 뜻하는 ConcreteComponent와 추가 기능을 뜻하는 Decorator의 공통 기능을 정의한다. 즉, 클라이언트는 Component를 통해 실제 객체를 사용한다.
-   **ConcreteComponent** : 기본 기능을 구현하는 클래스다.
-   **Decorator** : 많은 수가 존재하는 구체적인 Decorator의 공통 기능을 제공한다.
-   **ConcreteDecoratorA, ConcreteDecoratorB** : Decorator의 하위 클래스로 기본 기능에 추가되는 개별적인 기능을 뜻한다.

**데커레이터 패턴의 순차 다이어그램**

[##_Image|kage@byVO4i/btq6JnoqLvc/6gV21ykyQb5OqAB0aijs7k/img.png|alignCenter|data-origin-width="1171" data-origin-height="438" data-ke-mobilestyle="widthOrigin"|데커레이터 패턴의 순차 다이어그램||_##]

Client가 객체 b의 operation 메서드를 호출하면 객체 b가 가리키는 Component, 즉 ConcreteDecoratorA 객체 a의 operation을 호출한다. 객체 a 역시 자신이 가리키는 Component, 즉 ConcreteComponent 객체 c의 operation 메서드를 호출한 후 자신의 addedBehavior 메서드를 호출한다.

객체 b 역시 객체 a의 operation 메서드를 호출 한 후 addedBehavior 메서드를 호출한다.

### **10.2 도로 표시 방법 조합하기**

내비게이션 SW에서 도로를 표시하는 기능이 존재한다. 가장 기본적인 기능은 도로를 간단한 선으로 표시하는 것이다. 그리고 내비게이션 SW에 따라 도로의 차선을 표시하는 기능도 제공한다. 도로의 차선까지 표시하는 기능은 핵심/기본 기능이라기보다는 추가 기능으로 선택해서 제공하는 경우도 있다.

-   RoadDisplay : 기본 도로 표시 기능
-   RoadDisplayWithLane : 기본 도로 표시에 추가적으로 차선 표시 기능

**기본 도로 및 차선을 표시하는 RoadDisplay와 RoadDisplayWithLane 클래스의 설계**

[##_Image|kage@6pQj0/btq6DDeSRhz/havRN9eLpJMTwBOGgOIUek/img.png|alignCenter|data-origin-width="378" data-origin-height="359" data-ke-mobilestyle="widthOrigin"|기본 도로 및 차선을 표시하는 RoadDisplay와 RoadDisplayWithLane 클래스의 설계||_##]

**기본 도로 및 차선을 표시하는 RoadDisplay와 RoadDisplayWithLane 클래스의 설계 기반 코드**

```
public class RoadDisplay {	// 기본 도로 표시 클래스
	public void draw()
	{
		System.out.println("기본 도로 표시");
	}
}
```

```
public class RoadDisplayWithLane extends RoadDisplay {

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		super.draw();	// 상위 클래스, 즉 RoadDisplay 클래스의 draw 메서드를 호출해서 기본 도로를 표시
		drawLane();
	}
	
	private void drawLane() {
		// TODO Auto-generated method stub
		System.out.println("차선 표시");
	}


}

```

```
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RoadDisplay road = new RoadDisplay();
		road.draw();	// 기본 도로만 표시
		
		RoadDisplay roadWithLane = new RoadDisplayWithLane();
		roadWithLane.draw();	// 기본 도로 + 차선 표시
		
	}

}

```

```
기본 도로 표시
기본 도로 표시
교통량 표시

```

RoadDisplay 클래스에는 기본 도로 표시 기능을 실행하기 위한 draw 메서드를 구현한다.

RoadDisplayWithLane 클래스에는 기본 도로 표시뿐만 아니라 차선을 표시하고 상속받은 draw 메서드를 오버라이드한다.

### **10.3 문제점**

-   또다른 도로 표시 기능을 추가로 구현하고 싶다면 어떻게 해야 하는가? 예를 들어 기본 도로 표시에 교통량을 표시하고 싶다면?
-   여러 가지 추가 기능을 조합해 제공하고 싶다면 어떻게 해야 하는가? 예를 들어 기본 도로 표시에 차선 표시 기능과 교통량 표시 기능을 함께 제공하고 싶다면?

**또 다른 도로 표시 기능을 추가로 구현하는 경우**

RoadDisplayWithTraffic 클래스는 도로에 교통량을 추가로 표시하는 클래스로 RoadDisplay 클래스를 상속받아 정의할 수 있다.

기본 도로 및 교통량을 표시하는 RoadDisplayWithTraffic 클래스의 설계

[##_Image|kage@bm2Ia3/btq6DBVTmuF/ZuW7NSa1rb4cv5zFkTALC1/img.png|alignCenter|data-origin-width="747" data-origin-height="383" data-ke-mobilestyle="widthOrigin"|기본 도로 및 교통량을 표시하는 RoadDisplayWithTraffic 클래스의 설계||_##]

기본 도로 및 교통량을 표시하는 RoadDisplayWithTraffic 클래스의 설계 기반 코드

```
public class RoadDisplayWithTraffic extends RoadDisplay {

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		super.draw();	// 상위 클래스, 즉 RoadDisplay 클래스의 draw 메서드를 호출해서 기본 도로를 표시
		drawTraffic();
	}

	private void drawTraffic() {
		// TODO Auto-generated method stub
		System.out.println("교통량 표시");
	}
}

```

**여러 가지 추가 기능을 조합해야 하는 경우**

RoadDisplay 클래스의 하위 클래스로 도로 표시에 기능(예: 차선 표시, 교통량 표시)을 추가하는 것은 적절한 설계 방법이 될 수 있다. 그러나 다양한 기능의 조합을 고려해야 하는 경우 상속을 통한 기능의 확장은 각 기능별로 클래스를 추가해야 한다는 단점이 존재한다.

예를 들어 도로 표시를 하는 기본 기능에 추가로 제공할 수 있는 기능으로 차선 표시, 교통량 표시를 한다고 가정할 때 아래 표와 같이 총 4가지의 조합이 가능하다.

<table style="border-collapse: collapse; width: 100%;" border="1" width="1436" data-ke-align="alignLeft"><tbody><tr><td rowspan="2" width="239" height="88"><span><span style="color: #000000;">경우</span></span></td><td rowspan="2" width="239"><span><span style="color: #000000;">기본 기능</span></span><br><span><span style="color: #000000;">(</span><span style="color: #000000;">도로 표시</span><span style="color: #000000;">)</span></span></td><td colspan="2" width="466"><span><span style="color: #000000;">추가 기능</span></span></td><td rowspan="2" width="491"><span><span style="color: #000000;">클래스 이름</span></span></td></tr><tr><td width="211" height="44"><span><span style="color: #000000;">차선 표시</span></span></td><td width="255"><span><span style="color: #000000;">교통량 표시</span></span></td></tr><tr><td width="239" height="49"><span><span style="color: #000000;">1</span></span></td><td width="239"><span><span style="color: #000000;">0</span></span></td><td width="211"><span>&nbsp;</span></td><td width="255"><span>&nbsp;</span></td><td width="491"><span><span style="color: #000000;">RoadDisplay</span></span></td></tr><tr><td width="239" height="49"><span><span style="color: #000000;">2</span></span></td><td width="239"><span><span style="color: #000000;">0</span></span></td><td width="211"><span><span style="color: #000000;">0</span></span></td><td width="255"><span>&nbsp;</span></td><td width="491"><span><span style="color: #000000;">RoadDisplayWithLane</span></span></td></tr><tr><td width="239" height="49"><span><span style="color: #000000;">3</span></span></td><td width="239"><span><span style="color: #000000;">0</span></span></td><td width="211"><span>&nbsp;</span></td><td width="255"><span><span style="color: #000000;">0</span></span></td><td width="491"><span><span style="color: #000000;">RoadDisplayWithTraffic</span></span></td></tr><tr><td width="239" height="49"><span><span style="color: #000000;">4</span></span></td><td width="239"><span><span style="color: #000000;">0</span></span></td><td width="211"><span><span style="color: #000000;">0</span></span></td><td width="255"><span><span style="color: #000000;">0</span></span></td><td width="491"><u><i><b><span><span style="color: #000000;">RoadDisplayWithLaneTraffic</span></span></b></i></u></td></tr></tbody></table>

위와 같이 상속을 통해 조합의 각 경우를 설계한다면 각 조합별로 하위 클래스를 구현해야 한다.

### **10.4 해결책**

위에 소개한 문제점은 추가되는 기능의 조합별로 하위 클래스를 구현해야 하는 문제가 존재한다. 이렇게 조합 수가 늘어나는 문제를 해결할 수 있는 설계를 하려면 각 추가 기능별로 개별적인 클래스를 설계하고 기능을 조합 시 각 클래스의 객체 조합을 이용하면 된다.

**개선된 추가 기능 조합의 설계**

[##_Image|kage@WgzFU/btq6KQYAIwW/hyeK0ZqB6X4rVRPNbYEhS1/img.png|alignCenter|data-origin-width="1090" data-origin-height="566" data-ke-mobilestyle="widthOrigin"|개선된 추가 기능 조합의 설계||_##]

기본 기능만 이용할 때는 RoadDisplay 클래스의 객체를 생성하면 충분하다. 하지만 차선을 표시하는 기능이 추가적으로 필요하다면 LaneDecorator 클래스의 객체가 필요하다. 이때 LaneDecorator에서는 차선 표시 기능만 직접 제공하고 도로 표시 기능은 RoadDisplay 클래스의 draw 메서드를 호출하는 방식으로 구현한다.

LaneDecorator 클래스는 RoadDisplay 객체에 대한 참조가 필요한데, 이는 LaneDecorator 클래스의 상위 클래스인 DisplayDecorator 클래스에서 Display 클래스로의 컴포지션(Composition) 관계를 통해 표현되고 있다.

**개선된 추가 기능 조합의 설계 기반 코드**

```
public abstract class Display {
	public abstract void draw();
}
```

```
public class RoadDisplay extends Display{	// 기본 도로 표시 클래스
	public void draw()
	{
		System.out.println("기본 도로 표시");
	}
}
```

```
public abstract class DisplayDecorator extends Display {
	private Display decoratedDisplay;
	
	public DisplayDecorator(Display decoratedDisplay)
	{
		this.decoratedDisplay = decoratedDisplay;
	}
	
	public void draw()
	{
		decoratedDisplay.draw();
	}
}
```

```
public class LaneDecorator extends DisplayDecorator{

	public LaneDecorator(Display decoratedDisplay) {
		super(decoratedDisplay);
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		super.draw();
		drawLane();
	}
	
	private void drawLane()
	{
		System.out.println("\t차선 표시");
	}	
}
```

```
public class TrafficDecorator extends DisplayDecorator{

	public TrafficDecorator(Display decoratedDisplay) {
		super(decoratedDisplay);
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		super.draw();
		drawTraffic();
	}
	
	private void drawTraffic()
	{
		System.out.println("\t교통량 표시");
	}	
}

```

```
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Display road = new RoadDisplay();
		road.draw();	// 기본 도로 표시
		
		Display roadWithLane = new LaneDecorator(new RoadDisplay());
		roadWithLane.draw(); // 기본 도로 표시 + 차선 표시
		
		Display roadWithTraffic = new TrafficDecorator(new RoadDisplay());
		roadWithTraffic.draw(); // 기본 도로 표시 + 교통량 표시
		
		
		Display roadWithLaneAndTraffic = new TrafficDecorator(new LaneDecorator(new RoadDisplay()));
		roadWithLaneAndTraffic.draw();
	}

}
```

```
기본 도로 표시
기본 도로 표시
	차선 표시
기본 도로 표시
	교통량 표시
기본 도로 표시
	차선 표시
	교통량 표시

```

주목할 점은 road, roadWithLane, roadWithTraffic 객체의 접근이 모두 Display 클래스를 통해 이루어진다는 것이다. 즉, 기본 도로 표시(road), 기본 도로 표시에 차선 표시 추가(roadWithLane), 기본 도로 표시에 교통량 표시 추가(roadWithTraffic)에 관계없이 Client 클래스는 동일한 Display 클래스만을 통해 일관성 있는 방식으로 도로 정보를 표시할 수 있다.

**roadWithLane 객체의 draw 메서드 동작**

[##_Image|kage@bc18NF/btq6CPGz49R/k2ik2xTuzI1G7eQkW5qkr0/img.png|alignCenter|data-origin-width="910" data-origin-height="444" data-ke-mobilestyle="widthOrigin"|roadWithLane 객체의 draw 메서드 동작||_##]

1.  LaneDecorator 클래스 객체의 draw 메서드는 먼저 RoadDisplay 클래스의 draw 메서드를 호출해야 한다.
2.  이는 LaneDecorator 클래스의 상위 클래스인 DisplayDecorator 클래스의 draw 메서드를 호출해 DisplayDecorator 클래스를 가리키는 decoratedDisplay 객체를 호출함으로써 실행된다.
3.  LaneDecorator 클래스의 drawLane 메서드를 호출하면 추가 기능인 차선 표시를 제공할 수 있다.

### **References**

> JAVA 객체 지향 디자인 패턴