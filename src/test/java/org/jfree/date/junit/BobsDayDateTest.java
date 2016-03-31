package org.jfree.date.junit;

import junit.framework.TestCase;
import org.jfree.date.*;

public class BobsDayDateTest extends TestCase {

    public void testAddDays() throws Exception {
        DayDate newYears = BobsTestUtil.d(1, Month.JANUARY, 1900);
        assertEquals(BobsTestUtil.d(2, Month.JANUARY, 1900), newYears.plusDays(1));
        assertEquals(BobsTestUtil.d(1, Month.FEBRUARY, 1900), newYears.plusDays(31));
        assertEquals(BobsTestUtil.d(1, Month.JANUARY, 1901), newYears.plusDays(365));
        assertEquals(BobsTestUtil.d(31, Month.DECEMBER, 1904), newYears.plusDays(5 * 365));
    }

    public void testAddMonths() throws Exception {
        assertEquals(BobsTestUtil.d(1, Month.FEBRUARY, 1900), BobsTestUtil.d(1, Month.JANUARY, 1900).plusMonths(1));
        assertEquals(BobsTestUtil.d(28, Month.FEBRUARY, 1900), BobsTestUtil.d(31, Month.JANUARY, 1900).plusMonths(1));
        assertEquals(BobsTestUtil.d(28, Month.FEBRUARY, 1900), BobsTestUtil.d(30, Month.JANUARY, 1900).plusMonths(1));
        assertEquals(BobsTestUtil.d(28, Month.FEBRUARY, 1900), BobsTestUtil.d(29, Month.JANUARY, 1900).plusMonths(1));
        assertEquals(BobsTestUtil.d(28, Month.FEBRUARY, 1900), BobsTestUtil.d(28, Month.JANUARY, 1900).plusMonths(1));
        assertEquals(BobsTestUtil.d(27, Month.FEBRUARY, 1900), BobsTestUtil.d(27, Month.JANUARY, 1900).plusMonths(1));

        assertEquals(BobsTestUtil.d(30, Month.JUNE, 1900), BobsTestUtil.d(31, Month.JANUARY, 1900).plusMonths(5));
        assertEquals(BobsTestUtil.d(30, Month.JUNE, 1901), BobsTestUtil.d(31, Month.JANUARY, 1900).plusMonths(17));

        assertEquals(BobsTestUtil.d(29, Month.FEBRUARY, 1904), BobsTestUtil.d(31, Month.JANUARY, 1900).plusMonths(49));
    }

    public void testAddYears() throws Exception {
        assertEquals(BobsTestUtil.d(1, Month.JANUARY, 1901), BobsTestUtil.d(1, Month.JANUARY, 1900).plusYears(1));
        assertEquals(BobsTestUtil.d(28, Month.FEBRUARY, 1905), BobsTestUtil.d(29, Month.FEBRUARY, 1904).plusYears(1));
        assertEquals(BobsTestUtil.d(28, Month.FEBRUARY, 1905), BobsTestUtil.d(28, Month.FEBRUARY, 1904).plusYears(1));
        assertEquals(BobsTestUtil.d(28, Month.FEBRUARY, 1904), BobsTestUtil.d(28, Month.FEBRUARY, 1903).plusYears(1));
    }

    public void testGetPreviousDayOfWeek() throws Exception {
        assertEquals(BobsTestUtil.d(24, Month.FEBRUARY, 2006), BobsTestUtil.d(1, Month.MARCH, 2006).getPreviousDayOfWeek(Day.FRIDAY));
        assertEquals(BobsTestUtil.d(22, Month.FEBRUARY, 2006), BobsTestUtil.d(1, Month.MARCH, 2006).getPreviousDayOfWeek(Day.WEDNESDAY));
        assertEquals(BobsTestUtil.d(29, Month.FEBRUARY, 2004), BobsTestUtil.d(3, Month.MARCH, 2004).getPreviousDayOfWeek(Day.SUNDAY));
        assertEquals(BobsTestUtil.d(29, Month.DECEMBER, 2004), BobsTestUtil.d(5, Month.JANUARY, 2005).getPreviousDayOfWeek(Day.WEDNESDAY));
    }

