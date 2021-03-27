package Q2;

import java.util.ArrayList;
public class AddingToArrayList {

	public static void main(String[] args) {
		ArrayList<Integer> List1 = new ArrayList<Integer>();
		ArrayList<Integer> List2 = new ArrayList<Integer>();
		List1.add(2); List1.add(3); List1.add(1); List1.add(5);
		List2.add(3); List2.add(4); List2.add(6);
		for(int i = 0; i < List2.size(); i++) {
			if (!List1.contains(List2.get(i))) {
				List1.add(List2.get(i));
			}
		}
		System.out.println(List1);
	}

}
