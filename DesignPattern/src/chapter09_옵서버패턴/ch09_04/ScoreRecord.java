package chapter09_�ɼ�������.ch09_04;

import java.util.ArrayList;
import java.util.List;

import chapter09_�ɼ�������.ch09_04.observer.Subject;



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
