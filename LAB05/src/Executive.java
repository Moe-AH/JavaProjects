
public class Executive extends Staff {
	private double bonus = 5000;

	public Executive(String name, String phoneNumber, double pay) {
		super(name, phoneNumber, pay);

	}
	public double getPay() {
		return (super.getPay() + bonus);
	}

	public String toString() {
		return super.toString() + "Staff type: Executive" + 
				"\nPay: " + (getPay()) + " SR" + "\n";
	}
}
