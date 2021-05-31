package chapter08_커맨드패턴.exercise.ex02;

import chapter08_커맨드패턴.exercise.ex02.command.Command;
import chapter08_커맨드패턴.exercise.ex02.command.MuteCommand;
import chapter08_커맨드패턴.exercise.ex02.command.PowerCommand;
import chapter08_커맨드패턴.exercise.ex02.command.TV;

public class Client2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TV tv = new TV();
		Command pc = new PowerCommand(tv);
		Command mc = new MuteCommand(tv);
		TwoButtonController rc = new TwoButtonController();
		
		rc.setCommand(mc, pc);
		rc.button1Pressed();	// 
		
		rc.button2Preesed();	// power on
		rc.button1Pressed();	// mute on
		rc.button1Pressed();	// mute off
		rc.button2Preesed();	// power off
		rc.button1Pressed();	// 
		
	}

}
