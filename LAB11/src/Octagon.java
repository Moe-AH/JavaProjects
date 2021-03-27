
public class Octagon extends GeometricObject 
implements Comparable<Octagon>, Cloneable {
	private double side;

	public Octagon() {
		side = 0;
	}

	public Octagon(double side) {
		this.side = side;
	}

	public Object clone() throws
	CloneNotSupportedException {
		return super.clone();
	}

	public double area() {
		return ((2 + 4 / (Math.sqrt(2))) * side * side);
	}

	public double perameter() {
		return 8 * side;
	}

	public double getSide() {
		return side;
	}
	public void setSide(double side) {
		this.side = side;
	}

	public int compareTo(Octagon octagon) {
		if (side == octagon.getSide()) {
			return 0;
		} else if (side < octagon.getSide()) {
			return -1;
		}else {
			return 1;
		}
	}

	public double getPerimeter() {

		return 0;
	}

	public double getArea() {

		return 0;
	}

}
