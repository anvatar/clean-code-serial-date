package org.jfree.date.junit;

import junit.framework.TestCase;
import org.jfree.date.*;
import static org.jfree.date.DayDate.*;

import java.util.*;

public class BobsDayDateTest extends TestCase {

    public void testStringToWeekdayCode() throws Exception {

        try {
            Day.stringToWeekday("Hello");
            fail("Invalid day index string should throw exception");
        } catch (Exception ignore) {
        }

        assertEquals(Day.MONDAY, Day.stringToWeekday("Monday"));
        assertEquals(Day.MONDAY, Day.stringToWeekday("Mon"));
        assertEquals(Day.MONDAY, Day.stringToWeekday("monday"));
        assertEquals(Day.MONDAY, Day.stringToWeekday("MONDAY"));
        assertEquals(Day.MONDAY, Day.stringToWeekday("mon"));

        assertEquals(Day.TUESDAY, Day.stringToWeekday("Tuesday"));
        assertEquals(Day.TUESDAY, Day.stringToWeekday("Tue"));
        assertEquals(Day.TUESDAY, Day.stringToWeekday("tuesday"));
        assertEquals(Day.TUESDAY, Day.stringToWeekday("TUESDAY"));
        assertEquals(Day.TUESDAY, Day.stringToWeekday("tue"));
        // assertEquals(Day.TUESDAY, stringToWeekday("tues"));

        assertEquals(Day.WEDNESDAY, Day.stringToWeekday("Wednesday"));
        assertEquals(Day.WEDNESDAY, Day.stringToWeekday("Wed"));
        assertEquals(Day.WEDNESDAY, Day.stringToWeekday("wednesday"));
        assertEquals(Day.WEDNESDAY, Day.stringToWeekday("WEDNESDAY"));
        assertEquals(Day.WEDNESDAY, Day.stringToWeekday("wed"));

        assertEquals(Day.THURSDAY, Day.stringToWeekday("Thursday"));
        assertEquals(Day.THURSDAY, Day.stringToWeekday("Thu"));
        assertEquals(Day.THURSDAY, Day.stringToWeekday("thursday"));
        assertEquals(Day.THURSDAY, Day.stringToWeekday("THURSDAY"));
        assertEquals(Day.THURSDAY, Day.stringToWeekday("thu"));
        // assertEquals(Day.THURSDAY, stringToWeekday("thurs"));

        assertEquals(Day.FRIDAY, Day.stringToWeekday("Friday"));
        assertEquals(Day.FRIDAY, Day.stringToWeekday("Fri"));
        assertEquals(Day.FRIDAY, Day.stringToWeekday("friday"));
        assertEquals(Day.FRIDAY, Day.stringToWeekday("FRIDAY"));
        assertEquals(Day.FRIDAY, Day.stringToWeekday("fri"));

        assertEquals(Day.SATURDAY, Day.stringToWeekday("Saturday"));
        assertEquals(Day.SATURDAY, Day.stringToWeekday("Sat"));
        assertEquals(Day.SATURDAY, Day.stringToWeekday("saturday"));
        assertEquals(Day.SATURDAY, Day.stringToWeekday("SATURDAY"));
        assertEquals(Day.SATURDAY, Day.stringToWeekday("sat"));

        assertEquals(Day.SUNDAY, Day.stringToWeekday("Sunday"));
        assertEquals(Day.SUNDAY, Day.stringToWeekday("Sun"));
        assertEquals(Day.SUNDAY, Day.stringToWeekday("sunday"));
        assertEquals(Day.SUNDAY, Day.stringToWeekday("SUNDAY"));
        assertEquals(Day.SUNDAY, Day.stringToWeekday("sun"));
    }

    public void testWeekdayCodeToString() throws Exception {
        assertEquals("Sunday", Day.SUNDAY.toString());
        assertEquals("Monday", Day.MONDAY.toString());
        assertEquals("Tuesday", Day.TUESDAY.toString());
        assertEquals("Wednesday", Day.WEDNESDAY.toString());
        assertEquals("Thursday", Day.THURSDAY.toString());
        assertEquals("Friday", Day.FRIDAY.toString());
        assertEquals("Saturday", Day.SATURDAY.toString());
    }

