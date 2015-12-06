package org.jfree.date;

public enum WeekdayRange {
    LAST(-1), NEAREST(0), NEXT(1);
    public final int index;

    WeekdayRange(int index) {
        this.index = index;
    }
}
