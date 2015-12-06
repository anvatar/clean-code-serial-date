/* ========================================================================
 * JCommon : a free general purpose class library for the Java(tm) platform
 * ========================================================================
 * 
 * (C) Copyright 2000-2005, by Object Refinery Limited and Contributors.
 * 
 * Project Info: http://www.jfree.org/jcommon/index.html
 * 
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301,
 * USA.
 * 
 * [Java is a trademark or registered trademark of Sun Microsystems, Inc.
 * in the United States and other countries.]
 * 
 * ---------------
 * SerialDate.java
 * ---------------
 * (C) Copyright 2001-2005, by Object Refinery Limited.
 * 
 * Original Author: David Gilbert (for Object Refinery Limited);
 * Contributor(s): -;
 * 
 */

package org.jfree.date;

import java.io.Serializable;
import java.text.*;
import java.util.*;

/**
 *  An abstract class that represents immutable dates with a precision of
 *  one day. The implementation will map each date to an integer that
 *  represents an ordinal number of days from some fixed origin.
 *
 *  Why not just use java.util.Date? We will, when it makes sense. At times,
 *  java.util.Date can be *too* precise - it represents an instant in time,
 *  accurate to 1/1000th of a second (with the date itself depending on the
 *  time-zone). Sometimes we just want to represent a particular day (e.g. 21
 *  January 2015) without concerning ourselves about the time of day, or the
 *  time-zone, or anything else. That's what we've defined DayDate for.
 *
 *  You can call getInstance() to get a concrete subclass of DayDate,
 *  without worrying about the exact implementation.
 *
 * @author David Gilbert
 */
public abstract class DayDate implements Comparable, Serializable {

    public static final DateFormatSymbols
            DATE_FORMAT_SYMBOLS = new SimpleDateFormat().getDateFormatSymbols();

    public enum WeekInMonth {
        FIRST(1), SECOND(2), THIRD(3), FOURTH(4), LAST(0);
        public final int index;

        WeekInMonth(int index) {
            this.index = index;
        }
    }

    public enum DateInterval {
        CLOSED(0), CLOSED_LEFT(1), CLOSED_RIGHT(2), OPEN(3);
        public final int index;

        DateInterval(int index) {
            this.index = index;
        }
    }

    public enum WeekdayRange {
        LAST(-1), NEAREST(0), NEXT(1);
        public final int index;

        WeekdayRange(int index) {
            this.index = index;
        }
    }

    public static String[] getMonthNames() {
        return DATE_FORMAT_SYMBOLS.getMonths();
    }

    public static boolean isLeapYear(final int year) {
        boolean fourth = (year % 4) == 0;
        boolean hundredth = (year % 100) == 0;
        boolean fourHundredth = (year % 400) == 0;
        return fourth && (!hundredth || fourHundredth);
    }

    /**
     * Returns the number of the last day of the month, taking into account
     * leap years.
     *
     * @param month the month.
     * @param year  the year (in the range 1900 to 9999).
     *
     * @return the number of the last day of the month.
     */
    public static int lastDayOfMonth(final Month month, final int year) {
        if (month == Month.FEBRUARY && isLeapYear(year))
            return month.lastDay() + 1;
        else
            return month.lastDay();
    }

    public DayDate plusDays(int days) {
        return DayDateFactory.makeDate(getOrdinalDay() + days);
    }

    public DayDate plusMonths(int months) {
        int thisMonthAsOrdinal = 12 * getYear() + getMonth().index - 1;
        int resultMonthAsOrdinal = thisMonthAsOrdinal + months;
        int resultYear = resultMonthAsOrdinal / 12;
        Month resultMonth = Month.make(resultMonthAsOrdinal % 12 + 1);

        int lastDayOfResultMonth = lastDayOfMonth(resultMonth, resultYear);
        int resultDay = Math.min(getDayOfMonth(), lastDayOfResultMonth);
        return DayDateFactory.makeDate(resultDay, resultMonth, resultYear);
    }

    public DayDate plusYears(int years) {
        int resultYear = getYear() + years;
        int lastDayOfMonthInResultYear = DayDate.lastDayOfMonth(getMonth(), resultYear);
        int resultDay = Math.min(getDayOfMonth(), lastDayOfMonthInResultYear);
        return DayDateFactory.makeDate(resultDay, getMonth(), resultYear);
    }

    /**
     * Returns the latest date that falls on the specified day-of-the-week and
     * is BEFORE the base date.
     *
     * @param targetDayOfWeek a code for the target day-of-the-week.
     *
     * @return the latest date that falls on the specified day-of-the-week and
     *         is BEFORE the base date.
     */
    public DayDate getPreviousDayOfWeek(Day targetDayOfWeek) {
        int offsetToTarget = targetDayOfWeek.index - getDayOfWeek().index;
        if (offsetToTarget >= 0)
            offsetToTarget -= 7;
        return plusDays(offsetToTarget);
    }

    /**
     * Returns the earliest date that falls on the specified day-of-the-week
     * and is AFTER the base date.
     *
     * @param targetDayOfWeek a code for the target day-of-the-week.
     *
     * @return the earliest date that falls on the specified day-of-the-week
     * and is AFTER the base date.
     */
    public DayDate getFollowingDayOfWeek(Day targetDayOfWeek) {
        int offsetToTarget = targetDayOfWeek.index - getDayOfWeek().index;
        if (offsetToTarget <= 0)
            offsetToTarget += 7;
        return plusDays(offsetToTarget);
    }

