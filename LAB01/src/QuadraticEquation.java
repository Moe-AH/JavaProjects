import java.util.*;

public class QuadraticEquation {
	private double a;
	private double b;
	private double c;

	public QuadraticEquation(double v1, double v2, double v3) {
		a = v1;
		b = v2;
		c = v3;
	}

	public double getA() {
		return a;
	}

	public double getB() {
		return b;
	}

	public double getC() {
		return c;
	}

	public double getDiscriminant() {
		double Discriminant = (b * b) - (4 * a * c);
		return Discriminant;
	}

	public double getRoot1() {
		if (getDiscriminant() < 0) {
			return 0;
		}
		double Root1 = ((-b) + Math.sqrt(getDiscriminant()) / (2 * a));
		return Root1;
	}

	public double getRoot2() {
		if (getDiscriminant() < 0) {
			return 0;
		}
		double Root2 = ((-b) - Math.sqrt(getDiscriminant()) / (2 * a));
		return Root2;
	}

}