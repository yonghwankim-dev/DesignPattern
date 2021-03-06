package chapter09_옵서버패턴.practice.p04_enhanced;

import java.util.Collections;
import java.util.List;

import chapter09_옵서버패턴.practice.p04_enhanced.observer.Observer;

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
