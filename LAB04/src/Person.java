
public class Person {
	private String name;
	private String address;
	private String email;
	private int phoneNumber;

	public Person(String name, String address, String email, int phoneNumber) {
		this.name = name;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}


	public String getAddress() {
		return address;

	}



	public String getEmail() {
		return email;
	}



	public int getPhoneNumber() {
		return phoneNumber;
	}



	public String toString() {
		{
			return "Name: " + name + " address: " + address + " email: " + email + " Phone number: " + phoneNumber;
		}
	}
}
