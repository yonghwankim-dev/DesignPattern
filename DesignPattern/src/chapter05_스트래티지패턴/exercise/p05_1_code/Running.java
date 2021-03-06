package chapter05_스트래티지패턴.exercise.p05_1_code;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Running  extends JFrame{
	private Field field;
	
	public Running(Field field)
	{
		super("Running");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		this.field = field;
		
		add(field, BorderLayout.CENTER);
		
		setSize(500,500);
		setVisible(true);
		
		Thread th = new Thread(field);
		th.start();
		
	}
}
