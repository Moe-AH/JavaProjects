import java.util.*;

public class Lab07 {
	public static void main(String[] args) {

		
		boolean bool = false;

		Scanner kb = new Scanner(System.in);
		String[] months = { "January", "February", "March", 
				"April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		int[] dom = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		do {
			try {
				System.out.println("Enter the month's number: ");
				int num = kb.nextInt();
				System.out.println(months[num - 1]);
				System.out.println(dom[num - 1]);
				bool = false;
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Wrong number");
				kb.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("The input was not an integer");
				kb.nextLine();
			}
		} while (bool);
		kb.close();

	}
}