    public void testMonthToQuarter() throws Exception {
        assertEquals(1, Month.JANUARY.quarter());
        assertEquals(1, Month.FEBRUARY.quarter());
        assertEquals(1, Month.MARCH.quarter());
        assertEquals(2, Month.APRIL.quarter());
        assertEquals(2, Month.MAY.quarter());
        assertEquals(2, Month.JUNE.quarter());
        assertEquals(3, Month.JULY.quarter());
        assertEquals(3, Month.AUGUST.quarter());
        assertEquals(3, Month.SEPTEMBER.quarter());
        assertEquals(4, Month.OCTOBER.quarter());
        assertEquals(4, Month.NOVEMBER.quarter());
        assertEquals(4, Month.DECEMBER.quarter());

    }

    public void testMonthToString() throws Exception {
        assertEquals("January", Month.JANUARY.toString());
        assertEquals("February", Month.FEBRUARY.toString());
        assertEquals("March", Month.MARCH.toString());
        assertEquals("April", Month.APRIL.toString());
        assertEquals("May", Month.MAY.toString());
        assertEquals("June", Month.JUNE.toString());
        assertEquals("July", Month.JULY.toString());
        assertEquals("August", Month.AUGUST.toString());
        assertEquals("September", Month.SEPTEMBER.toString());
        assertEquals("October", Month.OCTOBER.toString());
        assertEquals("November", Month.NOVEMBER.toString());
        assertEquals("December", Month.DECEMBER.toString());

        assertEquals("Jan", Month.JANUARY.toShortString());
        assertEquals("Feb", Month.FEBRUARY.toShortString());
        assertEquals("Mar", Month.MARCH.toShortString());
        assertEquals("Apr", Month.APRIL.toShortString());
        assertEquals("May", Month.MAY.toShortString());
        assertEquals("Jun", Month.JUNE.toShortString());
        assertEquals("Jul", Month.JULY.toShortString());
        assertEquals("Aug", Month.AUGUST.toShortString());
        assertEquals("Sep", Month.SEPTEMBER.toShortString());
        assertEquals("Oct", Month.OCTOBER.toShortString());
        assertEquals("Nov", Month.NOVEMBER.toShortString());
        assertEquals("Dec", Month.DECEMBER.toShortString());

    }

