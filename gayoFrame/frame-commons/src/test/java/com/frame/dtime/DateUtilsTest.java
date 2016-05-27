package com.frame.dtime;

import static org.junit.Assert.*;

import org.junit.Test;

import com.frame.commons.dtime.DateUtils;
import com.frame.commons.dtime.DtimeFormat;

public class DateUtilsTest {

	@Test
	public void testIsLeap() {
		System.out.println(DateUtils.isLeap(2000) ) ;
		System.out.println(DateUtils.isLeap(1900));
	}

	
	@Test
	public void testCurrent() {
		System.out.println(DateUtils.current()) ;
		
	}

	@Test
	public void testCurrentString() {
		System.out.println(DateUtils.current(DtimeFormat.ALL_FORMAT)) ;
	}

	@Test
	public void testIsCurrentLeap() {
		System.out.println(DateUtils.isCurrentLeap());
	}

	@Test
	public void testMonths() {
		System.out.println(DateUtils.months());
	}

	@Test
	public void testLeaveMonthsOfCurrent() {
		System.out.println(DateUtils.leaveMonthsOfCurrent());
	}

	@Test
	public void testCurrentDays() {
		System.out.println(DateUtils.dayOfYear());
		System.out.println(DateUtils.yearDays());
	}

	@Test
	public void testNextDays() {
		System.out.println(DateUtils.nextYear());
	}
	
	@Test
	public void testNewDate() {
		System.out.println(DateUtils.newDate(1,2,3));
		
	}
	
	@Test
	public void testDayOfYear() {
		System.out.println(DateUtils.dayOfYear());
	}
	
	@Test
	public void testlastTest() {
		System.out.println(DateUtils.lastDayOfMonth());
		System.out.println(DateUtils.daysBeforeCurrent());
		System.out.println(DateUtils.daysAfterCurrent());
		
		
	}
	
	
}
