public class mainClass {

	public static void main(String[] args) {
		Queue obj = new Queue();
		for (int i = 1; i <= 20; i++) {
			obj.enqueue(i);
		}
		for (int i = 1; i <= 20; i++) {
			System.out.println(obj.dequeue());
		}
	}
}
