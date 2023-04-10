package wacky.steve.Utils;

import java.util.concurrent.TimeUnit;

public class TimeUtils {

    public  static String formatTime(Long millis) {
        long days = TimeUnit.MILLISECONDS.toDays(millis);
        millis -= TimeUnit.DAYS.toMillis(days);
        long hours = TimeUnit.MILLISECONDS.toHours(millis);
        millis -= TimeUnit.HOURS.toMillis(hours);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
        millis -= TimeUnit.MINUTES.toMillis(minutes);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis);

        return String.format("%d Days %d Hrs %d Mins %d Secs", days, hours, minutes, seconds);
    }

    public static  Long toSeconds(Long millis) {
        long seconds = System.currentTimeMillis() - millis;
        return seconds/1000;
    }
}
