package org.jfree.date.junit;

import junit.framework.TestCase;
import org.jfree.date.Month;

public class BobsMonthTest extends TestCase{

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

}
