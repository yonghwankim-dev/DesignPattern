package chapter09_옵서버패턴.exercise.ex02;

public class ElevatorController extends Subject{
	private int curFloor = 1;
	
	public void gotoFloor(int destination)
	{
		curFloor = destination;
		notifyObservers();
	}
	
	public int getCurFloor()
	{
		return curFloor;
	}
}
