package PracticeTest4;

import java.util.*;

public class StringReverse {
//practice class to learn more about recursive methods
	static String reverseString = "";

	public static void main(String[] args) {
		String str = "";
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter a string: ");
		str = kb.nextLine();
		kb.close();
		System.out.println(reverse(str));
	}

	public static String reverse(String str) {
		reverseString = reverseString + str.charAt(str.length() - 1);
		if (str.length() - 1 != 0) {
			reverse(str.substring(0, str.length() - 1));
			return reverseString;
		}
		return "";
	}
}
