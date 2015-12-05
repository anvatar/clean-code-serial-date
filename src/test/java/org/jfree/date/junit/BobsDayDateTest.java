package org.jfree.date.junit;

import junit.framework.TestCase;
import org.jfree.date.*;
import static org.jfree.date.DayDate.*;

import java.util.*;

public class BobsDayDateTest extends TestCase {

    public void testIsValidWeekdayCode() throws Exception {
        for (int day = 1; day <= 7; day++)
            assertTrue(isValidWeekdayCode(day));
        assertFalse(isValidWeekdayCode(0));
        assertFalse(isValidWeekdayCode(8));
    }

    public void testStringToWeekdayCode() throws Exception {

        assertEquals(-1, stringToWeekdayCode("Hello"));
        assertEquals(MONDAY, stringToWeekdayCode("Monday"));
        assertEquals(MONDAY, stringToWeekdayCode("Mon"));
        assertEquals(MONDAY, stringToWeekdayCode("monday"));
        assertEquals(MONDAY, stringToWeekdayCode("MONDAY"));
        assertEquals(MONDAY, stringToWeekdayCode("mon"));

        assertEquals(TUESDAY, stringToWeekdayCode("Tuesday"));
        assertEquals(TUESDAY, stringToWeekdayCode("Tue"));
        assertEquals(TUESDAY, stringToWeekdayCode("tuesday"));
        assertEquals(TUESDAY, stringToWeekdayCode("TUESDAY"));
        assertEquals(TUESDAY, stringToWeekdayCode("tue"));
        // assertEquals(TUESDAY, stringToWeekdayCode("tues"));

        assertEquals(WEDNESDAY, stringToWeekdayCode("Wednesday"));
        assertEquals(WEDNESDAY, stringToWeekdayCode("Wed"));
        assertEquals(WEDNESDAY, stringToWeekdayCode("wednesday"));
        assertEquals(WEDNESDAY, stringToWeekdayCode("WEDNESDAY"));
        assertEquals(WEDNESDAY, stringToWeekdayCode("wed"));

        assertEquals(THURSDAY, stringToWeekdayCode("Thursday"));
        assertEquals(THURSDAY, stringToWeekdayCode("Thu"));
        assertEquals(THURSDAY, stringToWeekdayCode("thursday"));
        assertEquals(THURSDAY, stringToWeekdayCode("THURSDAY"));
        assertEquals(THURSDAY, stringToWeekdayCode("thu"));
        // assertEquals(THURSDAY, stringToWeekdayCode("thurs"));

        assertEquals(FRIDAY, stringToWeekdayCode("Friday"));
        assertEquals(FRIDAY, stringToWeekdayCode("Fri"));
        assertEquals(FRIDAY, stringToWeekdayCode("friday"));
        assertEquals(FRIDAY, stringToWeekdayCode("FRIDAY"));
        assertEquals(FRIDAY, stringToWeekdayCode("fri"));

        assertEquals(SATURDAY, stringToWeekdayCode("Saturday"));
        assertEquals(SATURDAY, stringToWeekdayCode("Sat"));
        assertEquals(SATURDAY, stringToWeekdayCode("saturday"));
        assertEquals(SATURDAY, stringToWeekdayCode("SATURDAY"));
        assertEquals(SATURDAY, stringToWeekdayCode("sat"));

        assertEquals(SUNDAY, stringToWeekdayCode("Sunday"));
        assertEquals(SUNDAY, stringToWeekdayCode("Sun"));
        assertEquals(SUNDAY, stringToWeekdayCode("sunday"));
        assertEquals(SUNDAY, stringToWeekdayCode("SUNDAY"));
        assertEquals(SUNDAY, stringToWeekdayCode("sun"));
    }

    public void testWeekdayCodeToString() throws Exception {
        assertEquals("Sunday", weekdayCodeToString(SUNDAY));
        assertEquals("Monday", weekdayCodeToString(MONDAY));
        assertEquals("Tuesday", weekdayCodeToString(TUESDAY));
        assertEquals("Wednesday", weekdayCodeToString(WEDNESDAY));
        assertEquals("Thursday", weekdayCodeToString(THURSDAY));
        assertEquals("Friday", weekdayCodeToString(FRIDAY));
        assertEquals("Saturday", weekdayCodeToString(SATURDAY));
    }

