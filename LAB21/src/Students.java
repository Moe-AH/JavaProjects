import java.io.Serializable;

public class Students implements Serializable {
	private String name;
	private int ID;

	Students(String name, int ID) {
		this.name = name;
		this.ID = ID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getName() {
		return name;
	}

	public int getID() {
		return ID;
	}

	public String toString() {
		return getName() + " " + getID();
	}
}