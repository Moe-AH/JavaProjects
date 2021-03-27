
public class Student extends Person {

	private String status;
	public static final int freshman = 1;
	public static final int sophomore = 2;
	public static final int junior = 3;
	public static final int senior = 4;

	public Student(String name, String address, String email, int phoneNumber, String status) {
		super(name, address, email, phoneNumber);
		this.status = status;
	}

	public String toString() {
		return super.toString() + " (" + " Status: " + status + ")";
	}
}