    public void testStringToMonth() throws Exception {
        assertEquals(Month.JANUARY, Month.parse("1"));
        assertEquals(Month.FEBRUARY, Month.parse("2"));
        assertEquals(Month.MARCH, Month.parse("3"));
        assertEquals(Month.APRIL, Month.parse("4"));
        assertEquals(Month.MAY, Month.parse("5"));
        assertEquals(Month.JUNE, Month.parse("6"));
        assertEquals(Month.JULY, Month.parse("7"));
        assertEquals(Month.AUGUST, Month.parse("8"));
        assertEquals(Month.SEPTEMBER, Month.parse("9"));
        assertEquals(Month.OCTOBER, Month.parse("10"));
        assertEquals(Month.NOVEMBER, Month.parse("11"));
        assertEquals(Month.DECEMBER, Month.parse("12"));

        try {
            Month.parse("0");
            fail("Invalid month index string should throw exception");
        } catch (IllegalArgumentException ignore) {
        }
        try {
            Month.parse("13");
            fail("Invalid month index string should throw exception");
        } catch (IllegalArgumentException ignore) {
        }

        try {
            Month.parse("Hello");
            fail("Invalid month index string should throw exception");
        } catch (IllegalArgumentException ignore) {
        }

        for (Month m : Month.values()) {
            assertEquals(m, Month.parse(m.toShortString()));
            assertEquals(m, Month.parse(m.toShortString()));
        }

         assertEquals(Month.JANUARY, Month.parse("jan"));
         assertEquals(Month.FEBRUARY, Month.parse("feb"));
         assertEquals(Month.MARCH, Month.parse("mar"));
         assertEquals(Month.APRIL, Month.parse("apr"));
         assertEquals(Month.MAY, Month.parse("may"));
         assertEquals(Month.JUNE, Month.parse("jun"));
         assertEquals(Month.JULY, Month.parse("jul"));
         assertEquals(Month.AUGUST, Month.parse("aug"));
         assertEquals(Month.SEPTEMBER, Month.parse("sep"));
         assertEquals(Month.OCTOBER, Month.parse("oct"));
         assertEquals(Month.NOVEMBER, Month.parse("nov"));
         assertEquals(Month.DECEMBER, Month.parse("dec"));

         assertEquals(Month.JANUARY, Month.parse("JAN"));
         assertEquals(Month.FEBRUARY, Month.parse("FEB"));
         assertEquals(Month.MARCH, Month.parse("MAR"));
         assertEquals(Month.APRIL, Month.parse("APR"));
         assertEquals(Month.MAY, Month.parse("MAY"));
         assertEquals(Month.JUNE, Month.parse("JUN"));
         assertEquals(Month.JULY, Month.parse("JUL"));
         assertEquals(Month.AUGUST, Month.parse("AUG"));
         assertEquals(Month.SEPTEMBER, Month.parse("SEP"));
         assertEquals(Month.OCTOBER, Month.parse("OCT"));
         assertEquals(Month.NOVEMBER, Month.parse("NOV"));
         assertEquals(Month.DECEMBER, Month.parse("DEC"));

         assertEquals(Month.JANUARY, Month.parse("january"));
         assertEquals(Month.FEBRUARY, Month.parse("february"));
         assertEquals(Month.MARCH, Month.parse("march"));
         assertEquals(Month.APRIL, Month.parse("april"));
         assertEquals(Month.MAY, Month.parse("may"));
         assertEquals(Month.JUNE, Month.parse("june"));
         assertEquals(Month.JULY, Month.parse("july"));
         assertEquals(Month.AUGUST, Month.parse("august"));
         assertEquals(Month.SEPTEMBER, Month.parse("september"));
         assertEquals(Month.OCTOBER, Month.parse("october"));
         assertEquals(Month.NOVEMBER, Month.parse("november"));
         assertEquals(Month.DECEMBER, Month.parse("december"));

         assertEquals(Month.JANUARY, Month.parse("JANUARY"));
         assertEquals(Month.FEBRUARY, Month.parse("FEBRUARY"));
         assertEquals(Month.MARCH, Month.parse("MAR"));
         assertEquals(Month.APRIL, Month.parse("APRIL"));
         assertEquals(Month.MAY, Month.parse("MAY"));
         assertEquals(Month.JUNE, Month.parse("JUNE"));
         assertEquals(Month.JULY, Month.parse("JULY"));
         assertEquals(Month.AUGUST, Month.parse("AUGUST"));
         assertEquals(Month.SEPTEMBER, Month.parse("SEPTEMBER"));
         assertEquals(Month.OCTOBER, Month.parse("OCTOBER"));
         assertEquals(Month.NOVEMBER, Month.parse("NOVEMBER"));
         assertEquals(Month.DECEMBER, Month.parse("DECEMBER"));
    }

    public void testIsLeapYear() throws Exception {
        assertFalse(isLeapYear(1900));
        assertFalse(isLeapYear(1901));
        assertFalse(isLeapYear(1902));
        assertFalse(isLeapYear(1903));
        assertTrue(isLeapYear(1904));
        assertTrue(isLeapYear(1908));
        assertFalse(isLeapYear(1955));
        assertTrue(isLeapYear(1964));
        assertTrue(isLeapYear(1980));
        assertTrue(isLeapYear(2000));
        assertFalse(isLeapYear(2001));
        assertFalse(isLeapYear(2100));
    }

    public void testLeapYearCount() throws Exception {
        assertEquals(0, SpreadsheetDate.leapYearCount(1900));
        assertEquals(0, SpreadsheetDate.leapYearCount(1901));
        assertEquals(0, SpreadsheetDate.leapYearCount(1902));
        assertEquals(0, SpreadsheetDate.leapYearCount(1903));
        assertEquals(1, SpreadsheetDate.leapYearCount(1904));
        assertEquals(1, SpreadsheetDate.leapYearCount(1905));
        assertEquals(1, SpreadsheetDate.leapYearCount(1906));
        assertEquals(1, SpreadsheetDate.leapYearCount(1907));
        assertEquals(2, SpreadsheetDate.leapYearCount(1908));
        assertEquals(24, SpreadsheetDate.leapYearCount(1999));
        assertEquals(25, SpreadsheetDate.leapYearCount(2001));
        assertEquals(49, SpreadsheetDate.leapYearCount(2101));
        assertEquals(73, SpreadsheetDate.leapYearCount(2201));
        assertEquals(97, SpreadsheetDate.leapYearCount(2301));
        assertEquals(122, SpreadsheetDate.leapYearCount(2401));
    }

