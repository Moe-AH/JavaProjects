import java.util.*;

public class Employee extends Person {
	private String office;
	private double salary;
	private Date dateHired;

	public Employee(String name, String address, String email, int phoneNumber, String office, double salary) {
		super(name, address, email, phoneNumber);
		this.office = office;
		this.salary = salary;
		this.dateHired = new Date();
	}

	public String toString() {
		return super.toString() + " (" + " office: " + office + ", salary: " + salary + ", Date hired: " + dateHired + ")";

	}
}
