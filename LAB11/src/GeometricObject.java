
public abstract class GeometricObject {
	private String color;
	private boolean filled;

	public GeometricObject() {

	}

	public GeometricObject(String color, boolean filled) {
		this.color = color;
		this.filled = filled;
	}

	public abstract double getPerimeter();

	public abstract double getArea();

	public String toString() {

		return "\nThe color is: " + color + "\nIs filled: " + filled + "\nThe area is: " + getArea()
				+ "\nThe parimeter is: " + getPerimeter();
	}
}
