package id.co.picklon.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import id.co.picklon.model.entities.DateTime;

public class TimeUtil {

    public static int getYear() {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        return calendar.get(Calendar.YEAR);
    }

    public static int getMonth() {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        return calendar.get(Calendar.MONTH);
    }

    public static int getDay() {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public static String getFormatedDate(DateTime dateTime) {
        Calendar cal = Calendar.getInstance();
        cal.set(dateTime.getYear(), dateTime.getMonth(), dateTime.getDay());
        SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);
        return format.format(cal.getTime());
    }

    public static int getHour() {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    public static int getMinutes() {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        return calendar.get(Calendar.MINUTE);
    }

    public static String getFormatedTime(DateTime dateTime) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, dateTime.getHour());
        cal.set(Calendar.MINUTE, dateTime.getMinutes());
        SimpleDateFormat format = new SimpleDateFormat("HH:mm", Locale.ENGLISH);
        return format.format(cal.getTime());
    }

    public static String getPostTime(DateTime dateTime) {
        Calendar cal = Calendar.getInstance();
        cal.set(dateTime.getYear(), dateTime.getMonth(), dateTime.getDay(), dateTime.getHour(), dateTime.getMinutes());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm", Locale.ENGLISH);
        return format.format(cal.getTime());
    }
}
