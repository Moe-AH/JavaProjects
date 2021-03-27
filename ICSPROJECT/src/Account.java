
public class Account {

	private int accountId;
	private String name;
	private double balance;

	public Account(int accountId) {
		this.accountId = accountId;
	}

	public Account(int accountId, String name, double balance) {
		this.accountId = accountId;
		this.name = name;
		this.balance = balance;
	}

	public int getAccountId() {
		return accountId;
	}

	public String getName() {
		return name;
	}

	public double getBalance() {
		return balance;
	}

	public void deposit(double amount) {
		balance = balance + amount;
	}

	public void withdraw(double amount) {
		balance = balance - amount;
	}

	public void transfer(double amount, Account destinationAcc) {
		if (amount > 0 && balance > amount) {
			withdraw(amount);
			destinationAcc.deposit(amount);
		} else if (amount > balance) {
			System.out.println("\nInsufficient balance. Balance available is only \" + balance + \" SAR");
		} else {
			System.out.println("Invalid transfer amount");
		}
	}

	public String print() {
		return "\nAccountID : " + this.accountId + "      Account Owner : " + this.name
				+ "              Account Balance: " + this.balance + " SAR                ";
	}

	public String toString() {
		return this.accountId + "," + this.name + "," + this.balance;
	}

	public boolean equals(Account account) {
		return this.getAccountId() == account.getAccountId();
	}
}
