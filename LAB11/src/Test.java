public class Test {

	public static void main(String[] args) {
		try {
			Octagon obj1 = new Octagon(5);
			Octagon obj2 = (Octagon) obj1.clone();
			System.out.println(obj1);
			int res = obj1.compareTo(obj2);
			if (res == 0) {
				System.out.println("They are equal");
			} else {
				System.out.println("They are not equal");
			}
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
}