    public void testGetFollowingDayOfWeek() throws Exception {
        assertEquals(BobsTestUtil.d(1, Month.JANUARY, 2005), BobsTestUtil.d(25, Month.DECEMBER, 2004).getFollowingDayOfWeek(Day.SATURDAY));
        assertEquals(BobsTestUtil.d(1, Month.JANUARY, 2005), BobsTestUtil.d(26, Month.DECEMBER, 2004).getFollowingDayOfWeek(Day.SATURDAY));
        assertEquals(BobsTestUtil.d(3, Month.MARCH, 2004), BobsTestUtil.d(28, Month.FEBRUARY, 2004).getFollowingDayOfWeek(Day.WEDNESDAY));
    }

    public void testGetNearestDayOfWeek() throws Exception {
        assertEquals(BobsTestUtil.d(16, Month.APRIL, 2006), BobsTestUtil.d(16, Month.APRIL, 2006).getNearestDayOfWeek(Day.SUNDAY));
        assertEquals(BobsTestUtil.d(16, Month.APRIL, 2006), BobsTestUtil.d(17, Month.APRIL, 2006).getNearestDayOfWeek(Day.SUNDAY));
        assertEquals(BobsTestUtil.d(16, Month.APRIL, 2006), BobsTestUtil.d(18, Month.APRIL, 2006).getNearestDayOfWeek(Day.SUNDAY));
        assertEquals(BobsTestUtil.d(16, Month.APRIL, 2006), BobsTestUtil.d(19, Month.APRIL, 2006).getNearestDayOfWeek(Day.SUNDAY));
        assertEquals(BobsTestUtil.d(23, Month.APRIL, 2006), BobsTestUtil.d(20, Month.APRIL, 2006).getNearestDayOfWeek(Day.SUNDAY));
        assertEquals(BobsTestUtil.d(23, Month.APRIL, 2006), BobsTestUtil.d(21, Month.APRIL, 2006).getNearestDayOfWeek(Day.SUNDAY));
        assertEquals(BobsTestUtil.d(23, Month.APRIL, 2006), BobsTestUtil.d(22, Month.APRIL, 2006).getNearestDayOfWeek(Day.SUNDAY));

        assertEquals(BobsTestUtil.d(17, Month.APRIL, 2006), BobsTestUtil.d(16, Month.APRIL, 2006).getNearestDayOfWeek(Day.MONDAY));
        assertEquals(BobsTestUtil.d(17, Month.APRIL, 2006), BobsTestUtil.d(17, Month.APRIL, 2006).getNearestDayOfWeek(Day.MONDAY));
        assertEquals(BobsTestUtil.d(17, Month.APRIL, 2006), BobsTestUtil.d(18, Month.APRIL, 2006).getNearestDayOfWeek(Day.MONDAY));
        assertEquals(BobsTestUtil.d(17, Month.APRIL, 2006), BobsTestUtil.d(19, Month.APRIL, 2006).getNearestDayOfWeek(Day.MONDAY));
        assertEquals(BobsTestUtil.d(17, Month.APRIL, 2006), BobsTestUtil.d(20, Month.APRIL, 2006).getNearestDayOfWeek(Day.MONDAY));
        assertEquals(BobsTestUtil.d(24, Month.APRIL, 2006), BobsTestUtil.d(21, Month.APRIL, 2006).getNearestDayOfWeek(Day.MONDAY));
        assertEquals(BobsTestUtil.d(24, Month.APRIL, 2006), BobsTestUtil.d(22, Month.APRIL, 2006).getNearestDayOfWeek(Day.MONDAY));

        assertEquals(BobsTestUtil.d(18, Month.APRIL, 2006), BobsTestUtil.d(16, Month.APRIL, 2006).getNearestDayOfWeek(Day.TUESDAY));
        assertEquals(BobsTestUtil.d(18, Month.APRIL, 2006), BobsTestUtil.d(17, Month.APRIL, 2006).getNearestDayOfWeek(Day.TUESDAY));
        assertEquals(BobsTestUtil.d(18, Month.APRIL, 2006), BobsTestUtil.d(18, Month.APRIL, 2006).getNearestDayOfWeek(Day.TUESDAY));
        assertEquals(BobsTestUtil.d(18, Month.APRIL, 2006), BobsTestUtil.d(19, Month.APRIL, 2006).getNearestDayOfWeek(Day.TUESDAY));
        assertEquals(BobsTestUtil.d(18, Month.APRIL, 2006), BobsTestUtil.d(20, Month.APRIL, 2006).getNearestDayOfWeek(Day.TUESDAY));
        assertEquals(BobsTestUtil.d(18, Month.APRIL, 2006), BobsTestUtil.d(21, Month.APRIL, 2006).getNearestDayOfWeek(Day.TUESDAY));
        assertEquals(BobsTestUtil.d(25, Month.APRIL, 2006), BobsTestUtil.d(22, Month.APRIL, 2006).getNearestDayOfWeek(Day.TUESDAY));

        assertEquals(BobsTestUtil.d(19, Month.APRIL, 2006), BobsTestUtil.d(16, Month.APRIL, 2006).getNearestDayOfWeek(Day.WEDNESDAY));
        assertEquals(BobsTestUtil.d(19, Month.APRIL, 2006), BobsTestUtil.d(17, Month.APRIL, 2006).getNearestDayOfWeek(Day.WEDNESDAY));
        assertEquals(BobsTestUtil.d(19, Month.APRIL, 2006), BobsTestUtil.d(18, Month.APRIL, 2006).getNearestDayOfWeek(Day.WEDNESDAY));
        assertEquals(BobsTestUtil.d(19, Month.APRIL, 2006), BobsTestUtil.d(19, Month.APRIL, 2006).getNearestDayOfWeek(Day.WEDNESDAY));
        assertEquals(BobsTestUtil.d(19, Month.APRIL, 2006), BobsTestUtil.d(20, Month.APRIL, 2006).getNearestDayOfWeek(Day.WEDNESDAY));
        assertEquals(BobsTestUtil.d(19, Month.APRIL, 2006), BobsTestUtil.d(21, Month.APRIL, 2006).getNearestDayOfWeek(Day.WEDNESDAY));
        assertEquals(BobsTestUtil.d(19, Month.APRIL, 2006), BobsTestUtil.d(22, Month.APRIL, 2006).getNearestDayOfWeek(Day.WEDNESDAY));

        assertEquals(BobsTestUtil.d(13, Month.APRIL, 2006), BobsTestUtil.d(16, Month.APRIL, 2006).getNearestDayOfWeek(Day.THURSDAY));
        assertEquals(BobsTestUtil.d(20, Month.APRIL, 2006), BobsTestUtil.d(17, Month.APRIL, 2006).getNearestDayOfWeek(Day.THURSDAY));
        assertEquals(BobsTestUtil.d(20, Month.APRIL, 2006), BobsTestUtil.d(18, Month.APRIL, 2006).getNearestDayOfWeek(Day.THURSDAY));
        assertEquals(BobsTestUtil.d(20, Month.APRIL, 2006), BobsTestUtil.d(19, Month.APRIL, 2006).getNearestDayOfWeek(Day.THURSDAY));
        assertEquals(BobsTestUtil.d(20, Month.APRIL, 2006), BobsTestUtil.d(20, Month.APRIL, 2006).getNearestDayOfWeek(Day.THURSDAY));
        assertEquals(BobsTestUtil.d(20, Month.APRIL, 2006), BobsTestUtil.d(21, Month.APRIL, 2006).getNearestDayOfWeek(Day.THURSDAY));
        assertEquals(BobsTestUtil.d(20, Month.APRIL, 2006), BobsTestUtil.d(22, Month.APRIL, 2006).getNearestDayOfWeek(Day.THURSDAY));

        assertEquals(BobsTestUtil.d(14, Month.APRIL, 2006), BobsTestUtil.d(16, Month.APRIL, 2006).getNearestDayOfWeek(Day.FRIDAY));
        assertEquals(BobsTestUtil.d(14, Month.APRIL, 2006), BobsTestUtil.d(17, Month.APRIL, 2006).getNearestDayOfWeek(Day.FRIDAY));
        assertEquals(BobsTestUtil.d(21, Month.APRIL, 2006), BobsTestUtil.d(18, Month.APRIL, 2006).getNearestDayOfWeek(Day.FRIDAY));
        assertEquals(BobsTestUtil.d(21, Month.APRIL, 2006), BobsTestUtil.d(19, Month.APRIL, 2006).getNearestDayOfWeek(Day.FRIDAY));
        assertEquals(BobsTestUtil.d(21, Month.APRIL, 2006), BobsTestUtil.d(20, Month.APRIL, 2006).getNearestDayOfWeek(Day.FRIDAY));
        assertEquals(BobsTestUtil.d(21, Month.APRIL, 2006), BobsTestUtil.d(21, Month.APRIL, 2006).getNearestDayOfWeek(Day.FRIDAY));
        assertEquals(BobsTestUtil.d(21, Month.APRIL, 2006), BobsTestUtil.d(22, Month.APRIL, 2006).getNearestDayOfWeek(Day.FRIDAY));

        assertEquals(BobsTestUtil.d(15, Month.APRIL, 2006), BobsTestUtil.d(16, Month.APRIL, 2006).getNearestDayOfWeek(Day.SATURDAY));
        assertEquals(BobsTestUtil.d(15, Month.APRIL, 2006), BobsTestUtil.d(17, Month.APRIL, 2006).getNearestDayOfWeek(Day.SATURDAY));
        assertEquals(BobsTestUtil.d(15, Month.APRIL, 2006), BobsTestUtil.d(18, Month.APRIL, 2006).getNearestDayOfWeek(Day.SATURDAY));
        assertEquals(BobsTestUtil.d(22, Month.APRIL, 2006), BobsTestUtil.d(19, Month.APRIL, 2006).getNearestDayOfWeek(Day.SATURDAY));
        assertEquals(BobsTestUtil.d(22, Month.APRIL, 2006), BobsTestUtil.d(20, Month.APRIL, 2006).getNearestDayOfWeek(Day.SATURDAY));
        assertEquals(BobsTestUtil.d(22, Month.APRIL, 2006), BobsTestUtil.d(21, Month.APRIL, 2006).getNearestDayOfWeek(Day.SATURDAY));
        assertEquals(BobsTestUtil.d(22, Month.APRIL, 2006), BobsTestUtil.d(22, Month.APRIL, 2006).getNearestDayOfWeek(Day.SATURDAY));
    }

