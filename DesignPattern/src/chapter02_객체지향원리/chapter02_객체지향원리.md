2. **객체 지향 원리**

객체 지향 원리는 추상화, 캡슐화, 일반화, 다형성으로 구성되어 있다.

**2.1 추상화**

**추상화란?**

-   어떤 영역에서 필요로 하는 속성이나 행동(기능)을 추출하는 작업을 의미
-   사물들의 공통된 특징을 추출해서 집합화를 수행
    -   예를 들어 자동차에는 아우디, 벤츠, 현대와 같은 사물들이 존재하고 이 사물들의 공통점은 모두 자동차이다. 따라서 아우디, 벤츠, 현대와 같은 사물들은 자동차라는 집합으로 추상화가 가능하다.

**추상화의 필요성**

자동차 종류마다 엔진 오일을 교환하는 방식이 다르다고 가정한다.

```java
switch(자동차종류)
    case 아우디: // 아우디 엔진 오일을 교환하는 과정
    case 벤츠: // 벤츠 엔진 오일을 교환하는 과정
```

위와 같은 상태에서 BMW 자동차 엔진 오일을 교환하는 기능을 추가하라는 요구사항 요청 시 다음과 같이 수정될 수 있다. 아래와 같이 요구사항이 추가 될 시 수정사항이 많아져서 문제가 발생할 수 있다.

```java
switch(자동차종류)
    case 아우디: // 아우디 엔진 오일을 교환하는 과정
    case 벤츠: // 벤츠 엔진 오일을 교환하는 과정
    case BMW: // BMW 엔진 오일을 교환하는 과정
```

**추상화 개념 적용**

아우디, 벤츠, BMW와 같은 클래스들의 추상화 개념으로 Car 클래스를 정의한다.

```java
public void changeEngineOil(Car c){
	c.changeEngineOil();
}
```

위와 같이 매개변수로 Car 클래스의 자식 클래스인 아우디, 벤츠, BMW 객체가 들어와도 메소드 내용의 변경 없이 자동차 엔진 오일을 변경할 수 있다.

**2.2 캡슐화**

**캡슐화란?**

캡슐화는 정보은닉(Information Hiding)을 통해 필드 멤버와 메소드를 은닉시키고 높은 은닉도와 낮은 결합도를 갖도록 해주는 객체지향 설계 원리중 하나이다.

**응집도**

클래스나 모듈 안의 요소들이 얼마나 밀접하게 관련되어 있는지를 나타냄

**결합도**

어떤 기능을 실행하는데 다른 클래스나 모듈들에 얼마나 의존적인지를 나타냄

**캡슐화(정보은닉)의 필요성**

정보은닉을 수행하지 않으면 소프트웨어 결합이 많을수록 문제가 많이 발생한다.

```java
public class ArrayStack{
    public int top;
    public int[] itemArray;
    public int stackSize;
    
    //...
}

public class StackClient{
	public static void main(String args[]){
    	ArrayStack st = new ArrayStack(10);
        st.itemArray[++st.top] = 20;
        System.out.println(st.itemArray[st.top]);	// 20
    }
}
```

위의 코드와 같이 ArrayStack의 필드 멤버(top, itemArray, StackSize)의 접근 제어자가 public으로 선언 시 push 메소드나 pop 메소드를 사용하지 않고 직접 배열에 값을 저장할 수 있다. 이와 같은 경우 Stack이라는 자료구조에 문제가 발생할 수 있다. 따라서 ArrayStack 클래스와 StackClient 클래스는 강한 결합이 발생한다.

**캡슐화(정보은닉화)의 적용**

다음과 같이 필드 멤버들의 접근 제어자를 private로 선언하여 캡슐화(정보 은닉화)를 수행한다.

```java
public class ArrayStack{
    private int top;
    private int[] itemArray;
    private int stackSize;
    
    // ...
}
```

**2.3 일반화**

-   일반화 관계는 객체지향 프로그래밍 관점에서는 상속관계이다.
-   하지만 속성이나 기능의 재사용만 강조해서 사용하는 경우가 많다. 이는 일반화 관계를 한정되게 바라보는 시각이다.
-   **일반화 관계는 자식 클래스를 외부로부터 정보 은닉화하는 캡슐화의 일종이다.**

