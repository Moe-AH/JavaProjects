import java.util.*;

public class Test {
	public static void main(String[] args) {
		String name;
		int temp;
		int num;
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter the number of cities: ");
		num = kb.nextInt();
		City[] arr = new City[num];
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Enter the city's name and its temperature : ");
			name = kb.next();
			temp = kb.nextInt();
			arr[i] = new City(name, temp);
		}
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		kb.close();
	}

}
