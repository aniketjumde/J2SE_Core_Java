import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.Date;
import java.time.Period;
import java.time.Duration;
import java.time.ZoneId;


public class DateTime
{
	public static void main(String[] args) {
		
		//This is Outdated version to print
		Date date= new Date();
		System.out.println(date);


		LocalDate d=LocalDate.now();
		System.out.println("Date :"+d);

		LocalTime t=LocalTime.now();
		System.out.println("Time :"+t);

		LocalDateTime dt=LocalDateTime.now();
		System.out.println("Date-Time :"+dt);


		//Month Validation
		// LocalDate l=LocalDate.of(2020,18,10);
		// System.out.println(l);

		//Date Validation
		// LocalDate l=LocalDate.of(2020,03,35);
		// System.out.println(l);

		//leap year Validation
		// LocalDate l=LocalDate.of(2023,02,29);
		// System.out.println(l);

		LocalDate l=LocalDate.of(2024,07,21);
		System.out.println(l);

		//Days Year Calculation
		//For Age Calculation

		LocalDate d1=LocalDate.of(2005,07,21);
		LocalDate d2=LocalDate.now();

		Period p=Period.between(d1,d2);
		System.out.println("YYYY-MM-DD :"+p.getYears()+"-"+p.getMonths()+"-"+p.getDays());
		System.out.println("Year :"+p.getYears());
		System.out.println("Months :"+p.getMonths());
		System.out.println("Days :"+p.getDays());

		//Time Calculation

		LocalTime beforeTime=LocalTime.of(6,0);
		LocalTime latestTime=LocalTime.now();

		Duration diff=Duration.between(beforeTime,latestTime);
		System.out.println("Hours :"+diff.toHours());
		System.out.println("Minutes :"+diff.toMinutes());
		System.out.println("Seconds :"+diff.toSeconds());


		//Displaying ZoneWise Date

		LocalDateTime a=LocalDateTime.now(ZoneId.of("America/Los_Angeles"));
		System.out.println("America/Los_Angeles :"+a);

		LocalDate b=LocalDate.now(ZoneId.of("America/Los_Angeles"));
		System.out.println("America/Los_Angeles Date :"+b);

		LocalTime c=LocalTime.now(ZoneId.of("America/Los_Angeles"));
		System.out.println("America/Los_Angeles Time :"+c);

	}
}