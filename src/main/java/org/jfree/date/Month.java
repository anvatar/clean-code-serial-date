package org.jfree.date;

import java.text.DateFormatSymbols;

public enum Month {
    JANUARY(1),
    FEBRUARY(2),
    MARCH(3),
    APRIL(4),
    MAY(5),
    JUNE(6),
    JULY(7),
    AUGUST(8),
    SEPTEMBER(9),
    OCTOBER(10),
    NOVEMBER(11),
    DECEMBER(12);

    private static DateFormatSymbols dateFormatSymbols = new DateFormatSymbols();

    Month(int index) {
        this.index = index;
    }

    public static Month make(int monthIndex) {
        for (Month m : Month.values()) {
            if (m.index == monthIndex)
                return m;
        }
        throw new IllegalArgumentException("Invalid month index " + monthIndex);
    }

    public final int index;

    public int quarter() {
        return 1 + (index - 1) / 3;
    }

    public String toString() {
        return dateFormatSymbols.getMonths()[index - 1];
    }

    public String toShortString() {
        return dateFormatSymbols.getShortMonths()[index - 1];
    }

    public static Month parse(String s) {

        final String[] shortMonthNames = dateFormatSymbols.getShortMonths();
        final String[] monthNames = dateFormatSymbols.getMonths();

        int result = -1;
        s = s.trim();

        // first try parsing the string as an integer (1-12)...
        try {
            result = Integer.parseInt(s);
        }
        catch (NumberFormatException e) {
            // suppress
        }

        // now search through the month names...
        if ((result < 1) || (result > 12)) {
            result = -1;
            for (int i = 0; i < monthNames.length; i++) {
                if (s.equalsIgnoreCase(shortMonthNames[i])) {
                    result = i + 1;
                    break;
                }
                if (s.equalsIgnoreCase(monthNames[i])) {
                    result = i + 1;
                    break;
                }
            }
        }

        return make(result);

    }
}
