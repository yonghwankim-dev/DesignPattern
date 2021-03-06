package chapter09_옵서버패턴.practice.p03_after02;

import java.util.ArrayList;
import java.util.List;



public class ScoreRecord {
	private List<Integer> scores = new ArrayList<Integer>();	// 점수를 저장함
	
	// 복수 개의 DataSheetView
	private List<DataSheetView> dataSheetViews = new ArrayList<DataSheetView>();
	private MinMaxView minMaxView;	// 1개의 MinMaxView

	public void addDataSheetView(DataSheetView dataSheetView)
	{
		dataSheetViews.add(dataSheetView);
	}
	
	public void setMinMaxView(MinMaxView minMaxView)
	{
		this.minMaxView = minMaxView;
	}
	
	public void addScore(int score)	// 새로운 점수를 추가함
	{
		scores.add(score);	// scores 목록에 주어진 점수를 추가함
		for(DataSheetView dataSheetView : dataSheetViews)
		{
			dataSheetView.update();	// 각 DataSheetView에 값의 변경을 통보함
		}
		minMaxView.update(); // MinMaxView에 값의 변경을 통보함
	}
	
	public List<Integer> getScoreRecord()
	{
		return scores;
	}
}