    public void testMonthToQuarter() throws Exception {
        assertEquals(1, monthToQuarter(Month.JANUARY));
        assertEquals(1, monthToQuarter(Month.FEBRUARY));
        assertEquals(1, monthToQuarter(Month.MARCH));
        assertEquals(2, monthToQuarter(Month.APRIL));
        assertEquals(2, monthToQuarter(Month.MAY));
        assertEquals(2, monthToQuarter(Month.JUNE));
        assertEquals(3, monthToQuarter(Month.JULY));
        assertEquals(3, monthToQuarter(Month.AUGUST));
        assertEquals(3, monthToQuarter(Month.SEPTEMBER));
        assertEquals(4, monthToQuarter(Month.OCTOBER));
        assertEquals(4, monthToQuarter(Month.NOVEMBER));
        assertEquals(4, monthToQuarter(Month.DECEMBER));

    }

    public void testMonthToString() throws Exception {
        assertEquals("January", monthToString(Month.JANUARY));
        assertEquals("February", monthToString(Month.FEBRUARY));
        assertEquals("March", monthToString(Month.MARCH));
        assertEquals("April", monthToString(Month.APRIL));
        assertEquals("May", monthToString(Month.MAY));
        assertEquals("June", monthToString(Month.JUNE));
        assertEquals("July", monthToString(Month.JULY));
        assertEquals("August", monthToString(Month.AUGUST));
        assertEquals("September", monthToString(Month.SEPTEMBER));
        assertEquals("October", monthToString(Month.OCTOBER));
        assertEquals("November", monthToString(Month.NOVEMBER));
        assertEquals("December", monthToString(Month.DECEMBER));

        assertEquals("Jan", monthToString(Month.JANUARY, true));
        assertEquals("Feb", monthToString(Month.FEBRUARY, true));
        assertEquals("Mar", monthToString(Month.MARCH, true));
        assertEquals("Apr", monthToString(Month.APRIL, true));
        assertEquals("May", monthToString(Month.MAY, true));
        assertEquals("Jun", monthToString(Month.JUNE, true));
        assertEquals("Jul", monthToString(Month.JULY, true));
        assertEquals("Aug", monthToString(Month.AUGUST, true));
        assertEquals("Sep", monthToString(Month.SEPTEMBER, true));
        assertEquals("Oct", monthToString(Month.OCTOBER, true));
        assertEquals("Nov", monthToString(Month.NOVEMBER, true));
        assertEquals("Dec", monthToString(Month.DECEMBER, true));

    }

