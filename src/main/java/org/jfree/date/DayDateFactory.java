package org.jfree.date;

public interface DayDateFactory {
	
	public DayDate makeDate(int ordinal);

	public DayDate makeDate(int day, Month month, int year);

	public DayDate makeDate(int day, int month, int year);

	public DayDate makeDate(java.util.Date date);

	public int getMinumumYear();

	public int getMaximumYear();

}
