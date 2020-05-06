package dateapi.exam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.temporal.WeekFields;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class LocalDateExample {

	public static void main(String[] args) throws ParseException {
		// Current Date
		LocalDate today = LocalDate.now();
		System.out.println("Current Date=" + today);

		// Creating LocalDate by providing input arguments
		LocalDate firstDay_2020 = LocalDate.of(2020, Month.JANUARY, 1);
		System.out.println("Specific Date=" + firstDay_2020);

		// Try creating date by providing invalid inputs
		// LocalDate feb29_2014 = LocalDate.of(2014, Month.FEBRUARY, 29);
		// Exception in thread "main" java.time.DateTimeException:
		// Invalid date 'February 29' as '2014' is not a leap year

		// Current date in "Asia/Kolkata", you can get it from ZoneId javadoc
		LocalDate todayKolkata = LocalDate.now(ZoneId.of("Asia/Kolkata"));
		System.out.println("Current Date in IST=" + todayKolkata);

		// java.time.zone.ZoneRulesException: Unknown time-zone ID: IST
		// LocalDate todayIST = LocalDate.now(ZoneId.of("IST"));

		// Getting date from the base date i.e 01/01/1970
		LocalDate dateFromBase = LocalDate.ofEpochDay(365);
		System.out.println("365th day from base date= " + dateFromBase);

		LocalDate hundredDay2014 = LocalDate.ofYearDay(2014, 100);
		System.out.println("100th day of 2014=" + hundredDay2014);
		
		
		String dayOfWeek = String.valueOf(today.getDayOfWeek());
		System.out.println("Day of Week =" + dayOfWeek);
		
		WeekFields weekFields = WeekFields.of(Locale.getDefault()); 
		int weekNumber = today.get(weekFields.weekOfWeekBasedYear());
		System.out.println("Number of Week-Year =" + weekNumber);
		
		int weekNumberM = today.get(weekFields.weekOfMonth());
		System.out.println("Number of Week-Month =" + weekNumberM);
		
		
		System.out.println("======================================================================");
		Calendar c = Calendar.getInstance();
		System.out.println("Year: " + c.get(Calendar.YEAR));
		System.out.println("Month: " + c.get(Calendar.MONTH));
		System.out.println("Day: " + c.get(Calendar.DAY_OF_MONTH));
		System.out.println("Day of week = " + c.get(Calendar.DAY_OF_WEEK));
		System.out.println("Day of year = " + c.get(Calendar.DAY_OF_YEAR));
		System.out.println("Week in Year: " + c.get(Calendar.WEEK_OF_YEAR));
		System.out.println("Week in Month: " + c.get(Calendar.WEEK_OF_MONTH));
		System.out.println("Day of Week in Month: " + 
		            c.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		System.out.println("Hour: " + c.get(Calendar.HOUR));
		System.out.println("AM or PM: " + c.get(Calendar.AM_PM));
		System.out.println("Hour (24-hour clock): " + 
		            c.get(Calendar.HOUR_OF_DAY));
		System.out.println("Minute: " + c.get(Calendar.MINUTE));
		System.out.println("Second: " + c.get(Calendar.SECOND));
		System.out.println("======================================================================");
		
		String input = "2020-03-02";
		String format = "yyyy-MM-dd";

		SimpleDateFormat df = new SimpleDateFormat(format);
		Date date = df.parse(input);

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int week = cal.get(Calendar.WEEK_OF_MONTH);
		System.out.println("Number of Week-Month =" + week);
		
		
		LocalDate dateInstance = LocalDate.parse("2020-03-08");
		int weekNumberM1 = dateInstance.get(weekFields.weekOfMonth());
		System.out.println("Number of Week-Month =" + weekNumberM1);
	}

}
