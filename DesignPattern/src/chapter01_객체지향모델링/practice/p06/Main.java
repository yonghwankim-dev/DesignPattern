package chapter01_��ü����𵨸�.practice.p06;

public class Main {

	public static void main(String[] args) {
		Student std1 = new Student("ȫ�浿");
		Student std2 = new Student("�迵��");
		Student std3 = new Student("��ö��");
		
		Course os = new Course("operating system");
		Course ds = new Course("data struct");
		Course java = new Course("java");
		Course c = new Course("c");
		
		std1.registerCourse(os);
		std1.registerCourse(ds);
		std1.registerCourse(java);
		
		std2.registerCourse(os);
		std2.registerCourse(ds);
		std2.registerCourse(c);
		
		std3.registerCourse(os);
		std3.registerCourse(java);
		std3.registerCourse(c);
		
		System.out.println(std1);
		System.out.println(std1.getCources());
		
		System.out.println(std2);
		System.out.println(std2.getCources());
		
		System.out.println(std3);
		System.out.println(std3.getCources());

	}

}
