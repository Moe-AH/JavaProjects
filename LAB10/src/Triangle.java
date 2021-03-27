
public class Triangle extends GeometricObject {
	private double side1;
	private double side2;
	private double side3;
	
	public Triangle(String color, boolean filled, double side1, double side2, double side3) {
		super(color, filled);
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}


	public double getPerimeter() {
		return side1 + side2 + side3;
	}

	public double getArea() {
		double s = (side1 + side2 + side3) / 2;
		return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
	}


	public void scale(double factor) {
		side1 *= factor;
		side2 *= factor;
		side3 *= factor;
	}

	public String toString() {
		return super.toString();
	}

}
