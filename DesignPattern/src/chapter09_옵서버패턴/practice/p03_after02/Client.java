package chapter09_옵서버패턴.practice.p03_after02;

public class Client {

	public static void main(String[] args) {
		ScoreRecord scoreRecord = new ScoreRecord();

		DataSheetView dataSheetView3 = new DataSheetView(scoreRecord, 3);
		DataSheetView dataSheetView5 = new DataSheetView(scoreRecord, 5);
		MinMaxView minMaxView = new MinMaxView(scoreRecord);
		
		scoreRecord.addDataSheetView(dataSheetView3); // 3개 목록 DataSheetView 생성
		scoreRecord.addDataSheetView(dataSheetView5); // 5개 목록 DataSheetView 생성
		scoreRecord.setMinMaxView(minMaxView); // MinMaxView 생성
		
		for(int index=1;index<=5;index++)
		{
			int score = index + 10;
			System.out.println("Adding " + score);
			
			// 10 20 30 40 50이 추가됨
			// 추가할 때마다 최대 3개 목록, 최대 5개 목록 그리고 최소/최대 값이 출력됨
			scoreRecord.addScore(score);
		}
	}

}
