package org.jfree.date;

import java.text.DateFormatSymbols;

public class DateUtil {
    public static final DateFormatSymbols dateFormatSymbols = new DateFormatSymbols();

    public static String[] getMonthNames() {
        return dateFormatSymbols.getMonths();
    }

    public static boolean isLeapYear(final int year) {
        boolean fourth = (year % 4) == 0;
        boolean hundredth = (year % 100) == 0;
        boolean fourHundredth = (year % 400) == 0;
        return fourth && (!hundredth || fourHundredth);
    }

    /**
     * Returns the number of the last day of the month, taking into account
     * leap years.
     *
     * @param month the month.
     * @param year  the year (in the range 1900 to 9999).
     *
     * @return the number of the last day of the month.
     */
    public static int lastDayOfMonth(final Month month, final int year) {
        if (month == Month.FEBRUARY && isLeapYear(year))
            return month.lastDay() + 1;
        else
            return month.lastDay();
    }
}
