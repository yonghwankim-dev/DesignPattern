package chapter08_Ŀ�ǵ�����.exercise.ex02.command;

public class TV {
	private boolean powerOn = false;
	private boolean muteOn = false;
	
	public void power() {
		// TODO Auto-generated method stub
		// false -> true
		// true -> false
		powerOn = !powerOn;
		
		if(powerOn)
		{
			System.out.println("Power On");
		}
		else
		{
			System.out.println("Power Off");
		}
	}

	public void mute() {
		// TODO Auto-generated method stub
		// powerOn==false�̸� ���� 
		if(!powerOn)
		{
			return;
		}
		
		muteOn = !muteOn;
		if(muteOn)
		{
			System.out.println("Mute On");
		}
		else
		{
			System.out.println("Mute Off");
		}
	}

}
