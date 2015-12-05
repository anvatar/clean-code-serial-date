package org.jfree.date;

import java.util.*;

public class SpreadsheetDateFactory extends DayDateFactory {
    protected DayDate _makeDate(int ordinal) {
        return new SpreadsheetDate(ordinal);
    }

    protected DayDate _makeDate(int day, DayDate.Month month, int year) {
        return new SpreadsheetDate(day, month, year);
    }

    protected DayDate _makeDate(int day, int month, int year) {
        return new SpreadsheetDate(day, month, year);
    }

    protected DayDate _makeDate(Date date) {
        final GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return new SpreadsheetDate(
                calendar.get(Calendar.DATE),
                DayDate.Month.make(calendar.get(Calendar.MONTH) + 1),
                calendar.get(Calendar.YEAR)
        );
    }

    protected int _getMinumumYear() {
        return DayDate.MINIMUM_YEAR_SUPPORTED;
    }

    protected int _getMaximumYear() {
        return DayDate.MAXIMUM_YEAR_SUPPORTED;
    }
}
