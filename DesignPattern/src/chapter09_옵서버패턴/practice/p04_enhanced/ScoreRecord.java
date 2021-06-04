package chapter09_옵서버패턴.practice.p04_enhanced;

import java.util.ArrayList;
import java.util.List;

import chapter09_옵서버패턴.practice.p04_enhanced.observer.Subject;




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
