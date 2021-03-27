
public class Volunteer extends Staff {
	
	public Volunteer(String name, String phoneNumber, double pay) {
		super(name, phoneNumber, 0);
	}
	
	public String toString() {
		return super.toString() + "Staff type: Volunteer" + "\nPay: " + getPay() + " SR"; 
	}

}
