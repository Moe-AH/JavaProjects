
import java.util.Arrays;

public class AccountList {

	private Account accounts[];

	private int size;

	public AccountList(int size) {
		accounts = new Account[size];

		size = 0;
	}

	public Account get(int accountId) {
		int index = get(new Account(accountId));

		if (index != -1) {
			return accounts[index];
		}
		return null;
	}

	public void add(Account account) {
		increaseCapacity(1);
		accounts[size] = account;
		size++;
	}

	public void remove(int accountId) {
		int existingIndex = get(new Account(accountId));
		if (existingIndex == -1) {
			System.out.println("No Account found for the given account id");
		} else {
			for (int i = existingIndex; i < size - 1; i++) {
				accounts[i] = accounts[i + 1];
			}
			accounts[size - 1] = null;
			decreaseCapacity(1);
			size--;
		}
	}

	public void print() {
		System.out.println("\n AccountID    Account Owner       Account Balance (SAR)");
		for (int i = 0; i < size; i++) {
			System.out.println(accounts[i].getAccountId() + "          " + accounts[i].getName() + "             "
					+ accounts[i].getBalance());
		}
	}

	private void increaseCapacity(int minCapacity) {
		int newCapacity = size + minCapacity;

		accounts = Arrays.copyOf(accounts, newCapacity);
	}

	private void decreaseCapacity(int minCapacity) {
		int newCapacity = size - minCapacity;

		accounts = Arrays.copyOf(accounts, newCapacity);
	}

	private int get(Account account) {
		for (int j = 0; j < size; j++) {
			if (accounts[j].equals(account)) {
				return j;
			}
		}
		return -1;
	}

	public int length() {
		return accounts.length;
	}

	public Account[] getAccountsArray() {
		return accounts;
	}
}
