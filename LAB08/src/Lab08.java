import java.util.*;
import java.io.*;

public class Lab08 {
	public static void main(String[] args)
			throws FileNotFoundException {
		FileInputStream input = new FileInputStream("in.txt");
		FileOutputStream output = new FileOutputStream("out.txt");
		Scanner scnr = new Scanner(input);
		PrintWriter prntwrtr = new PrintWriter(output);
		
		while (scnr.hasNext()) {
			prntwrtr.println(scnr.next() + " " + scnr.next());
		}
		scnr.close();
		prntwrtr.close();
	}
}