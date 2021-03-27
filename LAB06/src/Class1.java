import java.util.*;
import java.io.*;

public class Class1 {
	public static void main(String[] args) {
		ArrayList<String> IDs = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("IDs.txt"));
			String ID;
			while ((ID = br.readLine()) != null) {
				if (!IDs.contains(ID)) {
					IDs.add(ID);
				}
			}
			br.close();
			BufferedWriter bw = new BufferedWriter(new FileWriter("IDsWithoutDuplicates.txt"));
			for (int i = 0; i < IDs.size(); i++) {
				bw.write(IDs.get(i));
				bw.write("\n");
			}
			bw.close();
		} catch (Exception E) {
			System.err.println("Error Occured");
		}
	}
}
