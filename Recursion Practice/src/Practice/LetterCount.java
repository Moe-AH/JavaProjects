package PracticeTest4;

import java.util.Scanner;

public class LetterCount {
//counting the letters in a string using a recursive method
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter a string: ");
		String str = kb.nextLine();
		System.out.println("Choose a letter: ");
		char c = kb.next().charAt(0);
		System.out.println(find(str, c, 0));
	}

	public static int find(String str, char c, int count) {
		if (c == str.charAt(str.length() - 1)) {
			count++;
		}
		if (str.length()-1 != 0) {
			 count = find(str.substring(0, str.length() - 1), c, count);
		}
		return count;
	}
}

