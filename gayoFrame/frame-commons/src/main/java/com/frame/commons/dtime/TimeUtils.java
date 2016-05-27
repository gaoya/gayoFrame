package com.frame.commons.dtime;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 时间工具类
 * @author admin
 *
 */
public class TimeUtils extends DateUtils {
	/**
	 * 得到一年中的所以月份
	 * @return
	 */
	public static List<Integer> hoursOfDay() {
		startTime  = 1 ;
		endTime  = 24 ;
		
		return fromAtoB(startTime, endTime) ;
	}
	/**
	 * 得到今天剩下的时间
	 * 	包括本月
	 * @return
	 */
	public static List<Integer> leaveHoursOfCurrent() {
		if (isEmpty()) {
			current() ;
		}
		startTime = hour +1 ;
		endTime = 25 ;
		
		return fromAtoB(startTime, endTime) ;
	}
	
	/**
	 * 得到下一年的日期
	 */
	public static Integer nextHour() {
		if (isEmpty()) {
			current() ;
		}
		return (hour =+ 1) >=25 ? 1 : hour ;
	}
	/**
	 * 根据一个时间得到另一个时间
	 * @return
	 */
	public static Date newTime(Integer addHours ,Integer addMinites ,Integer addSecends) {
		if (calendar ==null) {
			current() ;
		}
		calendar.add(Calendar.HOUR_OF_DAY, addHours) ;
		calendar.add(Calendar.MINUTE, addMinites) ;
		calendar.add(Calendar.SECOND, addSecends) ;
		
		return calendar.getTime()  ;
	}
	
	public static Date newTime(Integer addHours) {
		return newTime(addHours , 0 , 0 ) ;
	}
}
