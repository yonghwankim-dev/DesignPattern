package chapter06_싱글턴패턴.ch06_10;

public class ServerProxy implements Server {

	@Override
	public void doSomeThing() {
		// TODO Auto-generated method stub
		// 실제 서버와 네트워크 연결 같은 여러 작업을 수행함.
		System.out.println("ServerProxy doSomeThing call");
	}
}
