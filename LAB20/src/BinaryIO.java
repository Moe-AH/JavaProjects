import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
public class BinaryIO {

	public static void main(String[] args) {
		try {
			int num = 0;
			File file1 = new File("Lab20.dat");
			File file2 = new File("Lab20.txt");
			DataOutputStream ds = new DataOutputStream(new FileOutputStream(file1));
			BufferedWriter bf = new BufferedWriter(new FileWriter(file2));
			for (int i = 0; i < 1000000; i++) {
				num = (int) (Math.random()*100);
				ds.write(num);
				bf.write(num);
			}
			System.out.println("The .dat file's size: " + file1.length() + "\nThe .txt file's size: " + file2.length());
			ds.flush();
			ds.close();
			bf.flush();
			bf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
