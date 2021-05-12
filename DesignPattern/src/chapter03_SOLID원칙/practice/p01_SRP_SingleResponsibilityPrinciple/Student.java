package chapter03_SOLID원칙.practice.p01_SRP_SingleResponsibilityPrinciple;

// 학생 클래스는 현재 너무나 많은 책임을 가지고 있다.
public class Student {
	
	// 학생 클래스가 잘 할 수 있는것
	public void getCourses() {
		
	}
	// 학생 클래스가 잘 할 수 있는것
	public void addCourse(Course c) {
		
	}
	// 다른 클래스가 잘 할 수 있는 것
	public void save() {
		
	}
	// 다른 클래스가 잘 할 수 있는 것
	public Student load() {
		return null;
	}
	// 다른 클래스가 잘 할 수 있는 것
	public void printOnReportCard() {
		
	}
	// 다른 클래스가 잘 할 수 있는 것
	public void printOnAttendanceBook() {
		
	}
}

// 개선방안
// 1. 현재 Student 클래스는 너무나 많은 작업을 수행해야 한다.
// 2. 현재 Student 클래스에 할당된 책임 중에서 가장 잘할 수 있는 것은 수강과목을 추가하고 조회하는 일이다.
// 3. 데이터베이스에 학생 정보를 저장하고 DB로부터 읽는 일이나 성적표와 출석부에 출력하는 일은 Student 클래스가 아닌
// 다른 클래스가 더 잘할 수 있는 여지가 많다.
// 4. 따라서 Student 클래스에는 수강 과목을 추가하고 조회하는 책임만 수행하도록 하는 것이 SRP(Single Responsibility Principle)
// 을 따르는 설계이다.