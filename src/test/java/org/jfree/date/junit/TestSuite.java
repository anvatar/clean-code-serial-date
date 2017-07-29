package org.jfree.date.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	BobsDateUtilTest.class,
	BobsDayDateFactoryTest.class,
	BobsDayDateTest.class,
	BobsMonthTest.class,
	BobsSpreadsheetDateTest.class,
	DayDateTests.class
})
public class TestSuite {

}
