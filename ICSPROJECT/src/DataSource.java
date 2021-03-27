
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class DataSource {
	public static AccountList getAccountList() throws IOException {

		File file = new File("C:/ICS102workspace/ICSPROJECT/bin/Data/accounts.txt");
		AccountList accountList;
		try {
			FileInputStream fis = new FileInputStream(file);

			byte[] byteArray = new byte[(int) file.length()];
			fis.read(byteArray);
			String data = new String(byteArray);
			String[] stringArray = data.split("\n");

			accountList = new AccountList(stringArray.length);

			for (int i = 0; i < stringArray.length; i++) {
				String[] account = stringArray[i].split(",");
				accountList.add(new Account(Integer.parseInt(account[0]), account[1], Double.parseDouble(account[2])));
			}
		} catch (NumberFormatException e) {
			System.out.print("Unable to read data from file");
			accountList = new AccountList(0);
		}
		return accountList;
	}

	public static void updateDataSource(Account[] accountList) throws IOException {
		BufferedWriter outputWriter = null;
		outputWriter = new BufferedWriter(
				new FileWriter("C:/ICS102workspace/ICSPROJECT/bin/Data/accounts.txt"));

		for (int i = 0; i < accountList.length; i++) {
			outputWriter.write(accountList[i].toString());
			outputWriter.newLine();
		}
		outputWriter.flush();
		outputWriter.close();
	}
}
