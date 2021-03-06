package chapter09_옵서버패턴.practice.p02_after01;

import java.util.Collections;
import java.util.List;

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