    /**
     * Returns the date that falls on the specified day-of-the-week and is
     * CLOSEST to the base date.
     *
     * @param targetDayOfWeek a code for the target day-of-the-week.
     *
     * @return the date that falls on the specified day-of-the-week and is
     *         CLOSEST to the base date.
     */
    public DayDate getNearestDayOfWeek(Day targetDayOfWeek) {
        int offsetToThisWeeksTarget = targetDayOfWeek.index - getDayOfWeek().index;
        int offsetToFutureTarget = (offsetToThisWeeksTarget + 7) % 7;
        int offsetToPreviousTarget = offsetToFutureTarget - 7;
        if (offsetToFutureTarget > 3)
            return plusDays(offsetToPreviousTarget);
        else
            return plusDays(offsetToFutureTarget);
    }

    /**
     * Rolls the date forward to the last day of the month.
     *
     * @return a new serial date.
     */
    public DayDate getEndOfCurrentMonth() {
        Month month = getMonth();
        int year = getYear();
        int last = DayDate.lastDayOfMonth(month, year);
        return DayDateFactory.makeDate(last, month, year);
    }

    /**
     * Returns the serial number for the date, where 1 January 1900 = 2 (this
     * corresponds, almost, to the numbering system used in Microsoft Excel for
     * Windows and Lotus 1-2-3).
     *
     * @return the serial number for the date.
     */
    public abstract int getOrdinalDay();

    public Date toDate() {
        final Calendar calendar = Calendar.getInstance();
        calendar.set(getYear(), getMonth().index - 1, getDayOfMonth(), 0, 0, 0);
        return calendar.getTime();
    }

    public String toString() {
        return getDayOfMonth() + "-" + getMonth().toString()
                               + "-" + getYear();
    }

    public abstract int getYear();

    public abstract Month getMonth();

    public abstract int getDayOfMonth();

    public Day getDayOfWeek() {
        Day startingDay = getDayOfWeekForOrdinalZero();
        int startingOffset = startingDay.index - Day.SUNDAY.index;
        return Day.make((getOrdinalDay() + startingOffset) % 7 + 1);
    }

    protected abstract Day getDayOfWeekForOrdinalZero();

    public int daysSince(final DayDate other) {
        return getOrdinalDay() - other.getOrdinalDay();
    }

    /**
     * Returns true if this DayDate represents the same date as the
     * specified DayDate.
     *
     * @param other the date being compared to.
     *
     * @return <code>true</code> if this DayDate represents the same date as
     *         the specified DayDate.
     */
    public boolean isOn(final DayDate other) {
        return (getOrdinalDay() == other.getOrdinalDay());
    }

    /**
     * Returns true if this DayDate represents an earlier date compared to
     * the specified DayDate.
     *
     * @param other the date being compared to.
     *
     * @return <code>true</code> if this DayDate represents an earlier date
     *         compared to the specified DayDate.
     */
    public boolean isBefore(final DayDate other) {
        return (getOrdinalDay() < other.getOrdinalDay());
    }

    /**
     * Returns true if this DayDate represents the same date as the
     * specified DayDate.
     *
     * @param other the date being compared to.
     *
     * @return <code>true</code> if this DayDate represents the same date
     *         as the specified DayDate.
     */
    public boolean isOnOrBefore(final DayDate other) {
        return (getOrdinalDay() <= other.getOrdinalDay());
    }

    /**
     * Returns true if this DayDate represents the same date as the
     * specified DayDate.
     *
     * @param other the date being compared to.
     *
     * @return <code>true</code> if this DayDate represents the same date
     *         as the specified DayDate.
     */
    public boolean isAfter(final DayDate other) {
        return (getOrdinalDay() > other.getOrdinalDay());
    }

    /**
     * Returns true if this DayDate represents the same date as the
     * specified DayDate.
     *
     * @param other the date being compared to.
     *
     * @return <code>true</code> if this DayDate represents the same date as
     *         the specified DayDate.
     */
    public boolean isOnOrAfter(final DayDate other) {
        return (getOrdinalDay() >= other.getOrdinalDay());
    }

    /**
     * Returns <code>true</code> if this {@link DayDate} is within the
     * specified range (INCLUSIVE). The date order of d1 and d2 is not
     * important.
     *
     * @param d1 a boundary date for the range.
     * @param d2 the other boundary date for the range.
     *
     * @return A boolean.
     */
    public boolean isInRange(final DayDate d1, final DayDate d2) {
        return isInRange(d1, d2, DateInterval.OPEN);
    }

    /**
     * Returns <code>true</code> if this {@link DayDate} is within the
     * specified range (caller specifies whether or not the end-points are
     * included). The date order of d1 and d2 is not important.
     *
     * @param d1      a boundary date for the range.
     * @param d2      the other boundary date for the range.
     * @param include a code that controls whether or not the start and end
     *                dates are included in the range.
     *
     * @return A boolean.
     */
    public boolean isInRange(final DayDate d1, final DayDate d2,
                             final DateInterval include) {
        final int s1 = d1.getOrdinalDay();
        final int s2 = d2.getOrdinalDay();
        final int start = Math.min(s1, s2);
        final int end = Math.max(s1, s2);

        final int s = getOrdinalDay();
        if (include == DateInterval.OPEN) {
            return (s >= start && s <= end);
        }
        else if (include == DateInterval.CLOSED_LEFT) {
            return (s >= start && s < end);
        }
        else if (include == DateInterval.CLOSED_RIGHT) {
            return (s > start && s <= end);
        }
        else {
            return (s > start && s < end);
        }
    }

}