
public class MarketTimesOpenClose {

	String[] times = new String[78];

	public MarketTimesOpenClose() {
		this.times = fillTimesArray();
	}

	private String[] fillTimesArray() {
		int hour = 9;
		int min = 30;
		for (int i = 0; i < times.length; i++) {
			if (hour < 10) {
				if (min < 10) {
					this.times[i] = "0" + hour + ":" + "0" + min;
				} else {
					this.times[i] = "0" + hour + ":" + min;
				}

			} else {
				if (min < 10) {
					this.times[i] = hour + ":" + "0" + min;
				} else {
					this.times[i] = hour + ":" + min;
				}

			}
			min += 5;
			if (min > 55) {
				hour++;
				min = 0;
			}
		}

		return times;
	}
}
