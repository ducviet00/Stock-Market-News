package main;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utils {
    public static Date goBack (Date today) {
        Calendar yesterday = Calendar.getInstance();
        yesterday.setTime(today);
        yesterday.add(Calendar.DATE, -1);
        return yesterday.getTime();
    }
    public static String date2String (Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return formatter.format(date);
    }

}