    public void testStringToMonth() throws Exception {
        assertEquals(Month.JANUARY, stringToMonth("1"));
        assertEquals(Month.FEBRUARY, stringToMonth("2"));
        assertEquals(Month.MARCH, stringToMonth("3"));
        assertEquals(Month.APRIL, stringToMonth("4"));
        assertEquals(Month.MAY, stringToMonth("5"));
        assertEquals(Month.JUNE, stringToMonth("6"));
        assertEquals(Month.JULY, stringToMonth("7"));
        assertEquals(Month.AUGUST, stringToMonth("8"));
        assertEquals(Month.SEPTEMBER, stringToMonth("9"));
        assertEquals(Month.OCTOBER, stringToMonth("10"));
        assertEquals(Month.NOVEMBER, stringToMonth("11"));
        assertEquals(Month.DECEMBER, stringToMonth("12"));

        try {
            stringToMonth("0");
            fail("Invalid month index string should throw exception");
        } catch (IllegalArgumentException ignore) {
        }
        try {
            stringToMonth("13");
            fail("Invalid month index string should throw exception");
        } catch (IllegalArgumentException ignore) {
        }

        try {
            stringToMonth("Hello");
            fail("Invalid month index string should throw exception");
        } catch (IllegalArgumentException ignore) {
        }

        for (Month m : Month.values()) {
            assertEquals(m, stringToMonth(monthToString(m, false)));
            assertEquals(m, stringToMonth(monthToString(m, true)));
        }

         assertEquals(Month.JANUARY, stringToMonth("jan"));
         assertEquals(Month.FEBRUARY, stringToMonth("feb"));
         assertEquals(Month.MARCH, stringToMonth("mar"));
         assertEquals(Month.APRIL, stringToMonth("apr"));
         assertEquals(Month.MAY, stringToMonth("may"));
         assertEquals(Month.JUNE, stringToMonth("jun"));
         assertEquals(Month.JULY, stringToMonth("jul"));
         assertEquals(Month.AUGUST, stringToMonth("aug"));
         assertEquals(Month.SEPTEMBER, stringToMonth("sep"));
         assertEquals(Month.OCTOBER, stringToMonth("oct"));
         assertEquals(Month.NOVEMBER, stringToMonth("nov"));
         assertEquals(Month.DECEMBER, stringToMonth("dec"));

         assertEquals(Month.JANUARY, stringToMonth("JAN"));
         assertEquals(Month.FEBRUARY, stringToMonth("FEB"));
         assertEquals(Month.MARCH, stringToMonth("MAR"));
         assertEquals(Month.APRIL, stringToMonth("APR"));
         assertEquals(Month.MAY, stringToMonth("MAY"));
         assertEquals(Month.JUNE, stringToMonth("JUN"));
         assertEquals(Month.JULY, stringToMonth("JUL"));
         assertEquals(Month.AUGUST, stringToMonth("AUG"));
         assertEquals(Month.SEPTEMBER, stringToMonth("SEP"));
         assertEquals(Month.OCTOBER, stringToMonth("OCT"));
         assertEquals(Month.NOVEMBER, stringToMonth("NOV"));
         assertEquals(Month.DECEMBER, stringToMonth("DEC"));

         assertEquals(Month.JANUARY, stringToMonth("january"));
         assertEquals(Month.FEBRUARY, stringToMonth("february"));
         assertEquals(Month.MARCH, stringToMonth("march"));
         assertEquals(Month.APRIL, stringToMonth("april"));
         assertEquals(Month.MAY, stringToMonth("may"));
         assertEquals(Month.JUNE, stringToMonth("june"));
         assertEquals(Month.JULY, stringToMonth("july"));
         assertEquals(Month.AUGUST, stringToMonth("august"));
         assertEquals(Month.SEPTEMBER, stringToMonth("september"));
         assertEquals(Month.OCTOBER, stringToMonth("october"));
         assertEquals(Month.NOVEMBER, stringToMonth("november"));
         assertEquals(Month.DECEMBER, stringToMonth("december"));

         assertEquals(Month.JANUARY, stringToMonth("JANUARY"));
         assertEquals(Month.FEBRUARY, stringToMonth("FEBRUARY"));
         assertEquals(Month.MARCH, stringToMonth("MAR"));
         assertEquals(Month.APRIL, stringToMonth("APRIL"));
         assertEquals(Month.MAY, stringToMonth("MAY"));
         assertEquals(Month.JUNE, stringToMonth("JUNE"));
         assertEquals(Month.JULY, stringToMonth("JULY"));
         assertEquals(Month.AUGUST, stringToMonth("AUGUST"));
         assertEquals(Month.SEPTEMBER, stringToMonth("SEPTEMBER"));
         assertEquals(Month.OCTOBER, stringToMonth("OCTOBER"));
         assertEquals(Month.NOVEMBER, stringToMonth("NOVEMBER"));
         assertEquals(Month.DECEMBER, stringToMonth("DECEMBER"));
    }

    public void testIsValidWeekInMonthCode() throws Exception {
        for (int w = 0; w <= 4; w++) {
            assertTrue(isValidWeekInMonthCode(w));
        }
        assertFalse(isValidWeekInMonthCode(5));
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
        assertEquals(0, leapYearCount(1900));
        assertEquals(0, leapYearCount(1901));
        assertEquals(0, leapYearCount(1902));
        assertEquals(0, leapYearCount(1903));
        assertEquals(1, leapYearCount(1904));
        assertEquals(1, leapYearCount(1905));
        assertEquals(1, leapYearCount(1906));
        assertEquals(1, leapYearCount(1907));
        assertEquals(2, leapYearCount(1908));
        assertEquals(24, leapYearCount(1999));
        assertEquals(25, leapYearCount(2001));
        assertEquals(49, leapYearCount(2101));
        assertEquals(73, leapYearCount(2201));
        assertEquals(97, leapYearCount(2301));
        assertEquals(122, leapYearCount(2401));
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
        assertEquals(d(2, Month.JANUARY, 1900), addDays(1, newYears));
        assertEquals(d(1, Month.FEBRUARY, 1900), addDays(31, newYears));
        assertEquals(d(1, Month.JANUARY, 1901), addDays(365, newYears));
        assertEquals(d(31, Month.DECEMBER, 1904), addDays(5 * 365, newYears));
    }

    private static SpreadsheetDate d(int day, Month month, int year) { return new SpreadsheetDate(day, month, year); }

