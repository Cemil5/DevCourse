package hackerRank;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

public class CalendarTest {
    public static void main(String[] args) {
        System.out.println(findDay(8, 14, 2017));
    }

    public static String findDay(int month, int day, int year) {
        LocalDate dt = LocalDate.of(year,month,day);
        return dt.getDayOfWeek().name();
        /*
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        Date md              = new Date(day+"/"+month+"/"+year);
        sdf.applyPattern("EEEE");
        System.out.println(sdf.format(md).toUpperCase());

         */
    }
}