![](https://github.com/yonghwankim-dev/DesignPattern/blob/master/DesignPattern/src/chapter02_%EA%B0%9D%EC%B2%B4%EC%A7%80%ED%96%A5%EC%9B%90%EB%A6%AC/diagram/01_generalization.png)

**일반화의 필요성**

아래 코드는 장바구니에 있는 과일 가격의 총합을 구하는 코드이다.

```java
int sum = 0;
while(장바구니에 과일이 존재){
	switch(과일 종류){
    	case 사과:
            sum += 사과 가격
            break;
        case 바나나:
            sum += 바나나 가격
            break;
        case 포도:
            sum += 포도 가격
            break;
    }
}
```

위의 코드에서 만약 과일이 늘어난다면 소스 코드의 수정이 불가피하다.

**일반화의 적용**

위의 코드에서 사과, 바나나, 포도와 같은 클래스들을 일반화를 적용하여 Fruit이라는 클래스로 일반화를 적용한다.

Fruit 클래스의 인스턴스는 사과, 바나나, 포도 인스턴스를 저장할 수 있기 때문에 아래와 같이 변경할 수 있다.

```java
public int computeTotalPrice(LinkedList<Friuit> f){
    int total = 0;
    iterator<Fruit> itr = f.iterator();
    
    while(itr.hasNext()){
    	Fruit curFruit = itr.next();
        total += curFruit.calculatePrice();
    }
}
```

위와 같이 변경하면 어떤 과일 클래스가 추가된다 하더라도 computeTotalPrice의 메소드 내용은 변경되지 않는다.

calculatePrice 메소드는 실제 과일 객체의 종류에 따라 다르게 수행된다. 이는 **다형성**에 따른 것이다.

**일반화와 캡슐화의 관계**

캡슐화는 필드 멤버 또는 메소드에 대해서 private 접근 제어자를 정의하여 외부로부터 정보를 은닉한다. **일반화는 상속 관계를 통하여 외부로부터 자식 클래스의 정보를 은닉하여 보호한다.** 즉, 일반화는 캡슐화의 확장된 버전이라고 생각한다.

아래 그림과 같이 사람 클래스는 아우디, 벤츠, BMW와 같은 클래스들을 직접적으로 참조하지 않고 오직 상위 클래스인 자동차 클래스와만 참조된다.

![](https://github.com/yonghwankim-dev/DesignPattern/blob/master/DesignPattern/src/chapter02_%EA%B0%9D%EC%B2%B4%EC%A7%80%ED%96%A5%EC%9B%90%EB%A6%AC/diagram/02_generalization-capsulation_relation.png)

**2.4 다형성**

**다형성이란?**

다형성은 서로 다른 클래스의 객체가 같은 메시지를 받았을 때 각자의 방식으로 동작하는 능력이다.

예를 들어 고양이, 강아지에게 talk()이라는 메소드를 전달할때 고양이 객체는 '야옹'이라고 울고, 강아지 객체는 '멍멍'이라고 울것이다. **즉, 모두 같은 메소드 연산을 수행하지만 행동 방식이 모두 다른 것을 다형성이라고 한다.**

**다형성을 적용하지 않은 코드**

```java
class Dog{
	public void bark(){...}
}
class Cat{
	public void meow(){...}
}
public class Client{
	public static void main(String args[]){
    	Dog d = new Dog();
        Cat c = new Cat();
        d.bark();
        c.bark();
    }
}
```

위와 같이 다형성을 적용하지 않는다면 클래스별(Dog, Cat)로 다르게 처리해주어야 한다. 이때 새로운 동물이 추가된다면 소스코드의 변경의 영향을 받을 수 밖에 없다.

**다형성을 적용한 코드**

```java
abstract class Pet{
	public abstract void talk();
}
class Dog extends Pet{
	public void talk(){
    	System.out.println("멍멍"):
    }
}
class Cat extends Pet{
	public void talk(){
    	System.out.println("야옹");
    }
}
public class Client{
	public static void main(String args[]){
    	Pet[] pets = {new Dog(), new Cat()};
        
        for(Pet p : pets){
        	p.talk();
        }
    }
}
```

위와 같이 Dog, Cat의 상위 클래스로 Pet 추상 클래스를 정의하고 추상 메소드로 talk() 메서드를 정의한다.

자식 클래스인 Dog, Cat 클래스는 talk() 메서드를 오버라이드하여 자신만의 메소드 내용을 수행한다.

위와 같이 가능한 이유는 **일반화 관계에 있을때 부모 클래스의 참조 변수가 자식 클래스의 객체를 참조가 가능하기 때문이다.**

**객체지향원리 정리**

**1\. 추상화**

-   **사물들의 공통된 속성과 기능을 추출하는 작업**

**2\. 캡슐화**

-   **외부의 클래스가 한 클래스의 필드 멤버들의 접근을 막기 위한 정보 은닉화 과정**

**3\. 일반화**

-   **캡슐화의 일종으로 외부의 클래스가 자식 클래스의 접근을 차단하기 위해서 상위 클래스를 정의하는 작업**

**4\. 다형성**

-   **서로 다른 객체들이 같은 메시지를 받았을 때 각자의 방식으로 수행하는 능력**

**References**

> **JAVA 객체 지향 디자인 패턴**