    public void testAddMonths() throws Exception {
        assertEquals(d(1, Month.FEBRUARY, 1900), addMonths(1, d(1, Month.JANUARY, 1900)));
        assertEquals(d(28, Month.FEBRUARY, 1900), addMonths(1, d(31, Month.JANUARY, 1900)));
        assertEquals(d(28, Month.FEBRUARY, 1900), addMonths(1, d(30, Month.JANUARY, 1900)));
        assertEquals(d(28, Month.FEBRUARY, 1900), addMonths(1, d(29, Month.JANUARY, 1900)));
        assertEquals(d(28, Month.FEBRUARY, 1900), addMonths(1, d(28, Month.JANUARY, 1900)));
        assertEquals(d(27, Month.FEBRUARY, 1900), addMonths(1, d(27, Month.JANUARY, 1900)));

        assertEquals(d(30, Month.JUNE, 1900), addMonths(5, d(31, Month.JANUARY, 1900)));
        assertEquals(d(30, Month.JUNE, 1901), addMonths(17, d(31, Month.JANUARY, 1900)));

        assertEquals(d(29, Month.FEBRUARY, 1904), addMonths(49, d(31, Month.JANUARY, 1900)));

    }

    public void testAddYears() throws Exception {
        assertEquals(d(1, Month.JANUARY, 1901), addYears(1, d(1, Month.JANUARY, 1900)));
        assertEquals(d(28, Month.FEBRUARY, 1905), addYears(1, d(29, Month.FEBRUARY, 1904)));
        assertEquals(d(28, Month.FEBRUARY, 1905), addYears(1, d(28, Month.FEBRUARY, 1904)));
        assertEquals(d(28, Month.FEBRUARY, 1904), addYears(1, d(28, Month.FEBRUARY, 1903)));
    }

    public void testGetPreviousDayOfWeek() throws Exception {
        assertEquals(d(24, Month.FEBRUARY, 2006), getPreviousDayOfWeek(FRIDAY, d(1, Month.MARCH, 2006)));
        assertEquals(d(22, Month.FEBRUARY, 2006), getPreviousDayOfWeek(WEDNESDAY, d(1, Month.MARCH, 2006)));
        assertEquals(d(29, Month.FEBRUARY, 2004), getPreviousDayOfWeek(SUNDAY, d(3, Month.MARCH, 2004)));
        assertEquals(d(29, Month.DECEMBER, 2004), getPreviousDayOfWeek(WEDNESDAY, d(5, Month.JANUARY, 2005)));

        try {
            getPreviousDayOfWeek(-1, d(1, Month.JANUARY, 2006));
            fail("Invalid day of week code should throw exception");
        } catch (IllegalArgumentException e) {
        }
    }

    public void testGetFollowingDayOfWeek() throws Exception {
        assertEquals(d(1, Month.JANUARY, 2005),getFollowingDayOfWeek(SATURDAY, d(25, Month.DECEMBER, 2004)));
        assertEquals(d(1, Month.JANUARY, 2005), getFollowingDayOfWeek(SATURDAY, d(26, Month.DECEMBER, 2004)));
        assertEquals(d(3, Month.MARCH, 2004), getFollowingDayOfWeek(WEDNESDAY, d(28, Month.FEBRUARY, 2004)));

        try {
            getFollowingDayOfWeek(-1, d(1, Month.JANUARY, 2006));
            fail("Invalid day of week code should throw exception");
        } catch (IllegalArgumentException e) {
        }
    }

