import java.util.Scanner;

public class LetterCount {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Please enter a string: ");
		String word = kb.next();
		System.out.println("Please choose a letter: ");
		char letter = kb.next().charAt(0);
		System.out.println(letter + " is found "+ count(word, letter)+ " times");
		kb.close();
	}
	public static int count(String str, char c) {
		if (str.isEmpty()) {
			return 0;
		}
		if (str.charAt(0)==c) {
			return count(str.substring(1), c) + 1;
		}
		return count(str.substring(1), c);
	}
}
