package chapter09_�ɼ�������.practice.p04_enhanced;

import java.util.ArrayList;
import java.util.List;

import chapter09_�ɼ�������.practice.p04_enhanced.observer.Subject;




public class ScoreRecord extends Subject{
	private List<Integer> scores = new ArrayList<Integer>();	// ������ ������
	
	public void addScore(int score)
	{
		scores.add(score);
		
		// �����Ͱ� ����Ǹ� Subject Ŭ������ notifyObservers �޼��带 ȣ����
		// �� �ɼ���(�뺸 ��� Ŭ����)���� �������� ������ �뺸��
		notifyObservers();
	}
	
	public List<Integer> getScoreRecord()
	{
		return scores;
	}
	
}
