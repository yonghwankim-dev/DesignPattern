**1.1 모델링이란?**

-    모델링이란 소프트웨어 시스템의 구조와 행위를 명세하는 것을 의미한다.

**1.2 UML(Unified Modeling Language)**

-    UML은 표준화된 통합 모델링 언어이다.
-   요구 분석, 시스템 설계, 시스템 구현 등 시스템 개발 과정에서 개발자 사이의 의사 소통이 원할하게 이루어지도록 하는 언어이다.

**1.3 클래스 다이어그램**

-   UML의 정적 구조 다이어그램
-   클래스와 클래스들끼리의 관계를 표현
-   주요 구성 요소
    1.  클래스 : 속성과 기능으로 구성된 객체의 집합
    2.  관계 : 2개 이상의 클래스들간에 기능을 호출하는 것

**1.3.2 관계의 종류**

<table style="border-collapse: collapse; width: 100%; height: 120px;" border="1" data-ke-style="style14"><tbody><tr style="height: 20px;"><td style="width: 50%; height: 20px;">관계</td><td style="width: 50%; height: 20px;">설명</td></tr><tr style="height: 20px;"><td style="width: 50%; height: 20px;">연관 관계(Association)</td><td style="width: 50%; height: 20px;">한 클래스가 다른 클래스에서 제공하는 기능을 사용하는 상황에서 사용됨</td></tr><tr style="height: 20px;"><td style="width: 50%; height: 20px;">일반화 관계(Generalization)</td><td style="width: 50%; height: 20px;">객체지향모델리에서 상속 관계를 표현</td></tr><tr style="height: 20px;"><td style="width: 50%; height: 20px;">집합 관계(Composition, Aggregation)</td><td style="width: 50%; height: 20px;">클래스들 사이의 전체 또는 부분 관계</td></tr><tr style="height: 20px;"><td style="width: 50%; height: 20px;">의존 관계(Dependency)</td><td style="width: 50%; height: 20px;">두 클래스의 관계가 하나의 메서드를 실행하는 동안과 같은 매우 짧은 시간만 유지되는 관계</td></tr><tr style="height: 20px;"><td style="width: 50%; height: 20px;">실체화 관계(Realization)</td><td style="width: 50%; height: 20px;">인터페이스와 추상 메서드들을 실제로 구현한 클래스들 사이의 관계를 표현</td></tr></tbody></table>

**연관 관계(Association)**

-   한 클래스가 다른 클래스에서 제공하는 기능을 사용하는 상황
    -   예를 들어 Professor 클래스는 필드로 student 인스턴스를 활용하여 Student 클래스의 기능을 호출한다.