    public void testGetNearestDayOfWeek() throws Exception {
        assertEquals(d(16, Month.APRIL, 2006), getNearestDayOfWeek(SUNDAY, d(16, Month.APRIL, 2006)));
        assertEquals(d(16, Month.APRIL, 2006), getNearestDayOfWeek(SUNDAY, d(17, Month.APRIL, 2006)));
        assertEquals(d(16, Month.APRIL, 2006), getNearestDayOfWeek(SUNDAY, d(18, Month.APRIL, 2006)));
        assertEquals(d(16, Month.APRIL, 2006), getNearestDayOfWeek(SUNDAY, d(19, Month.APRIL, 2006)));
        assertEquals(d(23, Month.APRIL, 2006), getNearestDayOfWeek(SUNDAY, d(20, Month.APRIL, 2006)));
        assertEquals(d(23, Month.APRIL, 2006), getNearestDayOfWeek(SUNDAY, d(21, Month.APRIL, 2006)));
        assertEquals(d(23, Month.APRIL, 2006), getNearestDayOfWeek(SUNDAY, d(22, Month.APRIL, 2006)));

        assertEquals(d(17, Month.APRIL, 2006), getNearestDayOfWeek(MONDAY, d(16, Month.APRIL, 2006)));
        assertEquals(d(17, Month.APRIL, 2006), getNearestDayOfWeek(MONDAY, d(17, Month.APRIL, 2006)));
        assertEquals(d(17, Month.APRIL, 2006), getNearestDayOfWeek(MONDAY, d(18, Month.APRIL, 2006)));
        assertEquals(d(17, Month.APRIL, 2006), getNearestDayOfWeek(MONDAY, d(19, Month.APRIL, 2006)));
        assertEquals(d(17, Month.APRIL, 2006), getNearestDayOfWeek(MONDAY, d(20, Month.APRIL, 2006)));
        assertEquals(d(24, Month.APRIL, 2006), getNearestDayOfWeek(MONDAY, d(21, Month.APRIL, 2006)));
        assertEquals(d(24, Month.APRIL, 2006), getNearestDayOfWeek(MONDAY, d(22, Month.APRIL, 2006)));

        assertEquals(d(18, Month.APRIL, 2006), getNearestDayOfWeek(TUESDAY, d(16, Month.APRIL, 2006)));
        assertEquals(d(18, Month.APRIL, 2006), getNearestDayOfWeek(TUESDAY, d(17, Month.APRIL, 2006)));
        assertEquals(d(18, Month.APRIL, 2006), getNearestDayOfWeek(TUESDAY, d(18, Month.APRIL, 2006)));
        assertEquals(d(18, Month.APRIL, 2006), getNearestDayOfWeek(TUESDAY, d(19, Month.APRIL, 2006)));
        assertEquals(d(18, Month.APRIL, 2006), getNearestDayOfWeek(TUESDAY, d(20, Month.APRIL, 2006)));
        assertEquals(d(18, Month.APRIL, 2006), getNearestDayOfWeek(TUESDAY, d(21, Month.APRIL, 2006)));
        assertEquals(d(25, Month.APRIL, 2006), getNearestDayOfWeek(TUESDAY, d(22, Month.APRIL, 2006)));

        assertEquals(d(19, Month.APRIL, 2006), getNearestDayOfWeek(WEDNESDAY, d(16, Month.APRIL, 2006)));
        assertEquals(d(19, Month.APRIL, 2006), getNearestDayOfWeek(WEDNESDAY, d(17, Month.APRIL, 2006)));
        assertEquals(d(19, Month.APRIL, 2006), getNearestDayOfWeek(WEDNESDAY, d(18, Month.APRIL, 2006)));
        assertEquals(d(19, Month.APRIL, 2006), getNearestDayOfWeek(WEDNESDAY, d(19, Month.APRIL, 2006)));
        assertEquals(d(19, Month.APRIL, 2006), getNearestDayOfWeek(WEDNESDAY, d(20, Month.APRIL, 2006)));
        assertEquals(d(19, Month.APRIL, 2006), getNearestDayOfWeek(WEDNESDAY, d(21, Month.APRIL, 2006)));
        assertEquals(d(19, Month.APRIL, 2006), getNearestDayOfWeek(WEDNESDAY, d(22, Month.APRIL, 2006)));

        assertEquals(d(13, Month.APRIL, 2006), getNearestDayOfWeek(THURSDAY, d(16, Month.APRIL, 2006)));
        assertEquals(d(20, Month.APRIL, 2006), getNearestDayOfWeek(THURSDAY, d(17, Month.APRIL, 2006)));
        assertEquals(d(20, Month.APRIL, 2006), getNearestDayOfWeek(THURSDAY, d(18, Month.APRIL, 2006)));
        assertEquals(d(20, Month.APRIL, 2006), getNearestDayOfWeek(THURSDAY, d(19, Month.APRIL, 2006)));
        assertEquals(d(20, Month.APRIL, 2006), getNearestDayOfWeek(THURSDAY, d(20, Month.APRIL, 2006)));
        assertEquals(d(20, Month.APRIL, 2006), getNearestDayOfWeek(THURSDAY, d(21, Month.APRIL, 2006)));
        assertEquals(d(20, Month.APRIL, 2006), getNearestDayOfWeek(THURSDAY, d(22, Month.APRIL, 2006)));

        assertEquals(d(14, Month.APRIL, 2006), getNearestDayOfWeek(FRIDAY, d(16, Month.APRIL, 2006)));
        assertEquals(d(14, Month.APRIL, 2006), getNearestDayOfWeek(FRIDAY, d(17, Month.APRIL, 2006)));
        assertEquals(d(21, Month.APRIL, 2006), getNearestDayOfWeek(FRIDAY, d(18, Month.APRIL, 2006)));
        assertEquals(d(21, Month.APRIL, 2006), getNearestDayOfWeek(FRIDAY, d(19, Month.APRIL, 2006)));
        assertEquals(d(21, Month.APRIL, 2006), getNearestDayOfWeek(FRIDAY, d(20, Month.APRIL, 2006)));
        assertEquals(d(21, Month.APRIL, 2006), getNearestDayOfWeek(FRIDAY, d(21, Month.APRIL, 2006)));
        assertEquals(d(21, Month.APRIL, 2006), getNearestDayOfWeek(FRIDAY, d(22, Month.APRIL, 2006)));

        assertEquals(d(15, Month.APRIL, 2006), getNearestDayOfWeek(SATURDAY, d(16, Month.APRIL, 2006)));
        assertEquals(d(15, Month.APRIL, 2006), getNearestDayOfWeek(SATURDAY, d(17, Month.APRIL, 2006)));
        assertEquals(d(15, Month.APRIL, 2006), getNearestDayOfWeek(SATURDAY, d(18, Month.APRIL, 2006)));
        assertEquals(d(22, Month.APRIL, 2006), getNearestDayOfWeek(SATURDAY, d(19, Month.APRIL, 2006)));
        assertEquals(d(22, Month.APRIL, 2006), getNearestDayOfWeek(SATURDAY, d(20, Month.APRIL, 2006)));
        assertEquals(d(22, Month.APRIL, 2006), getNearestDayOfWeek(SATURDAY, d(21, Month.APRIL, 2006)));
        assertEquals(d(22, Month.APRIL, 2006), getNearestDayOfWeek(SATURDAY, d(22, Month.APRIL, 2006)));

        try {
            getNearestDayOfWeek(-1, d(1, Month.JANUARY, 2006));
            fail("Invalid day of week code should throw exception");
        } catch (IllegalArgumentException e) {
        }
    }

