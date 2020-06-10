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
    public static String toVietnamese(double num) {
        String str = Integer.toString((int)num);

        if ((1000 <= num) && (num < 1000000)) {
            str = convert(1000, "nghìn", num);
        }

        if ((1000000 <= num) && (num < 1000000000)) {
            str = convert(1000000, "triệu", num);
        }

        if(num >= 1000000000) {
            str = convert(1000000000, "tỷ", num);
        }

        return str;
    }
    private static String convert(int donVi, String str, double num) {
        String result;
        double temp = roundedNum(num / donVi);
        int intTemp = (int) temp;
        if (((temp - intTemp) < 0.1) || (temp > 100)) {
            result = intTemp + " " + str;
        } else {
            result = temp + " " + str;
        }
        return result;
    }
    public static double roundedNum(double num) {
        int x = (int) (num * 10);
        return x / 10.0;
    }
}
