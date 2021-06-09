### **12.1 팩토리 메서드 패턴**

**팩토리 메서드 패턴은 객체의 생성 코드를 별도의 클래스/메서드로 분리함으로써 객체 생성의 변화에 대비하는데 유용하다.** 아래에서 설명할 엘리베이터 스케줄링의 예에서 볼 수 있듯이 프로그램이 제공하는 기능은 상황에 따라 변경될 수 있다. 그리고 특정 기능의 구현은 개별 클래스를 통해 제공되는 것이 바람직한 설계이다. 따라서 기능의 변경이나 상황에 따른 기능의 선택은 바로 해당 객체를 생성하는 코드의 변경을 초래한다. 게다가 상황에 따라 적절한 객체를 생성하는 코드는 자주 중복될 수 있다. 이런 경우 객체 생성 방식의 변화는 해당되는 모든 코드 부분을 변경해야 하는 문제를 일으킨다.

**팩토리 메서드 패턴의 개념**

[##_Image|kage@dNtJr7/btq6RI0OoPy/MeEtNenBcs8a39hZuNxl7k/img.png|alignCenter|data-origin-width="1452" data-origin-height="1073" data-ke-mobilestyle="widthOrigin"|팩토리 메서드 패턴의 개념||_##]

위 그림의 왼쪽처럼 여러 개의 클래스(클래스 A, 클래스 Z 등)에서 필요에 따라 클래스 X1의 객체와 클래스 X2의 객체를 생성해 사용한다. 만약 X1과 X2를 생성하는 방식이 달라지거나 X3와 같이 새로운 클래스의 객체를 생성해야 하는 경우에는 X1과 X2를 생성하는 모든 코드 부분을 변경해야 한다.

하지만 오른쪽과 같이 팩토리 메서드 패턴을 사용하면 객체 생성 기능을 제공하는 Factory 클래스를 정의하고 이를 활용하는 방식으로 설계하면 된다. 다음과 같이 설계하면 X1과 X2의 생성 방식이 변경되거나 X3를 추가해야 할 때 Factory 클래스만 변경하고 클래스 A, 클래스 Z 등은 변경할 필요가 없게 된다.

> 팩토리 메서드 패턴은 객체를 생성하는 코드를 별도의 클래스/메서드로 분리함으로써 객체 생성 방식의 변화에 대비하는데 유용하다.

팩토리 메서드 패턴은 객체 생성을 전담하는 별도의 클래스를 두는 대신 하위 클래스에서 적합한 클래스의 객체를 생성하는 방식으로도 적용할 수 있다. 예를 들어 SchedulerFactory 클래스에서 3가지 방식(최대 처리량, 최소 대기 시간, 동적 선택)에 맞춰 ThroughputScheduler 객체나 ResponseTimeScheduler 객체를 생성하지 않고 해당 스케줄링 전략에 따라 엘리베이터를 선택하는 클래스를 ElevatorManager 클래스의 하위 클래스로 정의할 수 있다.

**상속을 이용한 팩토리 메서드 패턴의 적용**

[##_Image|kage@xKob0/btq6RHgycxe/3Qjsx9TKPKkGXRdWK6Ecn0/img.png|alignCenter|data-origin-width="892" data-origin-height="593" data-ke-mobilestyle="widthOrigin"|상속을 이용한 팩토리 메서드 패턴의 적용||_##]

-   ElevatorManagerWithThroughputScheduling 클래스 : 최대 처리량 전략을 사용하는 클래스
-   ElevatorManagerWithResponseTimeScheduling 클래스 : 최소 대기 시간 전략을 사용하는 클래스
-   ElevatorManagerWithDynamicScheduling 클래스 : 동적 선택 전략을 사용하는 클래스
-   ElevatorManager 클래스
    -   구체적인 스케줄링 전략이 결정되지 않았으므로 getScheduler 메서드를 추상 메서드로 정의
    -   3개의 하위 클래스에서는 getScheduler 메서드를 오버라이드함으로써 구체적인 스케줄링 전략 객체를 생성

**상속을 이용한 팩토리 메서드 패턴의 적용 기반 구현**

```
public abstract class ElevatorManager {
	private List<ElevatorController> controllers;
	
	
	public ElevatorManager(int controllerCount)
	{
		controllers = new ArrayList<ElevatorController>(controllerCount);
		for(int i=0;i<controllerCount;i++)
		{
			ElevatorController controller = new ElevatorController(i+1);
			controllers.add(controller);
		}	
	}
	
	protected abstract ElevatorScheduler getScheduler();	// primitive 또는 hook 메서드
	
	public void requestElevator(int destination, Direction direction)	// 템플릿 메서드
	{
		// 하위 클래스에서 오버라이드된 getScheduler를 호출함
		ElevatorScheduler scheduler = getScheduler();
		int selectedElevator = scheduler.selectElevator(this, destination, direction);
		controllers.get(selectedElevator).gotoFloor(destination);
	}
}
```

```
public class ElevatorManagerWithThroughputScheduling extends ElevatorManager{

	public ElevatorManagerWithThroughputScheduling(int controllerCount) {
		super(controllerCount);
	}
	
	protected ElevatorScheduler getScheduler() {
		ElevatorScheduler scheduler = ThroughputScheduler.getInstance();
		return scheduler;
	}
	
}
```

```
public class ElevatorManagerWithResponseTimeScheduling extends ElevatorManager{

	public ElevatorManagerWithResponseTimeScheduling(int controllerCount) {
		super(controllerCount);
	}
	
	protected ElevatorScheduler getScheduler() {
		ElevatorScheduler scheduler = ResponseTimeScheduler.getInstance();
		return scheduler;
	}
	
}
```

```
public class ElevatorManagerWithDynamicScheduling extends ElevatorManager{

	public ElevatorManagerWithDynamicScheduling(int controllerCount) {
		super(controllerCount);
	}
	
	protected ElevatorScheduler getScheduler() {
		ElevatorScheduler scheduler = null;
		
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		
		if(hour<12)
		{
			scheduler = ResponseTimeScheduler.getInstance();
		}
		else
		{
			scheduler = ThroughputScheduler.getInstance();
		}
		
		return scheduler;
	}
	
}
```

```
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				ElevatorManager emWithResponseTimeScheduler = new ElevatorManager(2, ScheulingStrategyID.RESPONSE_TIME);
				emWithResponseTimeScheduler.requestElevator(10, Direction.UP);
				
				ElevatorManager emWithThroughputScheduler = new ElevatorManager(2, ScheulingStrategyID.THROUGHPUT);
				emWithThroughputScheduler.requestElevator(10, Direction.UP);
				
				ElevatorManager emWithDynamicScheduler = new ElevatorManager(2, ScheulingStrategyID.DYNAMIC);
				emWithDynamicScheduler.requestElevator(10, Direction.UP);
	}

}
```

```
chapter12_팩토리메서드패턴.practice.p04_elevator_after2.scheduler_strategy.ResponseTimeScheduler@30f39991
Elevator [2] Floor: 1 ==> 10
chapter12_팩토리메서드패턴.practice.p04_elevator_after2.scheduler_strategy.ThroughputScheduler@4f3f5b24
Elevator [1] Floor: 1 ==> 10
chapter12_팩토리메서드패턴.practice.p04_elevator_after2.scheduler_strategy.ThroughputScheduler@4f3f5b24
Elevator [1] Floor: 1 ==> 10

```

-   ElevatorManager 클래스의 requestElevator 메서드는 getScheduler 메서드를 추상 메서드로 정의한다.
-   ElevatorManager 클래스의 하위 클래스는 getScheduler 메서드를 오버라이드하는 방식으로 설계되었다.
-   getScheduler 메서드는 스케줄링 전략 객체를 생성하는 기능을 제공하므로 팩토리 메서드라고 한다.
-   ElevatorManager 클래스의 requestElevator 메서드 관점에서 생각하면 3개의 하위 클래스에서 공통 기능(스케줄링 전략 객체 생성, 엘리베이터 선택, 엘리베이터 이동)의 일반 로직은 동일하지만 스케줄링 전략 객체 생성은 하위 클래스에서 오버라이드되었다. **즉, requestElevator 메서드는 템플릿 메서드에 해당된다.**
-   팩토리 메서드를 호출하는 상위 클래스의 메서드는 템플릿 메서드가 된다.

**팩토리 메서드 패턴의 컬레보레이션**

[##_Image|kage@cUzXqU/btq6VEprrSY/BtgLWhVLu9n4zJps4lhEa0/img.png|alignCenter|data-origin-width="1212" data-origin-height="594" data-ke-mobilestyle="widthOrigin"|팩토리 메서드 패턴의 컬레보레이션||_##]

-   Product : 팩토리 메서드로 생성될 객체의 공통 인터페이스
-   ConcreteProduct : 구체적으로 객체가 생성되는 클래스
-   Creater : 팩토리 메서드를 갖는 클래스
-   ConcreteCreator : 팩토리 메서드를 구현하는 클래스로 ConcreteProduct 객체를 생성한다.

**팩토리 메서드 패턴을 엘리베이터 예제에 적용한 경우**

[##_Image|kage@cjCK9V/btq6VqSrSud/Yl57rK4zD34kebQKY8uWuk/img.png|alignCenter|data-origin-width="1521" data-origin-height="667" data-ke-mobilestyle="widthOrigin"|팩토리 메서드 패턴을 엘리베이터 예제에 적용한 경우||_##]

-   ElevatorScheduler 인터페이스 : Product
-   ResponseTimeScheduler, ThroughputScheduler 클래스 : ConcreteProduct
-   ElevatorManager 추상 클래스 : Creator
-   ElevatorManagerWithThroughputScheduling, ElevatorManagerWithResponseTimeScheduling, ElevatorManagerWithDynamicScheduling : ConcreteCreator

### **12.2 여러 가지 방식의 엘리베이터 스케줄링 방법 지원하기**

여러 대의 엘리베이터가 있는 경우를 생각해보자. 만약 엘리베이터 내부에서 버튼(ElevatorBbutton 클래스)을 눌렀을 때는 해당 사용자가 탄 엘리베이터를 이동시키면 된다. 그런데 사용자가 엘리베이터 외부, 즉 건물 내부의 층에서 버튼(FloorButton)을 누른 경우에는 여러 대의 엘리베이터 중 하나를 선택해 이동시켜야 한다.

**스케줄링이란?**

-   주어진 요청(목적지 층과 방향)을 받았을 때 여러 대의 엘리베이터 중 하나를 선택하는 것을 '스케줄링'이라고 한다.

**엘리베이터 스케줄링의 전략**

-   목적지 층과 가까운면서 목적지 층의 방향으로 이동 중인 엘리베이터를 선택하는 것

**작업 처리량(Throughput)을 기준으로 한 스케줄링에 따른 엘리베이터 관리**

[##_Image|kage@PQzs5/btq6V4PyqAS/WuslbH5z0ka3gBkP1Gsq20/img.png|alignCenter|data-origin-width="964" data-origin-height="439" data-ke-mobilestyle="widthOrigin"|작업 처리량(Throughput)을 기준으로 한 스케줄링에 따른 엘리베이터 관리||_##]

-   ElevatorManager 클래스
    -   이동 요청을 처리하는 클래스로 엘리베이터를 스케줄링(엘리베이터 선택)하기 위한 ThroughputScheduler 객체를 갖는다.
    -   각 엘리베이터의 이동을 책임지는 ElevatorController 객체를 복수 개 갖는다.
    -   ElevatorManager 클래스의 requestElevator 메서드는 요청(목적지 층, 방향)을 받았을 때 우선 ThroughputScheduler 클래스의 selectElevator 메서드를 호출해 적절한 엘리베이터를 선택한다.
    -   선택된 엘리베이터에 해당하는 ElevatorController 객체의 gotoFloor 메서드를 호출해 엘리베이터를 이동시킨다.

**작업 처리량(Throughput)을 기준으로 한 스케줄링에 따른 엘리베이터 관리 기반 구현**

```
public class ElevatorManager {
	private List<ElevatorController> controllers;
	private ThroughputScheduler scheduler;
	
	public ElevatorManager(int controllerCount)
	{
		controllers = new ArrayList<ElevatorController>(controllerCount);
		for(int i=0;i<controllerCount;i++)
		{
			ElevatorController controller = new ElevatorController(i);
			controllers.add(controller);
		}
		scheduler = new ThroughputScheduler();	// ThroughputScheduler 객체를 생성함
	}
	
	public void requestElevator(int destination, Direction direction)
	{
		// ThroughputScheduler를 이용해 엘리베이터를 선택함
		int selectedElevator = scheduler.selectElevator(this, destination, direction);
		
		// 선택된 엘리베이터를 이동시킴
		controllers.get(selectedElevator).gotoFloor(destination);
	}
}

```

```
public class ElevatorController {
	private int id;			// 엘리베이터 ID
	private int curFloor;	// 현재 층
	
	public ElevatorController(int id) {
		this.id = id;
		curFloor = 1;
	}
	
	public void gotoFloor(int destination)
	{
		System.out.printf("Elevator [%d] Floor: %d", id,curFloor);
		
		// 현재 층 갱신, 즉 주어진 목적지 층(destination)으로 엘리베이터가 이동함
		this.curFloor = destination;
		System.out.println(" ==> " + curFloor);
		
	}
	
}

```

```
public enum Direction {
	UP, DOWN
}

```

```
public class ThroughputScheduler {
	public int selectElevator(ElevatorManager manager, int destination, Direction direction)
	{
		return 0;	// 임의로 선택함
	}
}
```

### **12.3 문제점**

-   현재 ElevatorManager 클래스는 ThroughputScheduler 클래스를 이용한다. 즉, 엘리베이터의 처리량을 최대화시키는 전략을 사용한다는 의미다. **만약 다른 스케줄링 전략을 사용해야 한다면?** 예를 들어 사용자의 대기 시간을 최소화하는 엘리베이터 선택 전략을 사용해야 한다면?
-   프로그램 실행 중에 스케줄링 전략을 변경, 즉 동적 스케줄링을 지원해야 한다면? 예를 들어 오전에는 대기 시간 최소화 전략을 사용하고, 오후에는 처리량 최대화 전략을 사용해야 한다면?

**스케줄링 클래스**

-   ResponseTimeScheduler 클래스 : 이용자의 대기 시간을 최소화하는 방식으로 엘리베이터를 선택하는 전략

**동적 스케줄링을 지원하는 수정된 ElevatorManager 클래스 코드**

```
public class ElevatorManager {
	private List<ElevatorController> controllers;
	
	
	public ElevatorManager(int controllerCount)
	{
		controllers = new ArrayList<ElevatorController>(controllerCount);
		for(int i=0;i<controllerCount;i++)
		{
			ElevatorController controller = new ElevatorController(i+1);
			controllers.add(controller);
		}
		
	}
	
	public void requestElevator(int destination, Direction direction)
	{
		ElevatorScheduler scheduler;
		
		// 0..23
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		
		if(hour<12)	// 오전에는 ResponseTimeScheduler를 이용함
		{
			scheduler = new ResponseTimeScheduler();
		}
		else	// 오후에는 ThroughputScheduler를 이용함
		{
			scheduler = new ThroughputScheduler();
		}
		
		// ThroughputScheduler를 이용해 엘리베이터를 선택함
		int selectedElevator = scheduler.selectElevator(this, destination, direction);
		
		// 선택된 엘리베이터를 이동시킴
		controllers.get(selectedElevator).gotoFloor(destination); 
	}
}
```

오전에는 대기 시간 최소화 전략을, 오후에는 처리량 최대화 전략을 사용하는 동적 스케줄링을 해야 하므로 requestElevator 메서드가 실행될 때마다 현재 시간에 따라 적절한 스케줄링 객체를 생성해야 한다.

처리량 최대화 전략이나 대기 시간 최소화 전략이나 모두 ElevatorManager 클래스의 입장에서는 엘리베이터 스케줄링 전략의 일종이다. 그러므로 ElevatorManager 클래스는 ThroughputScheduler 객체와 ResponseTimeScheduler 객체를 생성한 후, 이를 각각의 클래스가 아니라 ElevatorScheduler라는 인터페이스를 통해 사용할 수 있다.

결과적으로 스트래티지 패턴을 활용해 엘리베이터 스케줄링 전략을 설계한 것이다.

-   ElevatorScheduler 인터페이스 : AbstractStrategy 역할
-   ThroughputScheduler, ResponseTimeScheduler 클래스 : ConcreteStrategy 역할

**스트래티지 패턴을 활용한 엘리베이터 스케줄링 전략 설계**

[##_Image|kage@F2MVc/btq6Vh9FEaR/DnZsZuIt9dD0dU8xlUi7c1/img.png|alignCenter|data-origin-width="1240" data-origin-height="600" data-ke-mobilestyle="widthOrigin"|스트래티지 패턴을 활용한 엘리베이터 스케줄링 전략 설계||_##]

**하지만** **문제점은 ElevatorManager 클래스는 엘리베이터 스케줄링 전략이 변경될 때마다 requestElevator 메서드도 수정되어야 한다.** 예를 들면 다음과 같다.

-   새로운 스케줄링 전략이 추가되는 경우, 예를 들어 특정 엘리베이터가 빈번히 사용되면 해당 엘리베이터가 노후화되고 결국 고장날 수 있다. 그러므로 노후화를 최소화하는 방식으로 엘리베이터를 선택하는 것도 추가 될 수 있다.
-   현재는 오전에 ResponseTimeScheduler 클래스를 사용하고 오후에 ThroughputScheduler 클래스를 사용하는데, 이러한 선택이 변경될 수 있다. 예를 들어 오후에는 ResponseTimeScheduler 클래스, 오전에는 ThroughputScheduler 클래스를 사용하도록 변경하는 것이다. 그뿐만 아니라 밤에는 노후화 최소화 전략을 적용할 수도 있다.

### **12.4 해결책**

위와 같은 문제를 해결하려면 **주어진 기능을 실제로 제공하는 적절한 클래스 생성 작업을 별도의 클래스/메서드로 분리시키는 편이 좋다.** 예를 들어 엘리베이터 스케줄링 전략에 일치하는 클래스를 생성하는 코드를 requestElevator 메서드에서 분리해 별도의 클래스/메서드를 정의하면 된다.

**SchedulerFactory를 이용한 스케줄링 전략 객체의 생성**

[##_Image|kage@LgLhL/btq6SwzAC44/SsifXKcEBtZherdKDySCX1/img.png|alignCenter|data-origin-width="1176" data-origin-height="656" data-ke-mobilestyle="widthOrigin"|SchedulerFactory를 이용한 스케줄링 전략 객체의 생성||_##]

ElevatorManager 클래스가 지금처럼 직접 ThroughputScheduler 객체와 ResponseTimeScheduler 객체를 생성하는 대신 SchedulerFactory 클래스가 이들 객체를 생성하도록 변경한 설계이다.

**SchedulerFactory를 이용한 스케줄링 전략 객체의 생성 기반 구현**

```
public enum ScheulingStrategyID {
	RESPONSE_TIME, THROUGHPUT, DYNAMIC
}

public class SchedulerFactory {
	public static ElevatorScheduler getScheduler(ScheulingStrategyID strategyID)
	{
		ElevatorScheduler scheduler = null;
		
		switch(strategyID)
		{
		case RESPONSE_TIME:	// 대기 시간 최소화 전략
			scheduler = new ResponseTimeScheduler();
			break;
		case THROUGHPUT:	// 처리량 최대화 전략
			scheduler = new ThroughputScheduler();
			break;
		case DYNAMIC:	// 오전에는 대기시간 최소화 전략, 오후에는 처리량 최대화 전략
			int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
			if(hour<12)
			{
				scheduler = new ResponseTimeScheduler();
			}
			else
			{
				scheduler = new ThroughputScheduler();
			}
			break;
		}
		return scheduler;
	}
}

```

SchedulerFactory 클래스의 getScheduler 메서드는 인자로 주어진 SchedulingPolicyID에 따라 적절한 스케줄링 객체를 생성한다.

**SchedulingPolicyID에 따른 스케줄링 객체 생성**

-   THROUGHPUT : ThroughputScheduler 객체 생성
-   RESPONSE\_TIME : ResponseTimeScheduler 객체 생성
-   DYNAMIC : 오전에는 ResponseTimeScheduler, 오후에는 ThroughputScheduler 객체 생성

```
public class ElevatorManager {
	private List<ElevatorController> controllers;
	private ScheulingStrategyID strategyID;
	
	public ElevatorManager(int controllerCount, ScheulingStrategyID strategyID)
	{
		controllers = new ArrayList<ElevatorController>(controllerCount);
		for(int i=0;i<controllerCount;i++)
		{
			ElevatorController controller = new ElevatorController(i+1);
			controllers.add(controller);
		}
		
		this.strategyID = strategyID;
	}
	
	public void setStrategyID(ScheulingStrategyID strategyID)
	{
		this.strategyID = strategyID;
	}
	
	public void requestElevator(int destination, Direction direction)
	{
		ElevatorScheduler scheduler = SchedulerFactory.getScheduler(strategyID);
		System.out.println(scheduler);
		int selectedElevator = scheduler.selectElevator(this, destination, direction);
		controllers.get(selectedElevator).gotoFloor(destination);
		
	}
}

```

```
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ElevatorManager emWithResponseTimeScheduler = new ElevatorManager(2, ScheulingStrategyID.RESPONSE_TIME);
		emWithResponseTimeScheduler.requestElevator(10, Direction.UP);
		
		ElevatorManager emWithThroughputScheduler = new ElevatorManager(2, ScheulingStrategyID.THROUGHPUT);
		emWithThroughputScheduler.requestElevator(10, Direction.UP);
		
		ElevatorManager emWithDynamicScheduler = new ElevatorManager(2, ScheulingStrategyID.DYNAMIC);
		emWithDynamicScheduler.requestElevator(10, Direction.UP);
	}

}

```

```
chapter12_팩토리메서드패턴.practice.p03_elevator_after.scheduler_strategy.ResponseTimeScheduler@30f39991
Elevator [1] Floor: 1 ==> 10
chapter12_팩토리메서드패턴.practice.p03_elevator_after.scheduler_strategy.ThroughputScheduler@4f3f5b24
Elevator [1] Floor: 1 ==> 10
chapter12_팩토리메서드패턴.practice.p03_elevator_after.scheduler_strategy.ThroughputScheduler@b4c966a
Elevator [1] Floor: 1 ==> 10

```

ElevatorManager 클래스의 생성자에 SchedulingStrategyID 인자를 명시함으로써 해당 ElevatorManager 클래스의 스케줄링 전략을 지정하도록 한다. 물론 setStrategyID 메서드를 이용하여 실행 중에 다른 스케줄링 전략을 지정할 수도 있다.

위 실행 결과에서 알 수 있듯이 **두번째와 세번째는 같은 ThroughputScheduler 전략을 사용함에도 불구하고 다른 객체이다. 이는 SchedulerFactory 클래스의 getScheduler 메서드에서 스케줄링 객체를 매번 생성하기 때문이다. **동일 스케줄링 방식이라고 하면 여러 번 스케줄링 객체를 생성하지 않고 한 번 생성한 것을 계속해서 사용하는 것이 바람직할 수 있다. 따라서 ResponseTimeScheduler 클래스와 ThroughputScheduler 클래스는 오직 하나의 객체만 생성해서 사용해도 충분하다. 이는 **바로 싱글턴 패턴에 해당된다. ****즉, ResponseTimeScheduler 클래스와 ThroughputScheduler 클래스는 싱글턴 패턴을 적용해서 설계하면 좋다.**

**싱글턴 패턴을 적용한 스케줄링 전략 클래스의 설계**

[##_Image|kage@cvZQfi/btq6WiNBYeU/toP0RZBDZL32ymjYbvkqs0/img.png|alignCenter|data-origin-width="1086" data-origin-height="620" data-ke-mobilestyle="widthOrigin"|싱글턴 패턴을 적용한 스케줄링 전략 클래스의 설계||_##]

ThroughputScheduler 클래스와 ResponseTimeScheduler 클래스의 생성자는 각각 private로 정의된다. 대신 getInstance 정적 메소드를 통하여 객체 생성을 한다.

**싱글턴 패턴을 적용한 스케줄링 전략 클래스의 설계 기반 구현**

```
public class SchedulerFactory {
	public static ElevatorScheduler getScheduler(ScheulingStrategyID strategyID)
	{
		ElevatorScheduler scheduler = null;
		
		switch(strategyID)
		{
		case RESPONSE_TIME:	// 대기 시간 최소화 전략
			scheduler = ResponseTimeScheduler.getInstance();
			break;
		case THROUGHPUT:	// 처리량 최대화 전략
			scheduler = ThroughputScheduler.getInstance();
			break;
		case DYNAMIC:	// 오전에는 대기시간 최소화 전략, 오후에는 처리량 최대화 전략
			int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
			if(hour<12)
			{
				scheduler = ResponseTimeScheduler.getInstance();
			}
			else
			{
				scheduler = ThroughputScheduler.getInstance();
			}
			break;
		}
		return scheduler;
	}
}

```

```
public class ThroughputScheduler implements ElevatorScheduler{
	private static ElevatorScheduler scheduler;
	
	private ThroughputScheduler() {
		// TODO Auto-generated constructor stub
	}
	
	public static ElevatorScheduler getInstance()
	{
		if(scheduler==null)
		{
			scheduler = new ThroughputScheduler();
		}
		return scheduler;
	}
	
	@Override
	public int selectElevator(ElevatorManager manager, int destination, Direction direction) {
		// TODO Auto-generated method stub
		return 0;
	}
							
}
```

```
public class ResponseTimeScheduler implements ElevatorScheduler {
	
	private static ElevatorScheduler scheduler;
	private ResponseTimeScheduler() {
		// TODO Auto-generated constructor stub
	}
	
	public static ElevatorScheduler getInstance()
	{
		if(scheduler==null)
		{
			scheduler = new ResponseTimeScheduler();
		}
		return scheduler;
	}
	
	@Override
	public int selectElevator(ElevatorManager manager, int destination, Direction direction) {
		// TODO Auto-generated method stub
		return 1;
	}

}

```

```
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ElevatorManager emWithResponseTimeScheduler = new ElevatorManager(2, ScheulingStrategyID.RESPONSE_TIME);
		emWithResponseTimeScheduler.requestElevator(10, Direction.UP);
		
		ElevatorManager emWithThroughputScheduler = new ElevatorManager(2, ScheulingStrategyID.THROUGHPUT);
		emWithThroughputScheduler.requestElevator(10, Direction.UP);
		
		ElevatorManager emWithDynamicScheduler = new ElevatorManager(2, ScheulingStrategyID.DYNAMIC);
		emWithDynamicScheduler.requestElevator(10, Direction.UP);
	}

}

```

```
chapter12_팩토리메서드패턴.practice.p04_elevator_after2.scheduler_strategy.ResponseTimeScheduler@30f39991
Elevator [2] Floor: 1 ==> 10
chapter12_팩토리메서드패턴.practice.p04_elevator_after2.scheduler_strategy.ThroughputScheduler@4f3f5b24
Elevator [1] Floor: 1 ==> 10
chapter12_팩토리메서드패턴.practice.p04_elevator_after2.scheduler_strategy.ResponseTimeScheduler@30f39991
Elevator [2] Floor: 1 ==> 10

```

위의 결과에서 볼 수 있듯이 ResponseTimeScheduler가 두개 존재하고 두 객체의 값은 같은것을 알 수 있다.

### **References**

> JAVA 객체 지향 디자인 패턴