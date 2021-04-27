package chapter09_옵서버패턴.ch09_04;

public class Client {

	public static void main(String[] args) {
		ScoreRecord scoreRecord = new ScoreRecord();

		DataSheetView dataSheetView3 = new DataSheetView(scoreRecord, 3);
		DataSheetView dataSheetView5 = new DataSheetView(scoreRecord, 5);
		MinMaxView minMaxView = new MinMaxView(scoreRecord);
		
		// 3개 목록 DataSheetView를 ScoreRecord에 Observer로 추가함
		scoreRecord.attach(dataSheetView3);
		
		// 5개 목록 DataSheetView를 ScoreRecord에 Observer로 추가함
		scoreRecord.attach(dataSheetView5);
		
		// MinMaxView를 ScoreRecord에 Observer로 추가함
		scoreRecord.attach(minMaxView);

		for(int index=1;index<=5;index++)
		{
			int score = index + 10;
			System.out.println("Adding " + score);
			scoreRecord.addScore(score);
		}
	}

}
