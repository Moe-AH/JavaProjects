import java.util.*;

public class MyPoint {

	private double x;
	private double y;

	public MyPoint() {
		this.x = 0;
		this.y = 0;
	}

	public MyPoint(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double distance(MyPoint point) {
		double a = Math.pow((point.getX() - this.x), 2);
		double b = Math.pow((point.getY() - this.y), 2);
		double distance = Math.sqrt(a + b);
		return distance;
	}

	public double distance(double x, double y) {
		double a = Math.pow((x - this.x), 2);
		double b = Math.pow((y - this.y), 2);
		double distance = Math.sqrt(a + b);
		return distance;

	}

	public static double distance(MyPoint p1, MyPoint p2) {
		double a = Math.pow(p2.getX() - p1.getX(), 2);
		double b = Math.pow(p2.getY() - p1.getY(), 2);
		double distance = Math.sqrt(a + b);
		return distance;
	}
}