    public void testEndOfCurrentMonth() throws Exception {
        DayDate d = createInstance(2);
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
        assertEquals("First", weekInMonthToString(FIRST_WEEK_IN_MONTH));
        assertEquals("Second", weekInMonthToString(SECOND_WEEK_IN_MONTH));
        assertEquals("Third", weekInMonthToString(THIRD_WEEK_IN_MONTH));
        assertEquals("Fourth", weekInMonthToString(FOURTH_WEEK_IN_MONTH));
        assertEquals("Last", weekInMonthToString(LAST_WEEK_IN_MONTH));

        try {
            weekInMonthToString(-1);
            fail("Invalid week code should throw exception");
        } catch (IllegalArgumentException e) {
        }
    }

    public void testRelativeToString() throws Exception {
        assertEquals("Preceding", relativeToString(PRECEDING));
        assertEquals("Nearest", relativeToString(NEAREST));
        assertEquals("Following", relativeToString(FOLLOWING));

        try {
            relativeToString(-1000);
            fail("Invalid relative code should throw exception");
        } catch (IllegalArgumentException e) {
        }
    }

    public void testCreateInstanceFromDDMMYYY() throws Exception {
        DayDate date = createInstance(1, Month.JANUARY, 1900);
        assertEquals(1, date.getDayOfMonth());
        assertEquals(Month.JANUARY, date.getMonth());
        assertEquals(1900, date.getYYYY());
        assertEquals(2, date.toSerial());
    }

    public void testCreateInstanceFromSerial() throws Exception {
        assertEquals(d(1, Month.JANUARY, 1900), createInstance(2));
        assertEquals(d(1, Month.JANUARY, 1901), createInstance(367));
    }

    public void testCreateInstanceFromJavaDate() throws Exception {
        assertEquals(d(1, Month.JANUARY, 1900), createInstance(new GregorianCalendar(1900, 0, 1).getTime()));
        assertEquals(d(1, Month.JANUARY, 2006), createInstance(new GregorianCalendar(2006, 0, 1).getTime()));
    }

    public static void main(String[] args) {
        junit.textui.TestRunner.run(BobsDayDateTest.class);
    }
}
