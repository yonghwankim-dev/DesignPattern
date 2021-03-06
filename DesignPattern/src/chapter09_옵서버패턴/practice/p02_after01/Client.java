package chapter09_옵서버패턴.practice.p02_after01;

public class Client {

	public static void main(String[] args) {
		ScoreRecord scoreRecord = new ScoreRecord();
		
		MinMaxView minMaxView = new MinMaxView(scoreRecord);
		
		scoreRecord.setStatisticsView(minMaxView);
		
		for(int index=1; index<=5;index++)
		{
			int score= index * 10;
			System.out.println("Adding " + score);
			
			// 10 20 30 40 50을 추가함, 추가할때마다 최대 3개의 점수만 출력함
			scoreRecord.addScore(score);
		}
	}

}
