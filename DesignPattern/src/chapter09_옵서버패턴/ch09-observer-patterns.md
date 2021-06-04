### **9.1 옵서버 패턴**

옵서버 패턴(Observer Pattern)은 데이터의 변경이 발생 시 상대 클래스나 객체에 의존하지 않으면서 데이터 변경을 통보하고자 할 때 유용하다.

예를 들어 차량의 연료가 소진될 때까지의 주행 가능 거리를 출력하는 클래스, 연료량이 부족하면 경고 메시지를 보내는 클래스, 연료량이 부족하면 자동으로 근처 주유소를 표시하는 클래스 등에 연료량의 변화를 통보하는 경우가 있다. 이런 경우에 연료량 클래스는 연료량에 관심을 가지는 구체적인 클래스(주행 가능 거리 출력, 연료량 부족 경고, 근처 주유소 검색)에 직접 의존하지 않는 방식으로 설계하는 것이 바람직하다.

> 옵서버 패턴은 통보 대상 객체의 관리를 Subject 클래스와 Observer 인터페이스로 일반화한다. 그러면 데이터 변경을 통보하는 클래스(ConcreteSubject)는 통보 대상 클래스나 객체(ConcreteObserver)에 대한 의존성을 없앨 수 있다. 결과적으로 옵서버 패턴은 통보 대상 클래스나 대상 객체의 변경에도 ConcreteSubject 클래스를 수정 없이 그대로 사용할 수 있도록 한다.

**옵서버 패턴의 컬레보레이션**

