package org.jfree.date;

public abstract class DayDateBuilder {
    private static DayDateFactory factory = new SpreadsheetDateFactory();
    
    public static void setInstance(DayDateFactory factory) {
        DayDateBuilder.factory = factory;
    }

    public static DayDate makeDate(int ordinal) {
        return factory.makeDate(ordinal);
    }

    public static DayDate makeDate(int day, Month month, int year) {
        return factory.makeDate(day, month, year);
    }

    public static DayDate makeDate(int day, int month, int year) {
        return factory.makeDate(day, month, year);
    }

    public static DayDate makeDate(java.util.Date date) {
        return factory.makeDate(date);
    }

    public static int getMinumumYear() {
        return factory.getMinumumYear();
    }

    public static int getMaximumYear() {
        return factory.getMaximumYear();
    }
}
