package chapter09_옵서버패턴.practice.p04_enhanced;

import java.util.List;

import chapter09_옵서버패턴.practice.p04_enhanced.observer.Observer;


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
