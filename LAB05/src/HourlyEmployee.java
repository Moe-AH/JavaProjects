
public class HourlyEmployee extends Staff {
	private int hours;

	public HourlyEmployee(String name, String phoneNumber, int hours, double pay) {
		super(name, phoneNumber, pay);
		this.hours = hours;
	}
	public double getPay() {
		return (hours * super.getPay());
	}
	
	public String toString() {
		return super.toString() + "Staff type: Employee" +
	"\nPay: " + getPay() + " SR" + "\n";
	}

}
