package org.jfree.date;

public enum DateInterval {
    OPEN(0) {
        public boolean isIn(int d, int left, int right) {
            return d > left && d < right;
        }
    },
    CLOSED_LEFT(1) {
        public boolean isIn(int d, int left, int right) {
            return d >= left && d < right;
        }
    },
    CLOSED_RIGHT(2) {
        public boolean isIn(int d, int left, int right) {
            return d > left && d <= right;
        }
    },
    CLOSED(3) {
        public boolean isIn(int d, int left, int right) {
            return d >= left && d <= right;
        }
    };
    public final int index;

    DateInterval(int index) {
        this.index = index;
    }

    public abstract boolean isIn(int d, int left, int right);
}
