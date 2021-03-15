import java.time.LocalDate;
import java.util.Calendar;

public class DateFormat {

	// Sets up proper todaysDate format to be used in URL.
	public static String todaysDate() {
		String todaysMonth;
		String dayOfMonth;

		LocalDate ld = LocalDate.now();
		int year = getYear(ld);
		int month = getMonth(ld);
		int day = getDayOfMonth(ld);

		// Format must be have leading zero if < 10.
		todaysMonth = setIntToString(month);
		dayOfMonth = setIntToString(day);

		String date = year + "/" + todaysMonth + "/" + dayOfMonth;

		return date;
	}

	// Sets up proper lastWeeksDate format to be used in URL.
	public static String lastWeeksDate() {
		String lastWeeksMonth;
		String lastWeeksDayOfMonth;

		LocalDate ld = LocalDate.now();
		int day = getDayOfMonth(ld) - 7;
		int month = getMonth(ld);
		int year = getYear(ld);

		if (day < 1) {
			month--;
			if (month < 1) {
				month = 12;
			}
			day += Calendar.getInstance().getActualMaximum(month - 1);
		}

		// Format must be have leading zero if < 10.
		lastWeeksMonth = setIntToString(month);
		lastWeeksDayOfMonth = setIntToString(day);

		String date = year + "/" + lastWeeksMonth + "/" + lastWeeksDayOfMonth;

		return date;
	}

	private static int getMonth(LocalDate ld) {
		return ld.getMonthValue();
	}

	private static int getYear(LocalDate ld) {
		return ld.getYear();
	}

	private static int getDayOfMonth(LocalDate ld) {
		return ld.getDayOfMonth();
	}

	private static String setIntToString(int num) {
		String s;
		if (num < 10) {
			s = "0" + num;
		} else {
			s = Integer.toString(num);
		}

		return s;
	}
}
