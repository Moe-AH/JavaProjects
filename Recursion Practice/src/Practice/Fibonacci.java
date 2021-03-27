package PracticeTest4;

import java.util.Scanner;

public class Fibonacci {
//Fibonacci numbers using recursion
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("How many Fibonacci numbers you want ?: ");
		int n = in.nextInt();
		in.close();
		for (int i = 1; i <= n; i++)
			System.out.println("Fibonacci #" + i + " = " + fib(i));
	}
	public static int fib(int n) {
		if (n <= 0)
			return -1;

		if (n == 1)
			return 0;
		else if (n == 2)
			return 1;
		else {
			return fib(n - 1) + fib(n - 2);
		}
	}
}
