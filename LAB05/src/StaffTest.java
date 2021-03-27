
public class StaffTest {

	public static void main(String[] args) {
		Staff[] staffList = new Staff[4];
		staffList[0] = new Executive("Abdulrahaman", "481269", 20000);
		staffList[1] = new MonthlyEmployee("Saleh", "445566", 25000);
		staffList[2] = new HourlyEmployee("mohammed", "0555093210", 40, 1000);
		staffList[3] = new Volunteer("Bandar", "849-8374", 0);
		System.out.println(staffList[0].toString());
		System.out.println(staffList[1].toString());
		System.out.println(staffList[2].toString());
		System.out.println(staffList[3].toString());

		System.out.println("\nTotal pay: " + staffList[0].getPay() + staffList[1].getPay() + staffList[2].getPay() + staffList[3].getPay());

	}
}