![옵서버 패턴의 컬레보레이션](https://github.com/yonghwankim-dev/DesignPattern/blob/master/DesignPattern/src/chapter09_%EC%98%B5%EC%84%9C%EB%B2%84%ED%8C%A8%ED%84%B4/diagram/observer-pattern_collaboration.png)

-   **Observer** : 데이터의 변경을 통보 받는 인터페이스. 즉 Subject에서는 Observer 인터페이스와 update 메서드를 호출함으로써 ConcreteSubject의 데이터 변경을 ConcreteObserver에게 통보한다.
-   **Subject** : ConcreteOberser 객체를 관리하는 요소. Observer 인터페이스를 참조해서 ConcreteObserver를 관리하므로 ConcreteObserver의 변화에 독립적일 수 있다.
-   **ConcreteSubject** : 변경 관리 대상이 되는 데이터가 있는 클래스. 데이터 변경을 위한 메서드인 setState가 있으며 setState에서는 자신의 데이터인 subjectState를 변경하고 Subject의 notifyObservers 메서드를 호출해서 ConcreteObserver 객체에 변경을 통보한다.
-   **ConcreteObserver** : ConcreteSubject의 변경을 통보받는 클래스. Observer 인터페이스의 update 메서드를 구현함으로써 변경을 통보받는다. 변경된 데이터는 ConcreteSubject의 getState 메서드를 호출함으로써 변경을 조회한다.

**옵서버 패턴의 순차 다이어그램**

![옵서버 패턴의 순차 다이어그램](https://github.com/yonghwankim-dev/DesignPattern/blob/master/DesignPattern/src/chapter09_%EC%98%B5%EC%84%9C%EB%B2%84%ED%8C%A8%ED%84%B4/diagram/observer-pattern_seq.png)

ConcreteSubject가 자신의 상태, 즉 데이터의 변경을 통보하려면 ConcreteObserver가 미리 등록되어 있어야 한다. 위 그림에서는 ConcreteSubject s1에 o1과 o2가 ConcreteObserver로 등록되어 있다.

ConcreteObserver o1이 ConcreteSubject s1의 상태를 변경하면 s1은 등록된 모든 ConcreteObserver에게 자신이 변경되었음을 통보한다. 변경 통보는 실제로는 ConcreteSubject의 상위 클래스인 Subject 클래스의 notifyObservers 메서드를 호출해 이루어진다. 그러면 notifyObservers 메서드는 등록된 각 ConcreteObserver의 update 메서드를 호출한다.

마지막으로 통보받은 ConcreteObserver o1과 o2는 ConcreteSubject s1의 getState 메서드를 호출함으로써 변경된 상태나 데이터를 구한다.

### **9.2 여러 가지 방식으로 성적 출력하기**

성적 값을 출력하는 프로그램 작성

-   ScoreRecord : 점수 저장 클래스
-   DataSheetView : 점수를 목록의 형태로 출력

**ScoreRecord 클래스의 값을 출력하는 DataSheetView 클래스의 관계**

![ScoreRecord 클래스의 값을 출력하는 DataSheetView 클래스의 설계](https://github.com/yonghwankim-dev/DesignPattern/blob/master/DesignPattern/src/chapter09_%EC%98%B5%EC%84%9C%EB%B2%84%ED%8C%A8%ED%84%B4/diagram/observer-pattern_scoreRecord-DataSheetView_Relation.png)

**ScoreRecord 클래스의 값을 출력하는 DataSheetView 클래스의 관계 기반 코드**

```
public class ScoreRecord {
	private List<Integer> scores = new ArrayList<Integer>();	// 점수를 저장함
	private DataSheetView dataSheetView;	// 목록 형태로 점수를 출력하는 클래스
	
	public void setDataSheetView(DataSheetView dataSheetView)
	{
		this.dataSheetView = dataSheetView;
	}
	
	public void addScore(int score)	// 새로운 점수를 추가함
	{
		scores.add(score);	// scores 목록에 주어진 점수를 추가함
		dataSheetView.update();	// scores가 변경됨을 통보함
	}
	
	public List<Integer> getScoreRecord()
	{
		return scores;
	}
}

```

```
public class DataSheetView {
	private ScoreRecord scoreRecord;
	private int viewCount;
	
	public DataSheetView(ScoreRecord scoreRecord, int viewCount) {
		this.scoreRecord = scoreRecord;
		this.viewCount = viewCount;
	}

	public void update() {	// 점수의 변경을 통보받음
		List<Integer> record = scoreRecord.getScoreRecord();	// 점수를 조회함
		displayScores(record,viewCount);	// 조회된 점수를 viewCount 만큼만 출력함
	}

	private void displayScores(List<Integer> record, int viewCount) {
		System.out.println("List of " + viewCount + " entries: ");
		for(int i=0; i<viewCount && i<record.size(); i++)
		{
			System.out.print(record.get(i) + " ");
		}
		System.out.println();
	}

}
```

```
public class Client {

	public static void main(String[] args) {
		ScoreRecord scoreRecord = new ScoreRecord();
		
		// 3개까지의 점수만 출력함
		DataSheetView dataSheetView = new DataSheetView(scoreRecord, 3);
		
		scoreRecord.setDataSheetView(dataSheetView);
		
		for(int index=1; index<=5;index++)
		{
			int score= index + 10;
			System.out.println("Adding " + score);
			
			// 10 20 30 40 50을 추가함, 추가할때마다 최대 3개의 점수만 출력함
			scoreRecord.addScore(score);
		}
	}

}

```

```
Adding 11
List of 3 entries: 
11 
Adding 12
List of 3 entries: 
11 12 
Adding 13
List of 3 entries: 
11 12 13 
Adding 14
List of 3 entries: 
11 12 13 
Adding 15
List of 3 entries: 
11 12 13 
```

DataSheetView 클래스의 update 메서드가 실행될 때는 ScoreRecord 클래스에서 점수를 조회하는 getScoreRecord 메서드를 호출하려고 ScoreRecord 객체를 DataSheetView 클래스의 생성자에 전달한다.

ScoreRecord 클래스는 점수 추가시 addScore 메서드가 호출될 때 DataSheetView의 update 메서드를 호출할 필요가 있다.

### **9.3 문제점**

-   성적을 다른 형태로 출력하고 싶다면 어떤 변경작업을 해야 하는가? 예를 들어 성적을 목록으로 출력하지 않고 성적의 최소/최대 값만 출력하려면?
-   여러 가지 형태의 성적을 동시 혹은 순차적으로 출력하려면 어떤 변경 작업을 해야 하는가? 예를 들어 성적이 입력되었을 때 최대 3개 목록, 최대 5개 목록, 최소/최대 값을 동시에 출력하거나 처음에는 목록으로 출력하고 나중에는 최소/최대 값을 출력하려면?

**성적을 다른 형태로 출력하는 경우**

점수 입력 시 최소/최대 값만 출력하려면 기존의 DataSheetView 클래스 대신 최소/최대 값을 출력하는 MinMaxView 클래스를 추가할 필요가 있다. 그리고 ScoreRecord 클래스는 DataSheetView 클래스가 아니라 MinMaxView 클래스에 성적 변경을 통보할 필요가 있다.

```
public class ScoreRecord {
	private List<Integer> scores = new ArrayList<Integer>();	// 점수를 저장함
	private MinMaxView minMaxView;
	
	public void setStatisticsView(MinMaxView minMaxView)
	{
		this.minMaxView = minMaxView;
	}
	
	public void addScore(int score)	// 새로운 점수를 추가함
	{
		scores.add(score);	// scores 목록에 주어진 점수를 추가함
		minMaxView.update();	// MinMaxView에게 점수의 변경을 통보함
	}
	
	public List<Integer> getScoreRecord()
	{
		return scores;
	}
}

```

```
public class MinMaxView {
	private ScoreRecord scoreRecord;
	

	public MinMaxView(ScoreRecord scoreRecord) {
		this.scoreRecord = scoreRecord;
	}

	public void update() {
		// TODO Auto-generated method stub
		List<Integer> record = scoreRecord.getScoreRecord();
		displayMinMax(record);	// 최소 값과 최대 값을 출력함
	}

	private void displayMinMax(List<Integer> record) {
		// TODO Auto-generated method stub
		int min = Collections.min(record, null);
		int max = Collections.max(record, null);
		System.out.println("Min: " + min + " Max: " + max);
	}
}

```

```
public class Client {

	public static void main(String[] args) {
		ScoreRecord scoreRecord = new ScoreRecord();
		
		MinMaxView minMaxView = new MinMaxView(scoreRecord);
		
		scoreRecord.setStatisticsView(minMaxView);
		
		for(int index=1; index<=5;index++)
		{
			int score= index * 10;
			System.out.println("Adding " + score);
			
			// 10 20 30 40 50을 추가함, 추가할때마다 최대 3개의 점수만 출력함
			scoreRecord.addScore(score);
		}
	}

}

```

```
Adding 10
Min: 10 Max: 10
Adding 20
Min: 10 Max: 20
Adding 30
Min: 10 Max: 30
Adding 40
Min: 10 Max: 40
Adding 50
Min: 10 Max: 50

```

위 코드의 문제점은 OCP(Open-Closed Principle)에 위배된다. 점수가 입력시 지정된 특정 대상 클래스(처음에는 DataSheetView 클래스)에게 고정적으로 통보하도록 코딩이 되었는데 다른 대상 클래스(MinMaxView 클래스)에게 점수가 이력되었음을 통보하려면 ScoreRecord 클래스의 변경이 불가피하기 때문이다.

**동시 혹은 순차적으로 성적을 출력하는 경우**

성적이 입력 시 최대 3개 목록, 최대 5개 목록, 최소/최대 값을 동시에 출력하거나 처음에는 목록으로 출력하고 나중에는 최소/최대 값을 출력하려면 어떻게 해야 할까?

목록으로 출력하는 것은 DataSheetView 클래스를 활용하고 최소/최대 값을 출력하는 것은 MinMaxView 클래스를 활용할 수 있다. 그러므로 ScoreRecord 클래스는 2개의 DataSheetView 객체(3개 목록, 5개 목록 출력을 위한 객체)와 1개의 MinMaxView 객체에게 성적 추가를 통보할 필요가 있다. 이를 위해 ScoreRecord 클래스는 다시 변경되어야 한다.

```
public class ScoreRecord {
	private List<Integer> scores = new ArrayList<Integer>();	// 점수를 저장함
	
	// 복수 개의 DataSheetView
	private List<DataSheetView> dataSheetViews = new ArrayList<DataSheetView>();
	private MinMaxView minMaxView;	// 1개의 MinMaxView

	public void addDataSheetView(DataSheetView dataSheetView)
	{
		dataSheetViews.add(dataSheetView);
	}
	
	public void setMinMaxView(MinMaxView minMaxView)
	{
		this.minMaxView = minMaxView;
	}
	
	public void addScore(int score)	// 새로운 점수를 추가함
	{
		scores.add(score);	// scores 목록에 주어진 점수를 추가함
		for(DataSheetView dataSheetView : dataSheetViews)
		{
			dataSheetView.update();	// 각 DataSheetView에 값의 변경을 통보함
		}
		minMaxView.update(); // MinMaxView에 값의 변경을 통보함
	}
	
	public List<Integer> getScoreRecord()
	{
		return scores;
	}
}
```

```
public class DataSheetView {
	private ScoreRecord scoreRecord;
	private int viewCount;
	
	public DataSheetView(ScoreRecord scoreRecord, int viewCount) {
		this.scoreRecord = scoreRecord;
		this.viewCount = viewCount;
	}

	public void update() {	// 점수의 변경을 통보받음
		List<Integer> record = scoreRecord.getScoreRecord();	// 점수를 조회함
		displayScores(record,viewCount);	// 조회된 점수를 viewCount 만큼만 출력함
	}

	private void displayScores(List<Integer> record, int viewCount) {
		System.out.println("List of " + viewCount + " entries: ");
		for(int i=0; i<viewCount && i<record.size(); i++)
		{
			System.out.print(record.get(i) + " ");
		}
		System.out.println();
	}

}
```

```
public class MinMaxView {
	private ScoreRecord scoreRecord;
	

	public MinMaxView(ScoreRecord scoreRecord) {
		this.scoreRecord = scoreRecord;
	}

	public void update() {
		// TODO Auto-generated method stub
		List<Integer> record = scoreRecord.getScoreRecord();
		displayMinMax(record);	// 최소 값과 최대 값을 출력함
	}

	private void displayMinMax(List<Integer> record) {
		// TODO Auto-generated method stub
		int min = Collections.min(record, null);
		int max = Collections.max(record, null);
		System.out.println("Min: " + min + " Max: " + max);
	}
}
```

```
public class Client {

	public static void main(String[] args) {
		ScoreRecord scoreRecord = new ScoreRecord();

		DataSheetView dataSheetView3 = new DataSheetView(scoreRecord, 3);
		DataSheetView dataSheetView5 = new DataSheetView(scoreRecord, 5);
		MinMaxView minMaxView = new MinMaxView(scoreRecord);
		
		scoreRecord.addDataSheetView(dataSheetView3); // 3개 목록 DataSheetView 생성
		scoreRecord.addDataSheetView(dataSheetView5); // 5개 목록 DataSheetView 생성
		scoreRecord.setMinMaxView(minMaxView); // MinMaxView 생성
		
		for(int index=1;index<=5;index++)
		{
			int score = index + 10;
			System.out.println("Adding " + score);
			
			// 10 20 30 40 50이 추가됨
			// 추가할 때마다 최대 3개 목록, 최대 5개 목록 그리고 최소/최대 값이 출력됨
			scoreRecord.addScore(score);
		}
	}

}
```

```
Adding 11
List of 3 entries: 
11 
List of 5 entries: 
11 
Min: 11 Max: 11
Adding 12
List of 3 entries: 
11 12 
List of 5 entries: 
11 12 
Min: 11 Max: 12
Adding 13
List of 3 entries: 
11 12 13 
List of 5 entries: 
11 12 13 
Min: 11 Max: 13
Adding 14
List of 3 entries: 
11 12 13 
List of 5 entries: 
11 12 13 14 
Min: 11 Max: 14
Adding 15
List of 3 entries: 
11 12 13 
List of 5 entries: 
11 12 13 14 15 
Min: 11 Max: 15
```

위와 같은 경우에도 통보 대상이 변경된 것을 반영하려고 ScoreRecord 클래스의 코드를 수정하게 되었다. 이러한 상황은 성적 변경을 새로운 클래스에 통보할 때마다 반복적으로 발생하게 될 것이다. 예를 들어 평균/표준편차를 출력하는 StatisticsView 클래스에게 성적 변경을 통보하려면 ScoreRecord는 다시 변경되어야 한다.

### **9.4 해결책**

문제 해결의 핵심은 성적 통보 대상이 변경되더라도 ScoreRecord 클래스를 그대로 재사용할 수 있어야 한다는 점이다. 따라서 ScoreRecord 클래스에서 변화되는 부분을 식별하고 이를 일반화시켜야 한다.

ScoreRecord 클래스에서는 통보 대상인 객체를 참조하는 것을 관리해야 하며 addScore 메서드는 각 통보 대상인 객체의 update 메서드를 호출할 필요가 있다. 이런 통보 대상 객체(DataSheetView, MinMaxView)의 관리와 각 객체에 update 메서드를 호출하는 기능은 성적 변경뿐만 아니라 임의의 데이터가 변경되었을 때 이에 관심을 가지는 모든 대상 객체에 통보하는 경우에도 동일하게 발생하는 기능이다. 따라서 이러한 공통 기능을 상위 클래스 및 인터페이스로 일반화하고 이를 활용해 ScoreRecord를 구현하는 방식으로 설계를 변경하는 편이 좋다.

**개선된 ScoreRecord의 클래스 다이어그램**

![개선된 ScoreRecord의 클래스 다이어그램](https://github.com/yonghwankim-dev/DesignPattern/blob/master/DesignPattern/src/chapter09_%EC%98%B5%EC%84%9C%EB%B2%84%ED%8C%A8%ED%84%B4/diagram/observer-pattern_improve.png)

-   Subject : 성적 변경에 관심이 있는 대상 객체를 관리하는 기능을 구현
    -   attach : 성적 변경에 관심이 있는 대상 객체를 추가한다.
    -   detach : 성적 변경에 관심이 있는 대상 객체를 제거한다.
-   DataSheetView, MinMaxView : 성적 변경에 관심이 있는 대상 객체

**개선된 ScoreRecord의 클래스 다이어그램 수행 과정**

1.  ScoreRecord 클래스의 addScore 메서드가 호출 후 자신의 성적 값을 저장
2.  Subject 클래스의 notifyObservers 메서드 호출 후 DataSheetView와 MinMaxView 클래스에게 성적 변경을 통보한다.
3.  Subject 클래스는 Observer 인터페이스를 통해 DataSheetView와 MinMaxView 객체의 update 메서드를 호출

**개선된 ScoreRecord의 클래스 다이어그램 기반 코드**

```
public interface Observer {
	public abstract void update();
}
```

```
public abstract class Subject {	// 추상화된 변경 관심 대상 데이터
	
	private List<Observer> observers = new ArrayList<Observer>();	// 추상화된 통보 대상 목록
	
	public void attach(Observer observer)	// 옵서버, 즉 통보 대상을 추가함
	{
		observers.add(observer);
	}
	
	public void detach(Observer observer)	// 옵서버, 즉 통보 대상을 제거함
	{
		observers.remove(observer);
	}
	
	// 통보 대상 목록, 즉 observers의 각 옵서버에게 변경을 통보함
	public void notifyObservers()
	{
		for(Observer o: observers)
		{
			o.update();
		}
	}
}
```

```
public class ScoreRecord extends Subject{
	private List<Integer> scores = new ArrayList<Integer>();	// 점수를 저장함
	
	public void addScore(int score)
	{
		scores.add(score);
		
		// 데이터가 변경되면 Subject 클래스의 notifyObservers 메서드를 호출해
		// 각 옵서버(통보 대상 클래스)에게 데이터의 변경을 통보함
		notifyObservers();
	}
	
	public List<Integer> getScoreRecord()
	{
		return scores;
	}
	
}
```

```
// DataSheetView는 Observer의 기능, 즉 update 메서드를 구현함으로써 통보 대상이 됨
public class DataSheetView implements Observer {
	private ScoreRecord scoreRecord;
	private int viewCount;
	
	public DataSheetView(ScoreRecord scoreRecord, int viewCount) {
		this.scoreRecord = scoreRecord;
		this.viewCount = viewCount;
	}

	public void update() {	// 점수의 변경을 통보받음
		List<Integer> record = scoreRecord.getScoreRecord();	// 점수를 조회함
		displayScores(record,viewCount);	// 조회된 점수를 viewCount 만큼만 출력함
	}

	private void displayScores(List<Integer> record, int viewCount) {
		System.out.println("List of " + viewCount + " entries: ");
		for(int i=0; i<viewCount && i<record.size(); i++)
		{
			System.out.print(record.get(i) + " ");
		}
		System.out.println();
	}

}

```

```
// MinMaxView는 Observer의 기능, 즉 update 메서드를 구현함으로써 통보 대상이 됨
public class MinMaxView implements Observer{
	private ScoreRecord scoreRecord;
	

	public MinMaxView(ScoreRecord scoreRecord) {
		this.scoreRecord = scoreRecord;
	}

	public void update() {
		// TODO Auto-generated method stub
		List<Integer> record = scoreRecord.getScoreRecord();
		displayMinMax(record);	// 최소 값과 최대 값을 출력함
	}

	private void displayMinMax(List<Integer> record) {
		// TODO Auto-generated method stub
		int min = Collections.min(record, null);
		int max = Collections.max(record, null);
		System.out.println("Min: " + min + " Max: " + max);
	}
}
```

```
public class Client {

	public static void main(String[] args) {
		ScoreRecord scoreRecord = new ScoreRecord();

		DataSheetView dataSheetView3 = new DataSheetView(scoreRecord, 3);
		DataSheetView dataSheetView5 = new DataSheetView(scoreRecord, 5);
		MinMaxView minMaxView = new MinMaxView(scoreRecord);
		
		// 3개 목록 DataSheetView를 ScoreRecord에 Observer로 추가함
		scoreRecord.attach(dataSheetView3);
		
		// 5개 목록 DataSheetView를 ScoreRecord에 Observer로 추가함
		scoreRecord.attach(dataSheetView5);
		
		// MinMaxView를 ScoreRecord에 Observer로 추가함
		scoreRecord.attach(minMaxView);

		for(int index=1;index<=5;index++)
		{
			int score = index + 10;
			System.out.println("Adding " + score);
			scoreRecord.addScore(score);
		}
	}

}
```

```
Adding 11
List of 3 entries: 
11 
List of 5 entries: 
11 
Min: 11 Max: 11
Adding 12
List of 3 entries: 
11 12 
List of 5 entries: 
11 12 
Min: 11 Max: 12
Adding 13
List of 3 entries: 
11 12 13 
List of 5 entries: 
11 12 13 
Min: 11 Max: 13
Adding 14
List of 3 entries: 
11 12 13 
List of 5 entries: 
11 12 13 14 
Min: 11 Max: 14
Adding 15
List of 3 entries: 
11 12 13 
List of 5 entries: 
11 12 13 14 15 
Min: 11 Max: 15

```

성적 변경에 관심이 있는 대상 객체들(DataSheetView, MinMaxView)의 관리는 Subject 클래스에서 구현한다.

ScoreRecord 클래스는 Subject 클래스를 상속받게 함으로써 ScoreRecord 클래스는 이제 DataSheetView와 MinMaxView를 직접 참조할 필요가 없게 되었다. 따라서 ScoreRecord 클래스의 코드를 변경하지 않고도 새로운 관심 클래스 및 객체를 추가/제거하는 것이 가능해졌다.
