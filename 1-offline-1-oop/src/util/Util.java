package util;

import java.util.Date;

public class Util {
    // difference between two date in days
    // d2 > d1
    public static int diffInDays(Date d1, Date d2) {
        long diff = d2.getTime() - d1.getTime(); // difference in mili
        return (int) (diff / (1000 * 60 * 60 * 24));
    }

    // double to comma separated money string
    public static String toMoneyString(double amount) {
        if(amount - (int)amount == 0)
            return String.format("%,d$", (int)amount);
        else
            return String.format("%,.2f$", amount);
    }
}
