import java.util.ArrayList;

public class Queue<T> {

	private ArrayList<T> queue;

	public Queue() {
		queue = new ArrayList<>();
	}

	public void add(T item) {
		queue.add(item);
	}

	public T remove() {
		if (queue.isEmpty()) {
			return null;
		} else {
			T temp = queue.get(0);
			queue.remove(0);
			return temp;
		}

	}

}
