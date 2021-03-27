
public class City implements Comparable<City> {
	private String cityName;
	private int temperature;

	public City() {
		this.cityName = "";
		this.temperature = 0;
	}

	public City(String cityName, int temperature) {
		this.cityName = cityName;
		this.temperature = temperature;
	}

	public String getCityName() {
		return this.cityName;
	}

	public int getTemperature() {
		return this.temperature;
	}

	public int compareTo(City c) {
		return temperature - c.temperature;	
/*		if (temperature > c.temperature) {
			return 1;
		} else if (temperature == c.temperature) {
			return 0;
		} else {
			return -1;
		}
*/
	}

	public String toString() {
		return getCityName() + ", " + getTemperature();
	}
}
