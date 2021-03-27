
public class MonthlyEmployee extends Staff {

	public MonthlyEmployee(String name, String phoneNumber, double pay) {
		super(name, phoneNumber, pay);
	}

	public String toString() {
		return super.toString() + "Staff type: Employee " +
				"\nPay: " + getPay() + " SR" + "\n";
	}
}
