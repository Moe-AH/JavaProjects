
public class Staff {
	private String name;
	private String phoneNumber;
	private double pay;
	public Staff(String name, String phoneNumber, double pay) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.pay = pay;
	}

	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public double getPay() {
		return pay;
	}

	public String toString() {
		return getName() + "\nPhone Number: "
				+ getPhoneNumber() + "\n";
	}
}
