import java.io.*;

public class Main {

public static void main(String args[]) {
		DataInputStream input = null;
		try {
			double total=0;
			input = new DataInputStream(new FileInputStream("Assignment3.dat"));
			total = addition(input, total);
			System.out.println(total);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static double addition(DataInputStream input, double total) throws IOException {
		if (input.available() > 0) {
			total = total + input.readDouble();
			total = addition(input, total);
		}
		return total;
	}
}
//I made my program this way to make it as much memory efficient as possible.