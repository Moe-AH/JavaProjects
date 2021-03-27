
public class FacultyMember extends Person {
	private String title;
	private String officeHours;
	private String rank;

	public FacultyMember(String name, String address, String email, int phoneNumber, String title, String officeHours,
			String rank) {
		super(name, address, email, phoneNumber);
		this.title = title;
		this.officeHours = officeHours;
		this.rank = rank;

	}

	public String toString() {
		return super.toString() + " (" + "Title: " + title + ", Office hours: " + officeHours + ", Rank: " + rank + ")";
	}
}
