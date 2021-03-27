package PracticeTest4;

import java.util.Scanner;

public class Testing {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int num = kb.nextInt();
		System.out.println(fac(num));

	}

	public static int fac(int num) {
		if(num > 1) {
			return num * fac(num - 1);
		}
		return num;
	}
}
