public class Queue {
	private int[] elements;
	private int size;
	public static int DefCap = 8;

	public Queue() {
		elements = new int[DefCap];
	}

	public void enqueue(int v) {
		if (size >= elements.length) {
			int[] a = new int[elements.length * 2];
			System.arraycopy(elements, 0, a, 0, elements.length);
			elements = a;
		}
		elements[size++] = v;
	}

	public int dequeue() {
		int value = elements[0];
		for (int i = 0; i < elements.length - 1; i++) {
			elements[i] = elements[i + 1];
		}
		return value;
	}

	public boolean empty() {
		return size == 0;
	}

	public int getSize() {
		return size;
	}

}