    public void testLastDayOfMonth() throws Exception {
        assertEquals(31, lastDayOfMonth(Month.JANUARY, 1901));
        assertEquals(28, lastDayOfMonth(Month.FEBRUARY, 1901));
        assertEquals(31, lastDayOfMonth(Month.MARCH, 1901));
        assertEquals(30, lastDayOfMonth(Month.APRIL, 1901));
        assertEquals(31, lastDayOfMonth(Month.MAY, 1901));
        assertEquals(30, lastDayOfMonth(Month.JUNE, 1901));
        assertEquals(31, lastDayOfMonth(Month.JULY, 1901));
        assertEquals(31, lastDayOfMonth(Month.AUGUST, 1901));
        assertEquals(30, lastDayOfMonth(Month.SEPTEMBER, 1901));
        assertEquals(31, lastDayOfMonth(Month.OCTOBER, 1901));
        assertEquals(30, lastDayOfMonth(Month.NOVEMBER, 1901));
        assertEquals(31, lastDayOfMonth(Month.DECEMBER, 1901));
        assertEquals(29, lastDayOfMonth(Month.FEBRUARY, 1904));
    }

    public void testAddDays() throws Exception {
        DayDate newYears = d(1, Month.JANUARY, 1900);
        assertEquals(d(2, Month.JANUARY, 1900), newYears.addDays(1));
        assertEquals(d(1, Month.FEBRUARY, 1900), newYears.addDays(31));
        assertEquals(d(1, Month.JANUARY, 1901), newYears.addDays(365));
        assertEquals(d(31, Month.DECEMBER, 1904), newYears.addDays(5 * 365));
    }

    private static SpreadsheetDate d(int day, Month month, int year) { return new SpreadsheetDate(day, month, year); }

    public void testAddMonths() throws Exception {
        assertEquals(d(1, Month.FEBRUARY, 1900), d(1, Month.JANUARY, 1900).addMonths(1));
        assertEquals(d(28, Month.FEBRUARY, 1900), d(31, Month.JANUARY, 1900).addMonths(1));
        assertEquals(d(28, Month.FEBRUARY, 1900), d(30, Month.JANUARY, 1900).addMonths(1));
        assertEquals(d(28, Month.FEBRUARY, 1900), d(29, Month.JANUARY, 1900).addMonths(1));
        assertEquals(d(28, Month.FEBRUARY, 1900), d(28, Month.JANUARY, 1900).addMonths(1));
        assertEquals(d(27, Month.FEBRUARY, 1900), d(27, Month.JANUARY, 1900).addMonths(1));

        assertEquals(d(30, Month.JUNE, 1900), d(31, Month.JANUARY, 1900).addMonths(5));
        assertEquals(d(30, Month.JUNE, 1901), d(31, Month.JANUARY, 1900).addMonths(17));

        assertEquals(d(29, Month.FEBRUARY, 1904), d(31, Month.JANUARY, 1900).addMonths(49));

    }

    public void testAddYears() throws Exception {
        assertEquals(d(1, Month.JANUARY, 1901), addYears(1, d(1, Month.JANUARY, 1900)));
        assertEquals(d(28, Month.FEBRUARY, 1905), addYears(1, d(29, Month.FEBRUARY, 1904)));
        assertEquals(d(28, Month.FEBRUARY, 1905), addYears(1, d(28, Month.FEBRUARY, 1904)));
        assertEquals(d(28, Month.FEBRUARY, 1904), addYears(1, d(28, Month.FEBRUARY, 1903)));
    }

    public void testGetPreviousDayOfWeek() throws Exception {
        assertEquals(d(24, Month.FEBRUARY, 2006), getPreviousDayOfWeek(Day.FRIDAY, d(1, Month.MARCH, 2006)));
        assertEquals(d(22, Month.FEBRUARY, 2006), getPreviousDayOfWeek(Day.WEDNESDAY, d(1, Month.MARCH, 2006)));
        assertEquals(d(29, Month.FEBRUARY, 2004), getPreviousDayOfWeek(Day.SUNDAY, d(3, Month.MARCH, 2004)));
        assertEquals(d(29, Month.DECEMBER, 2004), getPreviousDayOfWeek(Day.WEDNESDAY, d(5, Month.JANUARY, 2005)));
    }