    public void testEndOfCurrentMonth() throws Exception {
        assertEquals(BobsTestUtil.d(31, Month.JANUARY, 2006), BobsTestUtil.d(1, Month.JANUARY, 2006).getEndOfCurrentMonth());
        assertEquals(BobsTestUtil.d(28, Month.FEBRUARY, 2006), BobsTestUtil.d(1, Month.FEBRUARY, 2006).getEndOfCurrentMonth());
        assertEquals(BobsTestUtil.d(31, Month.MARCH, 2006), BobsTestUtil.d(1, Month.MARCH, 2006).getEndOfCurrentMonth());
        assertEquals(BobsTestUtil.d(30, Month.APRIL, 2006), BobsTestUtil.d(1, Month.APRIL, 2006).getEndOfCurrentMonth());
        assertEquals(BobsTestUtil.d(31, Month.MAY, 2006), BobsTestUtil.d(1, Month.MAY, 2006).getEndOfCurrentMonth());
        assertEquals(BobsTestUtil.d(30, Month.JUNE, 2006), BobsTestUtil.d(1, Month.JUNE, 2006).getEndOfCurrentMonth());
        assertEquals(BobsTestUtil.d(31, Month.JULY, 2006), BobsTestUtil.d(1, Month.JULY, 2006).getEndOfCurrentMonth());
        assertEquals(BobsTestUtil.d(31, Month.AUGUST, 2006), BobsTestUtil.d(1, Month.AUGUST, 2006).getEndOfCurrentMonth());
        assertEquals(BobsTestUtil.d(30, Month.SEPTEMBER, 2006), BobsTestUtil.d(1, Month.SEPTEMBER, 2006).getEndOfCurrentMonth());
        assertEquals(BobsTestUtil.d(31, Month.OCTOBER, 2006), BobsTestUtil.d(1, Month.OCTOBER, 2006).getEndOfCurrentMonth());
        assertEquals(BobsTestUtil.d(30, Month.NOVEMBER, 2006), BobsTestUtil.d(1, Month.NOVEMBER, 2006).getEndOfCurrentMonth());
        assertEquals(BobsTestUtil.d(31, Month.DECEMBER, 2006), BobsTestUtil.d(1, Month.DECEMBER, 2006).getEndOfCurrentMonth());
        assertEquals(BobsTestUtil.d(29, Month.FEBRUARY, 2008), BobsTestUtil.d(1, Month.FEBRUARY, 2008).getEndOfCurrentMonth());
    }

    public void testDaysSince() throws Exception {
        DayDate newYears = BobsTestUtil.d(1, Month.JANUARY, 1900);
        assertEquals(1, BobsTestUtil.d(2, Month.JANUARY, 1900).daysSince(newYears));
        assertEquals(31, BobsTestUtil.d(1, Month.FEBRUARY, 1900).daysSince(newYears));
        assertEquals(365, BobsTestUtil.d(1, Month.JANUARY, 1901).daysSince(newYears));
        assertEquals(5 * 365, BobsTestUtil.d(31, Month.DECEMBER, 1904).daysSince(newYears));
    }

}
