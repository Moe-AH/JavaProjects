package PracticeTest4;

public class Handshakes {
//number of possible handshakes with "n" people using recursion
	public static void main(String[] args) {
		int n = 5;
		System.out.println(handshake(n));
	}

	public static int handshake(int n) {
		if (n >= 2)
			return (n - 1) + handshake(n - 1);
		else
			return 0;

	}
}
