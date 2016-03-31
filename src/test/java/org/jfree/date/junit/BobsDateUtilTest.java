package org.jfree.date.junit;

import junit.framework.TestCase;
import org.jfree.date.DateUtil;
import org.jfree.date.Month;

public class BobsDateUtilTest extends TestCase {

    public void testIsLeapYear() throws Exception {
        assertFalse(DateUtil.isLeapYear(1900));
        assertFalse(DateUtil.isLeapYear(1901));
        assertFalse(DateUtil.isLeapYear(1902));
        assertFalse(DateUtil.isLeapYear(1903));
        assertTrue(DateUtil.isLeapYear(1904));
        assertTrue(DateUtil.isLeapYear(1908));
        assertFalse(DateUtil.isLeapYear(1955));
        assertTrue(DateUtil.isLeapYear(1964));
        assertTrue(DateUtil.isLeapYear(1980));
        assertTrue(DateUtil.isLeapYear(2000));
        assertFalse(DateUtil.isLeapYear(2001));
        assertFalse(DateUtil.isLeapYear(2100));
    }

    public void testLastDayOfMonth() throws Exception {
        assertEquals(31, DateUtil.lastDayOfMonth(Month.JANUARY, 1901));
        assertEquals(28, DateUtil.lastDayOfMonth(Month.FEBRUARY, 1901));
        assertEquals(31, DateUtil.lastDayOfMonth(Month.MARCH, 1901));
        assertEquals(30, DateUtil.lastDayOfMonth(Month.APRIL, 1901));
        assertEquals(31, DateUtil.lastDayOfMonth(Month.MAY, 1901));
        assertEquals(30, DateUtil.lastDayOfMonth(Month.JUNE, 1901));
        assertEquals(31, DateUtil.lastDayOfMonth(Month.JULY, 1901));
        assertEquals(31, DateUtil.lastDayOfMonth(Month.AUGUST, 1901));
        assertEquals(30, DateUtil.lastDayOfMonth(Month.SEPTEMBER, 1901));
        assertEquals(31, DateUtil.lastDayOfMonth(Month.OCTOBER, 1901));
        assertEquals(30, DateUtil.lastDayOfMonth(Month.NOVEMBER, 1901));
        assertEquals(31, DateUtil.lastDayOfMonth(Month.DECEMBER, 1901));
        assertEquals(29, DateUtil.lastDayOfMonth(Month.FEBRUARY, 1904));
    }

}
