package chapter03_SOLID??Ģ.exercise.ex10.after;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class PayGUI extends JFrame implements ActionListener, DocumentListener{
	//private PayCalculator pc;
	private PayCalculationStrategy pc; // ????
	
	private JLabel workingHoursLabel = new JLabel("Working Hours = ",Label.RIGHT);
	private JLabel overTimeHoursLabel = new JLabel("Overtime Hours = ",Label.RIGHT);
	private JLabel payAmountLabel = new JLabel("Pay Amount = ", Label.RIGHT);
	
	private JTextField tfWorkingHours = new JTextField();
	private JTextField tfOverTimeHours = new JTextField();
	private JTextField tfResult = new JTextField();
	
	private JButton calcButton = new JButton("Calculator");
	private JButton resetButton = new JButton("Reset");
	private JButton end = new JButton("Stop");
	
	
	
	//public PayGUI(PayCalculator pc) throws HeadlessException {
	public PayGUI(PayCalculationStrategy pc) throws HeadlessException {
		super("Payment Calculator");
		this.pc = pc;
		this.init();
		this.start();
		this.setSize(500,250);
		this.setVisible(true);
		
	}
	

	public void setPc(PayCalculationStrategy pc) {
		this.pc = pc;
	}



	public void setWorkingHoursLabel(JLabel workingHoursLabel) {
		this.workingHoursLabel = workingHoursLabel;
	}



	public void setOverTimeHoursLabel(JLabel overTimeHoursLabel) {
		this.overTimeHoursLabel = overTimeHoursLabel;
	}



	public void setPayAmountLabel(JLabel payAmountLabel) {
		this.payAmountLabel = payAmountLabel;
	}



	public void setTfWorkingHours(JTextField tfWorkingHours) {
		this.tfWorkingHours = tfWorkingHours;
	}



	public void setTfOverTimeHours(JTextField tfOverTimeHours) {
		this.tfOverTimeHours = tfOverTimeHours;
	}



	public void setTfResult(JTextField tfResult) {
		this.tfResult = tfResult;
	}



	public void setCalcButton(JButton calcButton) {
		this.calcButton = calcButton;
	}



	public void setResetButton(JButton resetButton) {
		this.resetButton = resetButton;
	}



	public void setEnd(JButton end) {
		this.end = end;
	}



	public void init() {
		this.setLayout(new GridLayout(5,1));
		
		Panel p = new Panel(new BorderLayout());
		p.add("West",workingHoursLabel);
		p.add("Center",tfWorkingHours);
		this.add(p);
		
		Panel p1 = new Panel(new BorderLayout());
		p1.add("West",overTimeHoursLabel);
		p1.add("Center",tfOverTimeHours);
		this.add(p1);
		
		Panel p2 = new Panel(new FlowLayout(FlowLayout.CENTER));
		p2.add(calcButton);
		this.add(p2);
		
		Panel p3 = new Panel(new BorderLayout());
		p3.add("West", payAmountLabel);
		p3.add("Center",tfResult);
		this.add(p3);
		
		Panel p4 = new Panel(new FlowLayout(FlowLayout.RIGHT));
		p4.add(resetButton);
		this.add(p4);
		
		
	}
	
	public void start() {
		calcButton.addActionListener(this);
		resetButton.addActionListener(this);
		
		tfWorkingHours.getDocument().addDocumentListener(this);
		tfOverTimeHours.getDocument().addDocumentListener(this);
		
		end.addActionListener(this);
		
		calcButton.setEnabled(false);
		resetButton.setEnabled(false);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public boolean isDataEntered() {
		if(tfWorkingHours.getText().trim().length()==0 ||
				tfOverTimeHours.getText().trim().length()==0)
		{
			return false;
		}
		return true;
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		checkData();
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		checkData();
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		checkData();
	}
	
	private void checkData() {
		calcButton.setEnabled(isDataEntered());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==end) {
			System.exit(0);
		}
		
		if(e.getSource()==resetButton) {
			tfWorkingHours.setText("");
			tfOverTimeHours.setText("");
			tfWorkingHours.requestFocus();
			tfResult.setText("");
			resetButton.setEnabled(false);
			return;
		}
		
		if(e.getSource()==calcButton) {
			int x = 0;
			try {
				x = Integer.parseInt(tfWorkingHours.getText().trim());
			}catch (NumberFormatException e1) {
				tfWorkingHours.setText("");
				tfWorkingHours.requestFocus();
				return;
			}
			
			int y = 0;
			try {
				y = Integer.parseInt(tfOverTimeHours.getText().trim());
			}catch (NumberFormatException e2) {
				tfOverTimeHours.setText("");
				tfWorkingHours.requestFocus();
				return;
			}
			/*
			int payAmount = 0;
			payAmount = 10*x + 15*y;?? ?????? ???? ????*/
			int payAmount = this.pc.getPay(x,y);
			
			tfResult.setText(String.valueOf(payAmount));
			resetButton.setEnabled(true);
		}
	}
}
