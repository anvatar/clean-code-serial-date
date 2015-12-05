package org.jfree.date;

import java.text.DateFormatSymbols;
import java.util.Calendar;

public enum Day {
    MONDAY(Calendar.MONDAY),
    TUESDAY(Calendar.TUESDAY),
    WEDNESDAY(Calendar.WEDNESDAY),
    THURSDAY(Calendar.THURSDAY),
    FRIDAY(Calendar.FRIDAY),
    SATURDAY(Calendar.SATURDAY),
    SUNDAY(Calendar.SUNDAY);

    public final int index;

    private static DateFormatSymbols dateSymbols = new DateFormatSymbols();

    Day(int index) {
        this.index = index;
    }

    public static Day make(int dayIndex) {
        for (Day d : Day.values()) {
            if (d.index == dayIndex)
                return d;
        }
        throw new IllegalArgumentException("Invalid day index " + dayIndex);
    }

    public static Day stringToWeekday(String s) {
        String[] shortWeekdayNames = dateSymbols.getShortWeekdays();
        String[] weekDayNames = dateSymbols.getWeekdays();

        s = s.trim();
        for (Day day : values()) {
            if (s.equalsIgnoreCase(shortWeekdayNames[day.index]) ||
                    s.equalsIgnoreCase(weekDayNames[day.index])) {
                return day;
            }
        }
        throw new IllegalArgumentException(String.format("%s is not a valid weekday string", s));
    }
}