    public void testGetFollowingDayOfWeek() throws Exception {
        assertEquals(d(1, Month.JANUARY, 2005),getFollowingDayOfWeek(Day.SATURDAY, d(25, Month.DECEMBER, 2004)));
        assertEquals(d(1, Month.JANUARY, 2005), getFollowingDayOfWeek(Day.SATURDAY, d(26, Month.DECEMBER, 2004)));
        assertEquals(d(3, Month.MARCH, 2004), getFollowingDayOfWeek(Day.WEDNESDAY, d(28, Month.FEBRUARY, 2004)));
    }

    public void testGetNearestDayOfWeek() throws Exception {
        assertEquals(d(16, Month.APRIL, 2006), getNearestDayOfWeek(Day.SUNDAY, d(16, Month.APRIL, 2006)));
        assertEquals(d(16, Month.APRIL, 2006), getNearestDayOfWeek(Day.SUNDAY, d(17, Month.APRIL, 2006)));
        assertEquals(d(16, Month.APRIL, 2006), getNearestDayOfWeek(Day.SUNDAY, d(18, Month.APRIL, 2006)));
        assertEquals(d(16, Month.APRIL, 2006), getNearestDayOfWeek(Day.SUNDAY, d(19, Month.APRIL, 2006)));
        assertEquals(d(23, Month.APRIL, 2006), getNearestDayOfWeek(Day.SUNDAY, d(20, Month.APRIL, 2006)));
        assertEquals(d(23, Month.APRIL, 2006), getNearestDayOfWeek(Day.SUNDAY, d(21, Month.APRIL, 2006)));
        assertEquals(d(23, Month.APRIL, 2006), getNearestDayOfWeek(Day.SUNDAY, d(22, Month.APRIL, 2006)));

        assertEquals(d(17, Month.APRIL, 2006), getNearestDayOfWeek(Day.MONDAY, d(16, Month.APRIL, 2006)));
        assertEquals(d(17, Month.APRIL, 2006), getNearestDayOfWeek(Day.MONDAY, d(17, Month.APRIL, 2006)));
        assertEquals(d(17, Month.APRIL, 2006), getNearestDayOfWeek(Day.MONDAY, d(18, Month.APRIL, 2006)));
        assertEquals(d(17, Month.APRIL, 2006), getNearestDayOfWeek(Day.MONDAY, d(19, Month.APRIL, 2006)));
        assertEquals(d(17, Month.APRIL, 2006), getNearestDayOfWeek(Day.MONDAY, d(20, Month.APRIL, 2006)));
        assertEquals(d(24, Month.APRIL, 2006), getNearestDayOfWeek(Day.MONDAY, d(21, Month.APRIL, 2006)));
        assertEquals(d(24, Month.APRIL, 2006), getNearestDayOfWeek(Day.MONDAY, d(22, Month.APRIL, 2006)));

        assertEquals(d(18, Month.APRIL, 2006), getNearestDayOfWeek(Day.TUESDAY, d(16, Month.APRIL, 2006)));
        assertEquals(d(18, Month.APRIL, 2006), getNearestDayOfWeek(Day.TUESDAY, d(17, Month.APRIL, 2006)));
        assertEquals(d(18, Month.APRIL, 2006), getNearestDayOfWeek(Day.TUESDAY, d(18, Month.APRIL, 2006)));
        assertEquals(d(18, Month.APRIL, 2006), getNearestDayOfWeek(Day.TUESDAY, d(19, Month.APRIL, 2006)));
        assertEquals(d(18, Month.APRIL, 2006), getNearestDayOfWeek(Day.TUESDAY, d(20, Month.APRIL, 2006)));
        assertEquals(d(18, Month.APRIL, 2006), getNearestDayOfWeek(Day.TUESDAY, d(21, Month.APRIL, 2006)));
        assertEquals(d(25, Month.APRIL, 2006), getNearestDayOfWeek(Day.TUESDAY, d(22, Month.APRIL, 2006)));

        assertEquals(d(19, Month.APRIL, 2006), getNearestDayOfWeek(Day.WEDNESDAY, d(16, Month.APRIL, 2006)));
        assertEquals(d(19, Month.APRIL, 2006), getNearestDayOfWeek(Day.WEDNESDAY, d(17, Month.APRIL, 2006)));
        assertEquals(d(19, Month.APRIL, 2006), getNearestDayOfWeek(Day.WEDNESDAY, d(18, Month.APRIL, 2006)));
        assertEquals(d(19, Month.APRIL, 2006), getNearestDayOfWeek(Day.WEDNESDAY, d(19, Month.APRIL, 2006)));
        assertEquals(d(19, Month.APRIL, 2006), getNearestDayOfWeek(Day.WEDNESDAY, d(20, Month.APRIL, 2006)));
        assertEquals(d(19, Month.APRIL, 2006), getNearestDayOfWeek(Day.WEDNESDAY, d(21, Month.APRIL, 2006)));
        assertEquals(d(19, Month.APRIL, 2006), getNearestDayOfWeek(Day.WEDNESDAY, d(22, Month.APRIL, 2006)));

        assertEquals(d(13, Month.APRIL, 2006), getNearestDayOfWeek(Day.THURSDAY, d(16, Month.APRIL, 2006)));
        assertEquals(d(20, Month.APRIL, 2006), getNearestDayOfWeek(Day.THURSDAY, d(17, Month.APRIL, 2006)));
        assertEquals(d(20, Month.APRIL, 2006), getNearestDayOfWeek(Day.THURSDAY, d(18, Month.APRIL, 2006)));
        assertEquals(d(20, Month.APRIL, 2006), getNearestDayOfWeek(Day.THURSDAY, d(19, Month.APRIL, 2006)));
        assertEquals(d(20, Month.APRIL, 2006), getNearestDayOfWeek(Day.THURSDAY, d(20, Month.APRIL, 2006)));
        assertEquals(d(20, Month.APRIL, 2006), getNearestDayOfWeek(Day.THURSDAY, d(21, Month.APRIL, 2006)));
        assertEquals(d(20, Month.APRIL, 2006), getNearestDayOfWeek(Day.THURSDAY, d(22, Month.APRIL, 2006)));

        assertEquals(d(14, Month.APRIL, 2006), getNearestDayOfWeek(Day.FRIDAY, d(16, Month.APRIL, 2006)));
        assertEquals(d(14, Month.APRIL, 2006), getNearestDayOfWeek(Day.FRIDAY, d(17, Month.APRIL, 2006)));
        assertEquals(d(21, Month.APRIL, 2006), getNearestDayOfWeek(Day.FRIDAY, d(18, Month.APRIL, 2006)));
        assertEquals(d(21, Month.APRIL, 2006), getNearestDayOfWeek(Day.FRIDAY, d(19, Month.APRIL, 2006)));
        assertEquals(d(21, Month.APRIL, 2006), getNearestDayOfWeek(Day.FRIDAY, d(20, Month.APRIL, 2006)));
        assertEquals(d(21, Month.APRIL, 2006), getNearestDayOfWeek(Day.FRIDAY, d(21, Month.APRIL, 2006)));
        assertEquals(d(21, Month.APRIL, 2006), getNearestDayOfWeek(Day.FRIDAY, d(22, Month.APRIL, 2006)));

        assertEquals(d(15, Month.APRIL, 2006), getNearestDayOfWeek(Day.SATURDAY, d(16, Month.APRIL, 2006)));
        assertEquals(d(15, Month.APRIL, 2006), getNearestDayOfWeek(Day.SATURDAY, d(17, Month.APRIL, 2006)));
        assertEquals(d(15, Month.APRIL, 2006), getNearestDayOfWeek(Day.SATURDAY, d(18, Month.APRIL, 2006)));
        assertEquals(d(22, Month.APRIL, 2006), getNearestDayOfWeek(Day.SATURDAY, d(19, Month.APRIL, 2006)));
        assertEquals(d(22, Month.APRIL, 2006), getNearestDayOfWeek(Day.SATURDAY, d(20, Month.APRIL, 2006)));
        assertEquals(d(22, Month.APRIL, 2006), getNearestDayOfWeek(Day.SATURDAY, d(21, Month.APRIL, 2006)));
        assertEquals(d(22, Month.APRIL, 2006), getNearestDayOfWeek(Day.SATURDAY, d(22, Month.APRIL, 2006)));
    }

