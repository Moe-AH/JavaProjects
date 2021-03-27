import java.io.File;
import java.util.Scanner;

public class FileCount {

	static File[] files = {};
	public static void main(String[] args) {
		int numFile = 0;
		System.out.print("Enter directory path: ");
		Scanner kb = new Scanner(System.in);
		String dir = kb.nextLine();
		numFile = countFiles(new File(dir));
		System.out.println("There are "+ numFile + " files");
		kb.close();
	}

	public static int countFiles(File f) {
		int num = 0;
		if (f.isDirectory()) {
			
			files = f.listFiles();
			for (int i = 0; files != null && i < files.length; i++)
				num += countFiles(files[i]);

		} else {
			num = num + 1;
			return num;
		}
		return num;
	}
}
