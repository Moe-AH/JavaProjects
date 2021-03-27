import java.util.*;

public class Test {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("enter the value of the 1st side: ");
		double side1 = kb.nextDouble();
		System.out.println("enter the value of the 2nd side: ");
		double side2 = kb.nextDouble();
		System.out.println("enter the value of the 3rd side: ");
		double side3 = kb.nextDouble();
		System.out.println("enter the color: ");
		String color = kb.next();
		System.out.println("is it filled?: ");
		boolean filled = kb.nextBoolean();
		GeometricObject Triangle1 = new Triangle(color, filled, side1, side2, side3);
		System.out.println(Triangle1);
		kb.close();
	}

}
