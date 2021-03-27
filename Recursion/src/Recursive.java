
public class Recursive {
//this class is to demonstrate a simple cursive method
	public static void main(String args[]) {
		int arr[] = { 1, 2, -3, 4, 5, 16, -2 };
		int length = arr.length;
		System.out.println("The Maximum value is: " + maxValue(arr, length));
	}

	public static int maxValue(int arr[], int length) {
		if (length == 1) {
			return arr[0];
		}
		return Math.max(arr[length - 1], maxValue(arr, length - 1));
	}

}