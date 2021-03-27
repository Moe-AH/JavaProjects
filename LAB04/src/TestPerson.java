
public class TestPerson {
	public static void main(String[] args) {
		Person p = new Person("Person name", "person address", "person mail", 055555 );
		Student stu = new Student("Stu name", "Stu address", "Stu email", 051111, "Stu stat");
		Employee emp = new Employee("Emp name", "emp address", "emp email", 05222, "emp office", 5000);
		FacultyMember FM = new FacultyMember("FM name", "FM address", "FM email", 053333, "FM title", "FM O.H", "FM Rank");
		System.out.println(p);
		System.out.println(stu);
		System.out.println(emp);
		System.out.println(FM);
		
	}
}
