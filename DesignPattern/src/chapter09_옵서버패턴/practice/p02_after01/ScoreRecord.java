package chapter09_옵서버패턴.practice.p02_after01;

import java.util.ArrayList;
import java.util.List;

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
