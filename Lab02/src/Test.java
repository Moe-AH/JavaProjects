public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyPoint point1 = new MyPoint();
		MyPoint point2 = new MyPoint(10, 30.5);
		double distance = point1.distance(point2);
		System.out.println(distance);
	}

}
