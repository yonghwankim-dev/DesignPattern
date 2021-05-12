package chapter03_SOLID��Ģ.exercise.ex07.after;


public class Employee {
	private String id;			// ���̵�
	private String name;		// �̸�
	private int workHours;		// ���� �۾��ð�
	private int overTimeHours;	// �ܾ��ð�

	private PayManager payManager;
	
	
	// ������
	public Employee(String id, String name, int workHours, int overTimeHours) {
		this.id = id;
		this.name = name;
		this.workHours = workHours;
		this.overTimeHours = overTimeHours;
	}

	// �ӱݰ��
	public int calculatePay()
	{
		return payManager.calculatePay(this);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWorkHours() {
		return workHours;
	}

	public void setWorkHours(int workHours) {
		this.workHours = workHours;
	}

	public int getOverTimeHours() {
		return overTimeHours;
	}

	public void setOverTimeHours(int overTimeHours) {
		this.overTimeHours = overTimeHours;
	}

	public PayManager getPayManager() {
		return payManager;
	}

	public void setPayManager(PayManager payManager) {
		this.payManager = payManager;
	}
}