    public void testEndOfCurrentMonth() throws Exception {
        DayDate d = DayDateFactory.makeDate(2);
        assertEquals(d(31, Month.JANUARY, 2006), d.getEndOfCurrentMonth(d(1, Month.JANUARY, 2006)));
        assertEquals(d(28, Month.FEBRUARY, 2006), d.getEndOfCurrentMonth(d(1, Month.FEBRUARY, 2006)));
        assertEquals(d(31, Month.MARCH, 2006), d.getEndOfCurrentMonth(d(1, Month.MARCH, 2006)));
        assertEquals(d(30, Month.APRIL, 2006), d.getEndOfCurrentMonth(d(1, Month.APRIL, 2006)));
        assertEquals(d(31, Month.MAY, 2006), d.getEndOfCurrentMonth(d(1, Month.MAY, 2006)));
        assertEquals(d(30, Month.JUNE, 2006), d.getEndOfCurrentMonth(d(1, Month.JUNE, 2006)));
        assertEquals(d(31, Month.JULY, 2006), d.getEndOfCurrentMonth(d(1, Month.JULY, 2006)));
        assertEquals(d(31, Month.AUGUST, 2006), d.getEndOfCurrentMonth(d(1, Month.AUGUST, 2006)));
        assertEquals(d(30, Month.SEPTEMBER, 2006), d.getEndOfCurrentMonth(d(1, Month.SEPTEMBER, 2006)));
        assertEquals(d(31, Month.OCTOBER, 2006), d.getEndOfCurrentMonth(d(1, Month.OCTOBER, 2006)));
        assertEquals(d(30, Month.NOVEMBER, 2006), d.getEndOfCurrentMonth(d(1, Month.NOVEMBER, 2006)));
        assertEquals(d(31, Month.DECEMBER, 2006), d.getEndOfCurrentMonth(d(1, Month.DECEMBER, 2006)));
        assertEquals(d(29, Month.FEBRUARY, 2008), d.getEndOfCurrentMonth(d(1, Month.FEBRUARY, 2008)));
    }

