import java.io.*;
import java.util.*;

public class test {

	public static void main(String[] args) {

		try {
			File input = new File("times.txt");

			File output = new File("result.txt");

			Scanner sc = new Scanner(input);

			PrintStream ps = new PrintStream(output);

			ps.println("#" + "\t" + "24-hour" + "\t" + 
			"12-hour" + "\n" + "--------------------------------------------");

			int L = 0;

			while (sc.hasNextLine()) {

				L++;

				String t = sc.nextLine();
				String res = "";

				try {
					res = get12HourFormat(t);
				} catch (TimeException exception) {
					res = exception.getMessage();
				}

				ps.println(L + "\t" + t + "\t" + res);

			}

			sc.close();
			ps.close();
		} catch (FileNotFoundException e) {
			System.err.println("File not found");
		}

	}

	static boolean correctTime(String t) {

		t = t.trim();

		if (t.length() == 5 && t.contains(":")) {

			String tData[] = t.split(":");

			String sHrs = tData[0];
			String sMins = tData[1];

			try {
				int intHrs = Integer.parseInt(sHrs);

				if (!(intHrs >= 00) || !(intHrs < 24)) {
					return false;
				}

			} catch (Exception e) {
				return false;
			}

			try {
				int intMins = Integer.parseInt(sMins);

				if (!(intMins >= 00) || !(intMins < 60)) {
					return false;
				}

			} catch (Exception e) {
				return false;
			}

		} else {
			return false;
		}

		return true;
	}

	static String get12HourFormat(String t) throws TimeException {

		if (correctTime(t)) {

			String tData[] = t.split(":");
			int sHrs = Integer.parseInt(tData[0]);
			int sMins = Integer.parseInt(tData[1]);
			String timePeriod = "";

			if (sHrs >= 12) {
				timePeriod = "PM";
			} else {
				timePeriod = "AM";
			}

			if (sHrs == 00) {
				sHrs = 12;
			} else if (sHrs > 12) {
				sHrs -= 12;
			}

			return String.format("%02d:%02d %s", sHrs, sMins, timePeriod);

		} else {
			throw new TimeException();
		}

	}

}