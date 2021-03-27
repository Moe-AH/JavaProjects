import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		try {
			ArrayList<Students> list = new ArrayList<Students>();
			Students std1 = new Students("Mohammed", 12345);
			Students std2 = new Students("Ahmed", 54321);
			list.add(std1);
			list.add(std2);
			ObjectOutputStream ds = new ObjectOutputStream(new FileOutputStream("Students.dat"));
			ds.writeObject(list);
			ds.close();
			ObjectInputStream input = new ObjectInputStream(new FileInputStream("Students.dat"));
			ArrayList readlist = (ArrayList) input.readObject();
			input.close();
			for (int i = 0; i < readlist.size(); i++) {
				System.out.println(readlist.get(i).toString());
			}
			System.out.println(readlist.get(0).toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
