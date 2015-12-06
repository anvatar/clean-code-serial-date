package org.jfree.date;

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
        String[] shortWeekdayNames = DateUtil.dateFormatSymbols.getShortWeekdays();
        String[] weekDayNames = DateUtil.dateFormatSymbols.getWeekdays();

        s = s.trim();
        for (Day day : values()) {
            if (s.equalsIgnoreCase(shortWeekdayNames[day.index]) ||
                    s.equalsIgnoreCase(weekDayNames[day.index])) {
                return day;
            }
        }
        throw new IllegalArgumentException(String.format("%s is not a valid weekday string", s));
    }

    public String toString() {
        return DateUtil.dateFormatSymbols.getWeekdays()[index];
    }
}
