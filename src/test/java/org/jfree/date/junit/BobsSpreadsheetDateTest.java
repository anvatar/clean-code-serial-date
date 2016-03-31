package org.jfree.date.junit;

import junit.framework.TestCase;
import org.jfree.date.SpreadsheetDate;

public class BobsSpreadsheetDateTest extends TestCase {

    public void testLeapYearCount() throws Exception {
        TestCase.assertEquals(0, SpreadsheetDate.leapYearCount(1900));
        TestCase.assertEquals(0, SpreadsheetDate.leapYearCount(1901));
        TestCase.assertEquals(0, SpreadsheetDate.leapYearCount(1902));
        TestCase.assertEquals(0, SpreadsheetDate.leapYearCount(1903));
        TestCase.assertEquals(1, SpreadsheetDate.leapYearCount(1904));
        TestCase.assertEquals(1, SpreadsheetDate.leapYearCount(1905));
        TestCase.assertEquals(1, SpreadsheetDate.leapYearCount(1906));
        TestCase.assertEquals(1, SpreadsheetDate.leapYearCount(1907));
        TestCase.assertEquals(2, SpreadsheetDate.leapYearCount(1908));
        TestCase.assertEquals(24, SpreadsheetDate.leapYearCount(1999));
        TestCase.assertEquals(25, SpreadsheetDate.leapYearCount(2001));
        TestCase.assertEquals(49, SpreadsheetDate.leapYearCount(2101));
        TestCase.assertEquals(73, SpreadsheetDate.leapYearCount(2201));
        TestCase.assertEquals(97, SpreadsheetDate.leapYearCount(2301));
        TestCase.assertEquals(122, SpreadsheetDate.leapYearCount(2401));
    }

}
