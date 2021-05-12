package chapter03_SOLID원칙.exercise.ex07.after;


public class Employee {
	private String id;			// 아이디
	private String name;		// 이름
	private int workHours;		// 정상 작업시간
	private int overTimeHours;	// 잔업시간

	private PayManager payManager;
	
	
	// 생성자
	public Employee(String id, String name, int workHours, int overTimeHours) {
		this.id = id;
		this.name = name;
		this.workHours = workHours;
		this.overTimeHours = overTimeHours;
	}

	// 임금계산
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