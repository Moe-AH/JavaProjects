import java.util.*;

public class Test {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter a: ");
		double a = kb.nextDouble();
		System.out.print("\nEnter b: ");
		double b = kb.nextDouble();
		System.out.print("\nEnter c: ");
		double c = kb.nextDouble();
		QuadraticEquation obj = new QuadraticEquation(a, b, c);
		if (obj.getDiscriminant() > 0) {
			System.out.println("\nRoot1 =" + obj.getRoot1());
			System.out.println("Root2 =" + obj.getRoot2());
		} else if (obj.getDiscriminant() == 0) {
			System.out.println("\nRoot = " + obj.getRoot1());
		} else {
			System.out.println("\nthe equation has no roots");
		}
		kb.close();
	}

}
