package org.jfree.date;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class SpreadsheetDateFactory implements DayDateFactory {
    public DayDate makeDate(int ordinal) {
        return new SpreadsheetDate(ordinal);
    }

    public DayDate makeDate(int day, Month month, int year) {
        return new SpreadsheetDate(day, month, year);
    }

    public DayDate makeDate(int day, int month, int year) {
        return new SpreadsheetDate(day, month, year);
    }

    public DayDate makeDate(Date date) {
        final GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return new SpreadsheetDate(
                calendar.get(Calendar.DATE),
                Month.fromInt(calendar.get(Calendar.MONTH) + 1),
                calendar.get(Calendar.YEAR)
        );
    }

    public int getMinumumYear() {
        return SpreadsheetDate.MINIMUM_YEAR_SUPPORTED;
    }

    public int getMaximumYear() {
        return SpreadsheetDate.MAXIMUM_YEAR_SUPPORTED;
    }
}
