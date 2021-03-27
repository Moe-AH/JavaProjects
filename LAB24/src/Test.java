
public class Test {

	public static void main(String[] args) {
		Queue<String> q = new Queue<>();
		q.add("A");
		q.add("B");
		q.add("C");
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());

	}

}