[##_Image|kage@bem0Go/btq4ygyVroa/hjlEIkfuwoaEZTH7uFWdY0/img.png|alignCenter|data-origin-width="0" data-origin-height="0" data-ke-mobilestyle="widthContent"|Professor 클래스와 Student 클래스간의 연관 관계 표현||_##]

-   **단방향 연관 관계(Unidirectional Association)**
    -   한쪽으로만 방향성이 있는 연관 관계, 화살표를 지목당한 클래스는 지목한 클래스를 알지 못한다.
    -   예를 들어 Student 클래스는 Course 클래스를 알골 있지만 Course 클래스는 Student 클래스를 알지 못한다.

[##_Image|kage@UDcT2/btq4CrfDgv4/sKLluECgtHOG9SkXkv2BSK/img.png|alignCenter|data-origin-width="0" data-origin-height="0" data-ke-mobilestyle="widthContent"|Student 클래스는 메소드의 인자를 통해서 Course 클래스를 알고 있는 단방향 연관 관계 표현||_##]

-   양방향 연관 관계(Bidirectional Association)
    -   양방향 연관 관계는 서로의 클래스가 존재를 알고 있다.
    -   M:N 양방향 연관 관계같은 경우 구현하기가 복잡하여 1:N 단방향 연관 관계로 변환하여 구현한다.
        -   예를 들어 Student 클래스는 여러개의 Course 클래스를 수강이 가능하고 Course 클래스에도 여러명의 학생이 존재할 수 있다.  ![](https://blog.kakaocdn.net/dn/b2NLW2/btq4s2akxSU/Zrgt7Y9ceKW8yzk2YX2LBK/img.png)
            -   아래와 같이 중간에 Transcript 클래스를 두어 M:N 양방향 연관 관계를 1:N, N:1 단방향 연관 관계로 변환한다.![](https://blog.kakaocdn.net/dn/byexuK/btq4F7AsVrw/XxZIyXEYH2x11MS8YcjofK/img.png)
-   재귀적 연관 관계(Recursion Association)
    -   같은 클래스들끼리 연관 관계를 갖고 있으며 상하 관계가 존재하고 사이클이 존재하지 않는다. ![](https://blog.kakaocdn.net/dn/AnrOa/btq4EcPzjGM/L1Zk9RKvdbZiGhMHlSadN0/img.png)

**일반화 관계(Generalization)**

-   하나의 클래스가 다른 클래스를 포함하는 상위 개념일때 구성되는 관계 ![](https://blog.kakaocdn.net/dn/zGg04/btq4EsZehfD/MzNhsDMiy6cdYcPiCUoqc1/img.png)

**집합 관계(Composition, Aggregation)**

-   집합 관계는 한 객체가 다른 객체를 포함하는 것을 나타낸다.
-   집약 관계(Aggregation)와 합성 관계(Composition) 모두 한 객체가 다른 객체를 포함한다.
-   **집약 관계(Aggregation)**
    -   전체 객체와 부분 객체가 독립적
    -   전체 객체가 메모리에서 사라져도 부분 객체는 사라지지 않는다.

```
public class Computer{
	private MainBoard mb;
    private CPU c;
    private Memory m;
    private PowerSupply ps;
    
    public Computer(MainBoard mb, CPU c, Memory m, PowerSupply ps){
    	this.mb = mb;
        this.c = c;
        this.m = m;
        this.ps = ps;
    }
}
```

위와 같이 집약 관계(Aggregation)은 Computer 객체가 사라져도 부품을 구성하는 MainBoard, CPU, Memory, PowerSupply 객체는 사라지지 않는다.

-   **합성 관계(Composition)**
    -   부분 객체가 전체 객체에게 의존적
    -   전체 객체가 메모리에서 사라지면 부분 객체도 삭제 ![](https://blog.kakaocdn.net/dn/UWJPo/btq4CsZXYrv/7pFeqXlEQ0SKLWM8kdB8jK/img.png)

```
public class Computer{
	private MainBoard mb;
    private CPU c;
    private Memory m;
    private PowerSupply ps;
    
    public Computer(){
    	this.mb = new MainBoard();
        this.c = new CPU();
        this.m = new Memory();
        this.ps = new PowerSupply();
    }
}
```

위와 같이 합성 관계(Composition)는 생성자 내에서 MainBoard, CPU, Memory, PowerSupply 객체를 생성하기 때문에 Computer 객체가 사라지면 같이 사라진다. 즉, 부품 객체들의 생명주기가 Computer 객체의 생명주기에 의존하는 관계가 형성된다.

**의존 관계(Dependency)**

-   한 클래스가 다른 클래스를 사용하는 관계
-   의존 관계를 사용하는 경우
    
    -   클래스의 속성에서 참조
    -   기능의 매개변수로 사용
    -   메서드 내부의 지역 객체로 사용
    
    ![](https://blog.kakaocdn.net/dn/nydwU/btq4HG3PASR/J1I9y8qxgXKBc3uDB91JL1/img.png)

```
public class Car{
	...
    public void fillGas(GasPump p){
    	p.getGas(amount);
    }
}
```

위와 같이 Car 클래스는 GasPump 클래스를 인자로 일시적으로 사용한다.

**실체화 관계(Realization)**

-   인터페이스란 책임(Responsibility)이다.
-   책임이란 객체가 해야 하는 일을 의미함
-   객체가 외부에 제공하는 서비스나 기능은 객체가 수행하는 책임을 본다.
    -   예를 들어 TV 리모컨은 TV를 켜거나 끄는 것과 같은 책임을 수행한다.
-   인터페이스를 어떤 공통되는 능력이 있는 것들을 대표적인 관점으로 볼 수 있다.
    
    -   예를 들어 비행기(Plane)과 새(Bird)는 공통적으로 날 수 있는 능력이 존재함. 공통 능력(Flayable)이라는 관점에서 아래와 같이 비행기와 새를 그룹화 할 수 있는 메커니즘이 바로 인터페이스이다.
    
    ![](https://blog.kakaocdn.net/dn/dcZvAF/btq4yjXpZtP/TkG1mPW4CiZsXhSOq4jCK1/img.png)
-   **인터페이스는 실체화된 클래스들의 공통된 기능들을 그룹화 한 것을 의미**
-   **실체화는 인터페이스를 기반으로 실제 생성된 클래스를 의미**

**References**

> **JAVA 객체지향 디자인 패턴**