    public void testWeekInMonthToString() throws Exception {
        assertEquals("First", weekInMonthToString(WeekInMonth.FIRST));
        assertEquals("Second", weekInMonthToString(WeekInMonth.SECOND));
        assertEquals("Third", weekInMonthToString(WeekInMonth.THIRD));
        assertEquals("Fourth", weekInMonthToString(WeekInMonth.FOURTH));
        assertEquals("Last", weekInMonthToString(WeekInMonth.LAST));
    }

    public void testRelativeToString() throws Exception {
        assertEquals("Preceding", relativeToString(WeekdayRange.LAST));
        assertEquals("Nearest", relativeToString(WeekdayRange.NEAREST));
        assertEquals("Following", relativeToString(WeekdayRange.NEXT));
    }

    public void testCreateInstanceFromDDMMYYY() throws Exception {
        DayDate date = DayDateFactory.makeDate(1, Month.JANUARY, 1900);
        assertEquals(1, date.getDayOfMonth());
        assertEquals(Month.JANUARY, date.getMonth());
        assertEquals(1900, date.getYYYY());
        assertEquals(2, date.toOrdinal());
    }

    public void testCreateInstanceFromSerial() throws Exception {
        assertEquals(d(1, Month.JANUARY, 1900), DayDateFactory.makeDate(2));
        assertEquals(d(1, Month.JANUARY, 1901), DayDateFactory.makeDate(367));
    }

    public void testCreateInstanceFromJavaDate() throws Exception {
        assertEquals(d(1, Month.JANUARY, 1900), DayDateFactory.makeDate(new GregorianCalendar(1900, 0, 1).getTime()));
        assertEquals(d(1, Month.JANUARY, 2006), DayDateFactory.makeDate(new GregorianCalendar(2006, 0, 1).getTime()));
    }

    public static void main(String[] args) {
        junit.textui.TestRunner.run(BobsDayDateTest.class);
    }
}
