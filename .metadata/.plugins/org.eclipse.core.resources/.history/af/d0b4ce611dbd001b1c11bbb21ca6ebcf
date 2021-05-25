package chapter05_스트래티지패턴.ch05_03;

import chapter05_스트래티지패턴.ch05_03.strategy.attack.MissileStrategy;
import chapter05_스트래티지패턴.ch05_03.strategy.attack.PunchStrategy;
import chapter05_스트래티지패턴.ch05_03.strategy.moving.FlyingStrategy;
import chapter05_스트래티지패턴.ch05_03.strategy.moving.WalkingStrategy;

public class Client {
	public static void main(String args[])
	{
		Robot taekwonV = new TaekwonV("TaekwonV");
		Robot atom = new Atom("Atom");
		
		taekwonV.setMovingStrategy(new WalkingStrategy());
		taekwonV.setAttackStrategy(new MissileStrategy());
		
		atom.setMovingStrategy(new FlyingStrategy());
		atom.setAttackStrategy(new PunchStrategy());
		
		System.out.println("My name is " + taekwonV.getName());
		taekwonV.move();
		taekwonV.attack();
		
		System.out.println("My name is " + atom.getName());
		atom.move();
		atom.attack();
		
	}
}
