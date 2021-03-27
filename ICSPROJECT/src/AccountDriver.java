
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AccountDriver {
	private static AccountList accountList;
	private static BufferedReader consoleReader;

	public static void main(String[] args) throws IOException {
		AccountList initialList = DataSource.getAccountList();
		init(initialList);

		try {

			showMenu();

			goToNextStep();
		} catch (IOException ex) {
			System.out.println("Error occurred while reading console input");
		}
	}

	private static void showMenu() throws IOException {
		System.out.print("\n" + "1. Display Account Info for all Accounts "
				+ "\n2. Display Account Info for a particular Account " + "\n3. Withdraw " + "\n4. Deposit"
				+ "\n5. Transfer" + "\n6. Add New Account" + "\n7. Delete Account" + "\n8. Exit"
				+ "\n\nPlease select your choice : ");
		String s = consoleReader.readLine();

		try {
			int input = Integer.parseInt(s);
			showResult(input);
		} catch (Exception ex) {
			System.out.println("Incorrect input");
		}
	}

	private static void showResult(int input) throws IOException {
		switch (input) {
		case 1:
			displayAllAccountInfo();
			goToNextStep();
			break;
		case 2:
			displayAccountInfo();
			goToNextStep();
			break;
		case 3:
			withdrawMoneyFromAccount();
			goToNextStep();
			break;
		case 4:
			depositMoneyToAccount();
			DataSource.updateDataSource(accountList.getAccountsArray());
			goToNextStep();
			break;
		case 5:
			transferMoneyToAcc();
			DataSource.updateDataSource(accountList.getAccountsArray());
			goToNextStep();
			break;
		case 6:
			addNewAccount();
			DataSource.updateDataSource(accountList.getAccountsArray());
			goToNextStep();
			break;
		case 7:
			deleteAccount();
			DataSource.updateDataSource(accountList.getAccountsArray());
			goToNextStep();
			break;
		case 8:
			System.exit(0);
			break;
		default:
			System.out.println("\nIncorrect input");
		}
	}

	private static void goToNextStep() throws IOException {
		System.out.print("\nPress Enter key to continue . . .");
		String input = consoleReader.readLine();

		while (" ".equals(input)) {
			System.out.print("\nPress Enter key to continue . . .");
			input = consoleReader.readLine();
		}

		showMenu();
		goToNextStep();
	}

	private static void displayAllAccountInfo() {
		accountList.print();
	}

	private static void displayAccountInfo() throws IOException {
		System.out.print("\nEnter accountID: ");

		String input = consoleReader.readLine();
		try {
			Account account = accountList.get(Integer.parseInt(input));
			if (account == null) {
				System.out.println("\nIncorrect account number");
			}

			System.out.println(account.print());
		} catch (NumberFormatException ex) {
			System.out.println("\nIncorrect account number");
		}
	}

	private static void withdrawMoneyFromAccount() throws IOException {
		System.out.print("\nEnter accountID: ");
		String accId = consoleReader.readLine();

		System.out.print("Please enter withdraw amount (SAR) : ");
		String withdraw = consoleReader.readLine();

		try {
			Account account = accountList.get(Integer.parseInt(accId));
			if (account == null) {
				System.out.println("\nIncorrect account number");

			} else {

				double amount = getValidatedAmount(withdraw);

				if (amount > 0 && amount < account.getBalance()) {
					System.out.println("\nBalance before withdrawal : " + account.getBalance() + " Saudi Riyals");
					System.out.println("Amount withdrawn from Account: " + amount + " Saudi Riyals");
					account.withdraw(amount);
					System.out.println("New Balance: " + account.getBalance() + " Saudi Riyals");

				} else if (amount > account.getBalance()) {
					System.out.println(
							"\nInsufficient balance. Balance available is only " + account.getBalance() + " SAR");

				} else {
					System.out.println("Invalid withdraw amount");

				}

			}
		} catch (NumberFormatException ex) {
			System.out.println("\nIncorrect account number");
		}
	}

	private static void depositMoneyToAccount() throws IOException {
		System.out.print("\nEnter accountID: ");
		String accId = consoleReader.readLine();

		System.out.print("Please enter deposit amount (SAR) : ");
		String deposit = consoleReader.readLine();

		try {
			Account account = accountList.get(Integer.parseInt(accId));
			if (account == null) {
				System.out.println("\nIncorrect account number");

			} else {
				double amount = getValidatedAmount(deposit);
				if (amount > 0) {
					System.out.println("\nBalance before deposit : " + account.getBalance() + " Saudi Riyals");
					System.out.println("Amount deposited from Account: " + amount + " Saudi Riyals");
					account.deposit(amount);
					System.out.println("New Balance: " + account.getBalance() + " Saudi Riyals");

				} else {
					System.out.println("Invalid deposit amount");

				}
			}
		} catch (NumberFormatException ex) {
			System.out.println("\nIncorrect account number");
		}
	}

	private static void transferMoneyToAcc() throws IOException {
		System.out.print("\nPlease enter source accountID:  ");
		String source = consoleReader.readLine();

		System.out.print("Please enter destination accounID: ");
		String destination = consoleReader.readLine();

		System.out.print("Please enter transfer  amount (SAR): ");
		String transferAmt = consoleReader.readLine();

		try {
			Account sourceAccount = accountList.get(Integer.parseInt(source));
			if (sourceAccount != null) {
				try {
					Account destinationAccount = accountList.get(Integer.parseInt(destination));

					if (destinationAccount != null) {
						double amount = getValidatedAmount(transferAmt);

						if (amount > 0 && sourceAccount.getBalance() > amount) {
							System.out.println("\nSource balance before transfer : " + sourceAccount.getBalance()
									+ " Saudi Riyals");
							System.out.println("Amount transferred to account " + destinationAccount.getAccountId()
									+ ": " + amount + " Saudi Riyals");
							sourceAccount.transfer(amount, destinationAccount);
							System.out.println("New source balance: : " + sourceAccount.getBalance() + " Saudi Riyals");
						} else if (amount > sourceAccount.getBalance()) {
							System.out
									.println("\nInsufficient balance. Balance available is only \" + balance + \" SAR");
						} else {
							System.out.println("Invalid transfer amount");
						}
					} else {
						System.out.println("\nIncorrect destination account number");
					}

				} catch (NumberFormatException ex) {
					System.out.println("\nIncorrect destination account number");
				}
			} else {
				System.out.println("\nIncorrect source account number");
			}
		} catch (NumberFormatException ex) {
			System.out.println("\nIncorrect source account number");
		}
	}

	private static void addNewAccount() throws IOException {
		System.out.print("\nPlease enter accountID:  ");
		String accountId = consoleReader.readLine();

		try {
			int accId = Integer.parseInt(accountId);
			Account account = accountList.get(accId);
			if (account != null) {
				System.out.println("\nAccount already Exist");
				System.out.println(account.print());
			} else {
				System.out.print("Please enter account holder name:  ");
				String name = consoleReader.readLine();

				System.out.print("Please enter account balance:  ");
				String balance = consoleReader.readLine();

				try {
					Account newAcc = new Account(accId, name, Double.parseDouble(balance));
					accountList.add(newAcc);
					System.out.println("\nSuccessfully added the account");
					System.out.println(newAcc.print());
				} catch (NumberFormatException ex) {
					System.out.println("\nIncorrect Balance");
				}
			}

		} catch (NumberFormatException ex) {
			System.out.println("\nIncorrect account ID format");
		}
	}

	private static void deleteAccount() throws IOException {
		System.out.print("\nPlease enter accountID:  ");
		String accountId = consoleReader.readLine();

		try {
			int accId = Integer.parseInt(accountId);
			Account account = accountList.get(accId);

			if (account != null) {
				accountList.remove(accId);
				System.out.print("\nSuccessfully removed the account");
				System.out.print(account.print() + "\n");
			}
		} catch (NumberFormatException ex) {
			System.out.println("\nIncorrect account ID format");
		}
	}

	private static double getValidatedAmount(String input) {
		try {
			return Double.parseDouble(input);
		} catch (NumberFormatException ex) {
			return -1;
		}
	}

	private static void init(AccountList newAccountList) {
		consoleReader = new BufferedReader(new InputStreamReader(System.in));

		accountList = newAccountList;
	}
}
