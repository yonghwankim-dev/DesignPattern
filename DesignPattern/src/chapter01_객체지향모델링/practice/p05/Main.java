package chapter01_��ü����𵨸�.practice.p05;

public class Main {

	public static void main(String[] args) {
		
		// student ��ü ����
		Student s = new Student("ȫ�浿");
		
		// Course ��ü ����
		Course java = new Course("java");
		Course ds = new Course("Data Struct");
		Course network = new Course("network");
		
		s.registerCourse(java);
		s.registerCourse(ds);
		s.registerCourse(network);

		System.out.println(s);
		
		// �л� ��ü�� ������ ����Ѵ�.
		s.dropCourse(java);
		
		System.out.println(s);
	}

}
