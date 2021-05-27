# ��������

## #01. �Ʒ��� ������ �̱��� ������ �߸��� ���� ��� ã�� �����Ͻÿ�.

```java
// �̱��� ����
public class Singleton {

    private Singleton instance = null; // ���� �����̾���
    
    public Singleton() {  // ���������ڸ� private �̾����

    }

    public static Singleton getInstance() { // synchronized Ű���带 ����Ͽ� ����ȭó���� �ʼ�����
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void doSomething() {
        //...
    }
    
}

```

### 02. �̱��� ������ ����� ���� �䱸������ �����ϴ� Ƽ�� ���� ���α׷��� �ڵ�� �ۼ��Ͻÿ�.

�䱸������ �Ʒ��� ����.

- ����ڴ� Ƽ�� ����⸦ �̿��� Ƽ���� ������� �� �ִ�.
- Ƽ�� ������ �� �ϳ��� �����Ѵ�.
- ����� Ƽ���� ������ �ø��� ��ȣ�� �ִ�.
- Ƽ���� �ø��� ��ȣ�� 0���� Ŀ���ϰ�, 0�� �ø��� ��ȣ�� ��ȿ���� ���� Ƽ���� �ǹ��Ѵ�.
- ����� �� �ִ� Ƽ�� ������ �����Ǿ� �ִ�.

### 04. ������ �־��� `UserThread`, `Printer` Ŭ������ `main()` �޼��带 �̿��� ������ ������(`PrinterManager` Ŭ����)�� �̱��� �������� �ۼ��϶�. 

�䱸������ �Ʒ��� ����.

- ������ �����ڴ� �� �ϳ��� �����Ѵ�.
- ������ �����ڴ� 3���� �����͸� �����Ѵ�.
- ������ �����ڴ� �̿��� �� �ִ� �����͸� ����ڿ��� �Ҵ��Ѵ�.
- ������ �̿��� ���������� Ȯ���Ϸ��� ������ Ŭ������ `isAvailable()` �޼��带 �̿��Ѵ�.
- ������� ��� ����� `UserThread` Ŭ������ �̿��� �޴´�.

### 05. ���� `UserServer` Ŭ������ ��Ʈ��ũ�� ����� ������ ���� �۾��� �����Ѵ�. �̿� ���� �ۼ��� �ڵ�� `UserServer` Ŭ������ ����� �׽�Ʈ�� �� �ݵ�� ������ ����� �� �ִٴ� ���� ������ �Ѵ�. �׷��� �����δ� ��Ʈ��ũ�� �ҿ����ϰų� ������ �ٿ�� ���� ������ �ӵ��� ������ �� ���� �ִ�. �̷��� ������ �ذ��ϴ� ����� �����϶�.

```java
publc class ServerFactory {
    public static Sever getServer() {
        return new ServerProxy();
    }
}

public class ServerProxy {
    public void doSomething() {
        // ���� ������ ��Ʈ��ũ ���� ���� �۾��� ����
    }
}

public class UseServer {
    public void doSomething() {
        ServerProxy server = SeverFactory.getServer();
        server.doSomething();
    }
}
``` 